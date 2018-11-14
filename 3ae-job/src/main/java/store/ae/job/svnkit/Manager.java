package store.ae.job.svnkit;

import java.io.File;

import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNCopySource;
import org.tmatesoft.svn.core.wc.SVNInfo;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNStatus;
import org.tmatesoft.svn.core.wc.SVNStatusType;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import com.google.gson.Gson;

public class Manager {
	private static SVNClientManager svnClientManager;
	private static final Gson gson = new Gson();
	
	/*
     * 导入-import
     * @throws SVNException
     */
    private static void doImport() throws SVNException{
        SVNProperties svnProperties = new SVNProperties();
        boolean useGlobalIgnores = true;
        boolean ignoreUnknownNodeTypes = true;
        SVNCommitInfo svnCommitInfo = svnClientManager.getCommitClient().doImport(new File("E:\\repos\\svn"),SVNURL.parseURIEncoded("svn://www.svn999.com/yixianhong.YF_RD59/00 文档"),"初始化导入",svnProperties,useGlobalIgnores,ignoreUnknownNodeTypes,SVNDepth.INFINITY);
        System.out.println("执行import操作成功，导入结果：" + gson.toJson(svnCommitInfo));
    }
    
    /**
     * 检出-checkout
     * 参数：
     *  仓库地址
     *  本地Working Copy地址
     *  Peg Revision
     *  Revision
     *  检出深度，一般递归检出
     *  是否允许没有版本的障碍物，true的话允许，false不允许，false在checkout的时候如果有障碍物就会停止检出，所以一般是true
     * 返回值：long 当前版本号
     * @throws SVNException
     */
    @SuppressWarnings("unused")
	private static void doCheckout() throws SVNException{
        long nowRevision = svnClientManager.getUpdateClient().doCheckout(SVNURL.parseURIEncoded("https://wlyfree-PC:8443/svn/testRepository/trunk"),new File("E:\\svnWorkspace\\projectWorkingCopy"), SVNRevision.HEAD,SVNRevision.HEAD,SVNDepth.INFINITY,true);
        System.out.println("执行checkout操作成功，当前检出的版本号是：" + nowRevision);
    }
    
    /**
     * 创建目录-mkdir
     * @throws SVNException
     */
    @SuppressWarnings("unused")
	private static void doMkDir() throws SVNException{
        String commitMessage = "创建一个目录";
        SVNCommitInfo svnCommitInfo = svnClientManager.getCommitClient().doMkDir(new SVNURL[]{SVNURL.parseURIEncoded("https://wlyfree-PC:8443/svn/testRepository/trunk/aaa"),SVNURL.parseURIEncoded("https://wlyfree-PC:8443/svn/testRepository/trunk/bbb")},commitMessage);
        System.out.println("执行mkdir操作成功，操作结果：" + gson.toJson(svnCommitInfo));
    }
    
    /**
     * 提交-commit
     * commit更改一个文件时，如果文件本身存在，则需要提交其父目录
     * @throws SVNException
     */
    private static void doCommit() throws SVNException{
        File[] files = new File[]{new File("E:\\repos\\svn\\a.txt")};
        //没有版本号的先执行add操作
        for(File tempFile : files){
            SVNStatus status = svnClientManager.getStatusClient().doStatus(tempFile,true);
            System.err.println(status);
            if(status == null || status.getContentsStatus() == SVNStatusType.STATUS_UNVERSIONED) {
                System.out.println("文件" + tempFile.getName() + "无版本号");
                svnClientManager.getWCClient().doAdd(tempFile, false, false, false, SVNDepth.INFINITY, false, false);
            }
        }
        //执行commit操作
        svnClientManager.getCommitClient().setIgnoreExternals(false);
        SVNProperties svnProperties = new SVNProperties();
        String[] changeLists = new String[]{};
        SVNCommitInfo svnCommitInfo = svnClientManager.getCommitClient().doCommit(files,false,"提交操作",svnProperties,changeLists,false,false,SVNDepth.fromRecurse(true));
        System.out.println("执行commit操作成功，操作结果：" + gson.toJson(svnCommitInfo));
    }
    
    /**
     * 更新-update
     * @throws SVNException
     */
    @SuppressWarnings("unused")
	private static void doUpdate() throws SVNException{
        long nowRevision = svnClientManager.getUpdateClient().doUpdate(new File("E:\\svnWorkspace\\projectWorkingCopy"),SVNRevision.HEAD, SVNDepth.INFINITY,true,false);
        System.out.println("执行update操作成功，当前版本号：" + nowRevision);
    }
    
