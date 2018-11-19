# 服务器集群架构

## 架构大纲

> 整个部署流程如下：
>准备工作 —》 各个环境单独配置、互相依赖 —》 服务部署

### 操作系统

```text
   1.centOS 升级系统内核到最新稳定版
   2.升级系统内所有的软件依赖
   3.升级GCC编译器
   4.安装links软件
   5.配置hosts文件，增加访问国外网站的速度（github.com）
   ...
```

### 数据存储

```text
   1.mysql
   2.redis
   ……
```

### 语言引擎

```text
   1.jdk
   2.jre
   3.php
   4.v8
   ……
```

### 版本控制

```text
   1.git
   2.svn
   ……
```

### 集成部署

```text
   1.jenkins
   2.docker    curl -s https://get.docker.com|sh
   ……
```

### 编译测试

```text
   1.sonarqube
   ……
```

### 运行维护

```text
   1.tomcat
   2.apache
   3.nginx
   4.node
   5.koa
   ……
```

## 运行环境

### nginx + apache