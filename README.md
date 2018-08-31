# njrs

感谢身边的家人;<br>
感谢南京睿实消防设备有限公司；<br>
感谢身边的领导；<br>
感谢带我的小哥；<br>
感谢身边的同事；<br>
感谢身边的朋友。<br>
<br>
<br>
## Situation & Task

  之前有留下来的很多电商项目File，由于各方面原因上家公司不做了，而那耗费了很多心力、脑力、体力做出来的Demo我不忍心丢弃,想按照行业要求和编码规范完成属于自己的电商项目。由于工作需求限制，现在需从零到一建立一个完善的物联网系统，因此，这两个大型系统需要在我“三脚猫的功夫”的能力下创建一个公共的web架构，也可以随着项目发展和个人能力成长来逐渐完善成一套大型易扩展的系统。
<br>
## Action

我对这是我建立的一个Web架构目录<br>
<br>
<br>
最近也在学习如何利用Netyy框架去构建一个SOA、RPC类似dubbo这样架构<br>
主流的架构Spring cloud<br>
<br>
## web架构
```
h-common      共享资源文件
h-pojo        对象实体
h-dao         Data Access Object数据访问对象
h-api         ESB总线为模型对外的接口，内含REST目录
h-service     服务（拆微服务）
h-web         web目录（大型网站的后台系统）之后是否需要拆，CMS、OA、ERP等
h-portal      大型网站的门户系统
h-user        大型网站的个人中心系统
h-channel     底层通信
```
