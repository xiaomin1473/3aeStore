package com.ae.job.svnkit;

import com.google.gson.Gson;
import org.tmatesoft.svn.core.*;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.ISVNEditor;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.io.diff.SVNDeltaGenerator;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * 提交到仓库
 * 这块看官方demno的意思如果不用权限认证，会使用a session user name作为提交的author，但是我试了会报错401，author required~
 * 本例是基于初始仓库图A转换为目标仓库图B的过程，我们需要执行的操作有：
 * 1.删除nodeB/itemB1
 * 2.编辑nodeC/itemC1
 * 3.新增nodeC/itemC2，并设置itemC2的文件属性
 * 4.新增nodeB子节点nodeD
 */
public class Repository {
    public static void main(String[] args) throws Exception{
        //1.根据访问协议初始化工厂
        DAVRepositoryFactory.setup();;
        //2.初始化仓库，由于我们所有的操作都是基于nodeB节点以下的，所以我们将nodeB作为本次操作的root节点
        String url = "https://wlyfree-PC:8443/svn/svnkitRepository2/trunk/nodeB";
        SVNRepository svnRepository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
        //3.初始化权限
        String username = "wly";
        String password = "wly";
        char[] pwd = password.toCharArray();
        ISVNAuthenticationManager isvnAuthenticationManager = SVNWCUtil.createDefaultAuthenticationManager(username,pwd);
        svnRepository.setAuthenticationManager(isvnAuthenticationManager);
        //====================================DEMO START=========================================
        ISVNEditor editor = null;
        long revisionNo = -1; //指定版本号为最新版本
        //4.1.删除nodeB/itemB1
        try{
            //获取编辑器
            editor = svnRepository.getCommitEditor("delete file",null,true,null);
            String itemB1Path = "itemB1";//要删除的文件路径
            SVNCommitInfo svnCommitInfo = deleteFile(editor,revisionNo);//执行删除并返回执行结果
            System.out.println("执行删除操作的返回结果：" + svnCommitInfo);
        }catch (SVNException e){
            //发生异常需要终止操作
            editor.abortEdit();
            e.printStackTrace();;
        }
        //4.2.编辑nodeC/itemC1
        try{
            //获取编辑器
            editor = svnRepository.getCommitEditor("modify file",null,true,null);
            SVNCommitInfo svnCommitInfo = modifyFile(editor,revisionNo);
            System.out.println("执行编辑操作的返回结果：" + svnCommitInfo);
        }catch(SVNException e){
            //发生异常需要终止操作
            editor.abortEdit();
            e.printStackTrace();;
        }
        //4.3.新增nodeC/itemC2，并设置itemC2的文件属性
        try{
            editor = svnRepository.getCommitEditor("add file",null,true,null);
            SVNCommitInfo svnCommitInfo = addFile(editor,revisionNo);
            System.out.println("执行新增文件操作的返回结果：" + svnCommitInfo);
            //校验nodeC/itemC2的属性是否成功设置进去
            SVNProperties s = new SVNProperties();
            svnRepository.getFile("nodeC/itemC2",-1,s,null);
            Gson gson = new Gson();
            System.err.println(gson.toJson(s));
        }catch (SVNException e){
            editor.abortEdit();
            e.printStackTrace();
        }

        //4.4.新增nodeB子节点nodeD
        try{
           editor = svnRepository.getCommitEditor("add dir",null,true,null);
           SVNCommitInfo svnCommitInfo = addDir(editor,revisionNo);
           System.out.println("执行新增目录操作的返回结果：" + svnCommitInfo);
        }catch (SVNException e){
            editor.abortEdit();
            e.printStackTrace();
        }
    }

    /**
     *  删除文件
     *  @param editor 编辑器
     *  @param revisionNo 修订版版本号
     *  @return  SVNCommitInfo 提交结果信息
     *  @throws SVNException
     */
    private static SVNCommitInfo deleteFile(ISVNEditor editor,long revisionNo) throws SVNException{
        // 进入Root节点，即nodeB
        editor.openRoot(revisionNo);
        //4.3.删除文件
        editor.deleteEntry("itemB1",revisionNo);
        //操作完成要关闭编辑器，并返回操作结果
        return editor.closeEdit();
    }

