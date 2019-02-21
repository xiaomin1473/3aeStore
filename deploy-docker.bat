xcopy /s /e /y 3ae-api\target\api.war app\app\api

xcopy /s /e /y 3ae-api\target\api app\app\api\api

xcopy /s /e /y 3ae-flow\target\oa.war app\app\main\oa
xcopy /s /e /y 3ae-flow\target\oa app\app\main\oa\oa

xcopy /s /e /y 3ae-admin\target\admin.war app\app\main\admin
xcopy /s /e /y 3ae-portal\target\portal.war app\app\main\custom\portal
xcopy /s /e /y 3ae-user\target\user.war app\app\main\custom\user

xcopy /s /e /y 3ae-admin\target\admin app\app\main\admin\admin
xcopy /s /e /y 3ae-portal\target\portal app\app\main\custom\portal\portal
xcopy /s /e /y 3ae-user\target\user app\app\main\custom\user\user

docker build -t registry.cn-qingdao.aliyuncs.com/3ae/store .

docker push registry.cn-qingdao.aliyuncs.com/3ae/store