    /**
     * 锁定-lock
     * @throws SVNException
     */
    @SuppressWarnings("unused")
	private static void doLock() throws SVNException{
//        svnClientManager.getWCClient().doLock(new SVNURL[]{SVNURL.parseURIEncoded("https://wlyfree-PC:8443/svn/testRepository/trunk/bbb/aa.txt")},true,"给文件加锁");
        svnClientManager.getWCClient().doLock(new File[]{new File("E:\\svnWorkspace\\projectWorkingCopy\\bbb\\aa.txt")},true,"给文件加锁");
        System.out.println("给文件加锁成功");
    }
    
    /**
     * 删除-delete
     * @throws SVNException
     */
    @SuppressWarnings("unused")
	private static void doDelete() throws SVNException{
        SVNCommitInfo svnCommitInfo = svnClientManager.getCommitClient().doDelete(new SVNURL[]{SVNURL.parseURIEncoded("https://wlyfree-PC:8443/svn/testRepository/trunk/bbb"),SVNURL.parseURIEncoded("https://wlyfree-PC:8443/svn/testRepository/trunk/b.txt")},"执行删除操作，删除一个目录bbb一个文件b.txt");
        System.out.println("执行delete操作成功，操作结果：" + gson.toJson(svnCommitInfo));
    }
    
    /**
     * 复制-copy
     * @throws SVNException
     */
    @SuppressWarnings("unused")
	private static void doCopy() throws SVNException{
        SVNCopySource svnCopySource1 = new SVNCopySource(SVNRevision.HEAD,SVNRevision.HEAD,SVNURL.parseURIEncoded("https://wlyfree-PC:8443/svn/testRepository/trunk/aaa/aa.txt"));
        SVNCopySource svnCopySource2 = new SVNCopySource(SVNRevision.HEAD,SVNRevision.HEAD,SVNURL.parseURIEncoded("https://wlyfree-PC:8443/svn/testRepository/trunk/aaa/bb.txt"));
        svnClientManager.getCopyClient().doCopy(new SVNCopySource[]{svnCopySource1,svnCopySource2},new File("E:\\svnWorkspace\\projectWorkingCopy\\bbb"),false,false,true);
        System.out.println("执行copy操作成功");
    }
    
    /**
     * 状态-status
     * @throws SVNException
     */
    @SuppressWarnings("unused")
	private static void doStatus() throws SVNException{
        SVNStatus svnStatus = svnClientManager.getStatusClient().doStatus(new File("E:\\svnWorkspace\\projectWorkingCopy\\a.txt"),true);
        System.out.println("执行status操作成功，操作结果：" + gson.toJson(svnStatus));
    }
    
    /**
     * 信息-info
     * @throws SVNException
     */
    @SuppressWarnings("unused")
	private static void doInfo() throws SVNException{
        SVNInfo svnInfo = svnClientManager.getWCClient().doInfo(new File("E:\\svnWorkspace\\projectWorkingCopy\\a.txt"),SVNRevision.HEAD);
        System.out.println("执行info操作成功，操作结果：" + gson.toJson(svnInfo));
    }
	
	public static void main(String[] args) throws Exception{
        //1.根据访问协议初始化工厂
        DAVRepositoryFactory.setup();
        
        //2.使用默认选项
        ISVNOptions isvnOptions = SVNWCUtil.createDefaultOptions(true);
        
        //3.初始化权限
        String username = "njrszhaoyuming";
        String password = "wf3302978";
        char[] pwd = password.toCharArray();
        ISVNAuthenticationManager isvnAuthenticationManager = SVNWCUtil.createDefaultAuthenticationManager(username,pwd);
        
        //4.创建SVNClientManager的实例
        svnClientManager = SVNClientManager.newInstance(isvnOptions,isvnAuthenticationManager);
        
      //=========================================demo start=======================================
        //1.导入-import
        doImport();
        //2.检出-checkout
//      doCheckout();
        //3.创建目录-mkdir
//      doMkDir();
        //4.提交-commit
        doCommit();
        //5.更新-update
//        doUpdate();
        //6.切换分支-switch
        //7.添加-add，在commit中有体现，提交前，没有加入版本控制的文件需要加入版本控制
        //8.锁定-lock
//        doLock();
        //9.删除-delete
//        doDelete();
        //10.拷贝-copy
//        doCopy();
        //11.状态-status
//        doStatus();
        //12.信息-info
//        doInfo();
	}
}
