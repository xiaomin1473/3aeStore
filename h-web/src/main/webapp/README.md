# 南京睿实rd59项目————代码分析

--------------------------------

## 先放一张小图片

![刍易——知难行易](common/imgs/icons/logo.ico)

## 9月5号

目录结构如下（E:\version\njrs_rd59\rd59___2018.9.5）

    ```

        rd59-debug                                          主目录
            config                                                  配置目录
                config.properties                                           配置参数
                logo.jpg                                                    公司logo
                parse.properties                                            消防报警参数
            src                                                     代码目录
                main                                                        主目录
                    java->com->njrs->rd59                                       com.njrs.rd59
                        agent                                                           agent
                            parse                                                           参数
                                impl->tcp                                                       tcp参数
                                    Parse1.java                                                     设备序列号解析
                                AbstractParse.java                                                  报文解析父类
                                ParseFactory.java                                                   报文解析工厂
                            AgentServer.java                                                    Agent服务
                            AgentTcpHandler.java                                                TCP通信Handler
                        constants                                                       constants
                            ErrorCode.java                                                  错误码
                        util
                            DataUtil.java                                                   数据处理
                            PropertyUtil.java                                               properties文件解析
                        window
                            MainFrame.java                                                  主界面
                    resources
                test
            target
            logback.xml                                             日志文件
            pom.xml                                                 pom文件
    ```

## 9月10号

目录结构如下（E:\version\njrs_rd59\rd59___2018.9.10_0.0.3）

    ```

        rd59-debug                                          主目录
            config                                                  配置目录
                config.properties                                           配置参数
                logo.jpg                                                    公司logo
                parse.properties                                            消防报警参数
            src                                                     代码目录
                main                                                        主目录
                    java->com->njrs->rd59                                       com.njrs.rd59
                        agent                                                           agent（代理）
                            parse                                                           参数
                                impl->tcp                                                       impl->tcp参数
                                    ++DenyReply.java                                                ++否认回复
                                        Parse1.java                                                     设备序列号解析
                                    ++Parse0.java                                                   ++设备注册
                                    AbstractParse.java                                              报文解析父类
                                    ParseFactory.java                                               报文解析工厂
                            AgentServer.java                                                    Agent服务
                            AgentTcpHandler.java                                                TCP通信Handler
                        constants                                                       constants（常量）
                        ++Constants.java                                                ++公共常用类
                            ErrorCode.java                                                  错误码
                        ++GlobalData.java                                               ++全局数据
                        util                                                            util（工具）
                            DataUtil.java                                                   数据处理
                        ++NetWorkUtil.java                                              ++网络
                            PropertyUtil.java                                               properties文件解析
                        window
                        ++CameraPanel.java                                              ++视频
                        ++ComTabPanel.java                                              ++tab组件
                            MainFrame.java                                                  主界面
                        ++ObjType0Panel.java                                            ++消防设施注册
                    resources
                        ++logback.xml                                             日志文件
                test
            target
        --logback.xml                                             日志文件
            pom.xml                                                 pom文件
    ```

## 程序流程

测试当前Markdown是否支持流程图  
rd59-debug  

```flow

    st=>start: start
    load_conf_files=>operation: 加载配置文件
    port=>operation: 获取配置文件端口号
    UI_manager=>operation: 加载窗口配置
    is_TCPbind=>condition: TCP连接
    agent_server=>operation: 启动代理服务器
    is_ret=>condition: 服务启动
    start_OK=>operation: 服务在 10010 启动！
    logger=>operation: 日志输出错误
    e=>end

    st->load_conf_files->port->UI_manager->is_TCPbind
    is_TCPbind(true)->agent_server->is_ret
    is_TCPbind(false)->logger->e
    is_ret(false)->logger->e
    is_ret(true)->start_OK->e

&```

```mermaid

graph TB
    id1(圆角矩形)--普通线-->id2[矩形]
    subgraph 子图表
        id2==粗线==>id3{菱形}
        id3-.虚线.->id4>右向旗帜]
        id3--无箭头---id5((圆形))
    end

\```
