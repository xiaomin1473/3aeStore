#!/usr/bin/env bash
# 编译+部署web站点

# 需要配置如下参数
# 项目路径，在Execute Shell中配置项目路径，pwd 就可以获得该项目路径
# export PROJ_PATH=这个jenkins任务在部署机器上的路径

# 输入你的环境上tomcat的全路径
# export TOMCAT_APP_PATH=/var/www/

# 输入你的环境上netty的全路径
# export NETTY_APP_PATH=/var/netty/

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

killNetty()
{
	pid=`ps -ef|grep netty|grep -v grep |awk '{print $2}'`
	echo "netty ID list :$pid"
	if [ "$pid"="" ]
	then
		echo "no netty pid alive"
	else
		kill -9 $pid
	fi
}

cd $PROJ_PATH/3ae-parent
mvn clean install

# 停tomcat
killTomcat

# 停netty
killNetty


# 删除原有工程
# rm -rf $TOMCAT_APP_PATH/app/agent/agent
rm -rf $TOMCAT_APP_PATH/app/answer/answer.war
rm -rf $TOMCAT_APP_PATH/app/api/api.war
# rm -rf $TOMCAT_APP_PATH/app/agent/agent
rm -rf $TOMCAT_APP_PATH/app/answer/answer
rm -rf $TOMCAT_APP_PATH/app/api/api
# rm -rf $TOMCAT_APP_PATH/app/ROOT

rm -rf $TOMCAT_APP_PATH/app/test/custom/portal/ROOT.war
rm -rf $TOMCAT_APP_PATH/app/test/custom/user/ROOT.war
rm -rf $TOMCAT_APP_PATH/app/test/admin/admin.war
rm -rf $TOMCAT_APP_PATH/app/test/custom/portal/ROOT
rm -rf $TOMCAT_APP_PATH/app/test/custom/user/ROOT
rm -rf $TOMCAT_APP_PATH/app/test/admin/admin

rm -rf $TOMCAT_APP_PATH/app/main/custom/portal/ROOT.war
rm -rf $TOMCAT_APP_PATH/app/main/custom/user/ROOT.war
rm -rf $TOMCAT_APP_PATH/app/main/admin/admin.war
rm -rf $TOMCAT_APP_PATH/app/main/custom/portal/ROOT
rm -rf $TOMCAT_APP_PATH/app/main/custom/user/ROOT
rm -rf $TOMCAT_APP_PATH/app/main/admin/admin

##
# 复制新的工程
cp $PROJ_PATH/3ae-parent/3ae-admin/target/3ae-admin.war $TOMCAT_APP_PATH/app/main/admin/admin.war
cp $PROJ_PATH/3ae-parent/3ae-user/target/3ae-user.war $TOMCAT_APP_PATH/app/main/custom/user/ROOT.war
cp $PROJ_PATH/3ae-parent/3ae-portal/target/3ae-portal.war $TOMCAT_APP_PATH/app/main/custom/portal/ROOT.war

cp -r $PROJ_PATH/3ae-parent/3ae-admin/target/3ae-admin $TOMCAT_APP_PATH/app/main/admin/admin
cp -r $PROJ_PATH/3ae-parent/3ae-user/target/3ae-user $TOMCAT_APP_PATH/app/main/custom/user/ROOT
cp -r $PROJ_PATH/3ae-parent/3ae-portal/target/3ae-portal $TOMCAT_APP_PATH/app/main/custom/portal/ROOT

cp $PROJ_PATH/3ae-parent/3ae-admin/target/3ae-admin.war $TOMCAT_APP_PATH/app/test/admin/admin.war
cp $PROJ_PATH/3ae-parent/3ae-user/target/3ae-user.war $TOMCAT_APP_PATH/app/test/custom/user/ROOT.war
cp $PROJ_PATH/3ae-parent/3ae-portal/target/3ae-portal.war $TOMCAT_APP_PATH/app/test/custom/portal/ROOT.war

cp -r $PROJ_PATH/3ae-parent/3ae-admin/target/3ae-admin $TOMCAT_APP_PATH/app/test/admin/admin
cp -r $PROJ_PATH/3ae-parent/3ae-user/target/3ae-user $TOMCAT_APP_PATH/app/test/custom/user/ROOT
cp -r $PROJ_PATH/3ae-parent/3ae-portal/target/3ae-portal $TOMCAT_APP_PATH/app/test/custom/portal/ROOT

cp $PROJ_PATH/3ae-parent/3ae-api/target/3ae-api.war $TOMCAT_APP_PATH/app/api/api.war
cp $PROJ_PATH/3ae-parent/3ae-answer/target/3ae-answer.war $TOMCAT_APP_PATH/app/answer/answer.war

cp -r $PROJ_PATH/3ae-parent/3ae-api/target/3ae-api $TOMCAT_APP_PATH/app/api/api
cp -r $PROJ_PATH/3ae-parent/3ae-answer/target/3ae-answer $TOMCAT_APP_PATH/app/answer/answer
# cp $PROJ_PATH/3ae-parent/3ae-agent/target/3ae-agent-jar-with-dependencies.jar $NETTY_APP_PATH/www/app/agent/agent
# cp $PROJ_PATH/3ae-parent/3ae-server/target/3ae-server-jar-with-dependencies.jar $NETTY_APP_PATH/server/server.jar


# 启动Tomcat
sh /opt/apache-tomcat-8.5.35/bin/startup.sh

echo "this is lastest version"