    /**
     * 编辑文件
     *  @param editor 编辑器
     *  @param revisionNo 修订版版本号
     *  @return  SVNCommitInfo 提交结果信息
     *  @throws SVNException
     */
    private static SVNCommitInfo modifyFile(ISVNEditor editor,long revisionNo) throws SVNException{
        // 进入Root节点，即nodeB
        editor.openRoot(revisionNo);
        //.进入nodeC节点
        editor.openDir("nodeC",revisionNo);
        // 编辑nodeC/itemC1的内容
        String itemC1Path = "nodeC/itemC1";//路径都是相对于root的
        editor.openFile(itemC1Path,revisionNo);
        //确保客户端这个文件的内容和服务端的是一样的，如果不一致的话是不允许提交的。底层实现使用MD5
        String baseChecksum = null;
        editor.applyTextDelta(itemC1Path,baseChecksum);
        //提交文件变更的数据,windows默认是100kb大小
        byte[] oldData = new byte[]{};
        byte[] newData = null;
        try {
            newData = "我来测试一下编辑2".getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream baseData = new ByteArrayInputStream(oldData);
        ByteArrayInputStream workingData = new ByteArrayInputStream(newData);
        SVNDeltaGenerator svnDeltaGenerator = new SVNDeltaGenerator();//100KB-windows generator
        String checksum = svnDeltaGenerator.sendDelta(itemC1Path,baseData,0,workingData,editor,true);
        // 关闭文件
        editor.closeFile(itemC1Path,checksum);
        // 关闭目录nodeC
        editor.closeDir();
        // 关闭根目录nodeB
        editor.closeDir();
        // 关闭编辑器，并返回执行结果
        return editor.closeEdit();
    }

    /**
     * 新增文件
     * @param editor
     * @param revisionNo
     * @return
     * @throws SVNException
     */
    private static SVNCommitInfo addFile(ISVNEditor editor,long revisionNo) throws SVNException{
        // 进入Root节点，即nodeB
        editor.openRoot(revisionNo);
        //.进入nodeC节点
        editor.openDir("nodeC",revisionNo);
        // 新增itemC2文件
        editor.addFile("nodeC/itemC2",null,revisionNo);
        //确保客户端这个文件的内容和服务端的是一样的，如果不一致的话是不允许提交的。底层实现使用MD5
        String itemC2Path = "nodeC/itemC2";
        String baseChecksum = null;
        editor.applyTextDelta(itemC2Path,baseChecksum);
        //提交文件变更的数据,windows默认是100kb大小
        byte[] oldData = new byte[]{};//旧数据
        byte[] newData = null;//新数据
        try {
            newData = "我来测试一下 - addFile".getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream baseData = new ByteArrayInputStream(oldData);
        ByteArrayInputStream workingData = new ByteArrayInputStream(newData);
        SVNDeltaGenerator svnDeltaGenerator = new SVNDeltaGenerator();//100KB-windows generator
        String checksum = svnDeltaGenerator.sendDelta(itemC2Path,baseData,0,workingData,editor,true);
        //设置文件的属性，key是字符串，值被包装成SVNProperyValue了
        editor.changeFileProperty("nodeC/itemC2","properName1",SVNPropertyValue.create("properValue1"));
        editor.changeFileProperty("nodeC/itemC2","properName2",SVNPropertyValue.create("properValue2"));
        System.out.println("checksum:" + checksum );
        //关闭文件
        editor.closeFile("nodeC/itemC2",checksum);
        //关闭目录nodeC
        editor.closeDir();
        //关闭root
        editor.closeDir();
        return editor.closeEdit();
    }

    /**
     * 新增目录
     * @param editor 编辑器
     * @param revisionNo 修订版本号
     * @return  SVNCommitInfo 提交结果信息
     * @throws SVNException
     */
    private static SVNCommitInfo addDir(ISVNEditor editor,long revisionNo) throws SVNException{
        // 进入Root节点，即nodeB
        editor.openRoot(revisionNo);
        //新增目录
        editor.addDir("nodeD",null,revisionNo);
        editor.closeDir();//nodeD
        editor.closeDir();//nodeB
        return editor.closeEdit();
    }
}