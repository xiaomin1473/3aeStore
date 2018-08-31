
killTomcat()
{
	pid = `ps -ef|grep tomcat|grep java|awk '{print $2}'`
	echo "tomcat ID list :$pid"
	if [ "$pid" = ""]
	then
		echo "no tomcat pid alive"
	else
		kill -9 $pid
	fi
}

cd PROJ_PATH/h-parent/h-web
mvn clean install

cd PROJ_PATH/h-parent/h-user
mvn clean install

cd PROJ_PATH/h-parent/h-portal
mvn clean install

killTomcat

rm -rf TOMCAT_APP_PATH/ROOT
rm -f TOMCAT_APP_PATH/ROOT.war
rm -f TOMCAT_APP_PATH/h-web.war
rm -f TOMCAT_APP_PATH/h-user.war
rm -f TOMCAT_APP_PATH/h-portal.war

cp PROJ_PATH/h-parent/h-web/target/h-web.war TOMCAT_APP_PATH/
cp PROJ_PATH/h-parent/h-web/target/h-web1.war TOMCAT_APP_PATH/
cp PROJ_PATH/h-parent/h-user/target/h-user.war TOMCAT_APP_PATH/
cp PROJ_PATH/h-parent/h-portal/target/h-portal.war TOMCAT_APP_PATH/

cd TOMCAT_APP_PATH/
mv h-web1.war ROOT.war

# ??Tomcat
cd /opt/apache-tomcat-8.5.33

sh bin/startup.sh





