#!/usr/bin/env bash
# 编译+部署web站点

# 需要配置如下参数
# 项目路径，在Execute Shell中配置项目路径，pwd 就可以获得该项目路径
# export PROJ_PATH=这个jenkins任务在部署机器上的路径

# 输入你的环境上tomcat的全路径
# export TOMCAT_APP_PATH=/var/www/

### base 函数

killTomcat()
{
	pid=`ps -ef|grep tomcat|grep java|awk '{print $2}'`
	echo "tomcat ID list :$pid"
	if [ "$pid"="" ]
	then
		echo "no tomcat pid alive"
	else
		kill -9 $pid
	fi
}

cd $PROJ_PATH/h-parent
mvn clean install

# 停tomcat
killTomcat

# 删除原有工程
rm -rf $TOMCAT_APP_PATH/ROOT
rm -f $OMCAT_APP_PATH/ROOT.war
rm -f $TOMCAT_APP_PATH/h-web.war
rm -f $TOMCAT_APP_PATH/h-user.war
rm -f $TOMCAT_APP_PATH/h-portal.war

# 复制新的工程
cp $PROJ_PATH/h-parent/h-web/target/h-web-0.0.1-SNAPSHOT.war $TOMCAT_APP_PATH/h-web.war
cp $PROJ_PATH/h-parent/h-web/target/h-web-0.0.1-SNAPSHOT.war $TOMCAT_APP_PATH/h-web1.war
cp $PROJ_PATH/h-parent/h-user/target/h-user-0.0.1-SNAPSHOT.war $TOMCAT_APP_PATH/h-user.war
cp $PROJ_PATH/h-parent/h-portal/target/h-portal-0.0.1-SNAPSHOT.war $TOMCAT_APP_PATH/h-portal.war

cd $TOMCAT_APP_PATH/
mv h-web1.war ROOT.war

# 启动Tomcat
cd /opt/apache-tomcat-8.5.33

sh bin/startup.sh