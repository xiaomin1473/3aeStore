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

程序流程：
window

测试当前Markdown是否支持流程图
```flow
st=>start: 开始
op=>operation: My Operation
cond=>condition: Yes or No?
e=>end
st->op->cond
cond(yes)->e
cond(no)->op
&```
