git add * 
git commit -m "Change category list"
git push

mvn install

xcopy /s /e /y 3ae-server\target\server.jar app\server
xcopy /s /e /y 3ae-api\target\api.war app\api
xcopy /s /e /y 3ae-answer\target\answer.war app\answer

xcopy /s /e /y 3ae-api\target\api app\api\api
xcopy /s /e /y 3ae-answer\target\answer app\answer\answer

xcopy /s /e /y 3ae-admin\target\admin.war app\main\admin
xcopy /s /e /y 3ae-portal\target\portal.war app\main\custom\portal
xcopy /s /e /y 3ae-user\target\user.war app\main\custom\user

xcopy /s /e /y 3ae-admin\target\admin app\main\admin\admin
xcopy /s /e /y 3ae-portal\target\portal app\main\custom\portal\portal
xcopy /s /e /y 3ae-user\target\user app\main\custom\user\user
