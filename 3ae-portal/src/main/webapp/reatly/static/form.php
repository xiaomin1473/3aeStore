<?php

$obj=$_POST;

if(empty($obj)){
    echo "没有表单数据，请返回之前页面重新进行提交数据！";
}
else {
    require_once("email/main.php");

    $to = 'Jacky.Feng@ailerealty.com';
    // $to = 'poseidanevents@gmail.com';

    $title = "爱乐居问卷";

    $content = "<h3>爱乐居问卷</h3>".
               "<span>称呼：".$obj['user']."</span><br>".
               "<span>手机号：".$obj['tel']."</span><br>".
               "<span>邮箱：".$obj['mail']."</span><br>".
               "<span>性别：".$obj['sex']."</span><br>".
               "<span>年龄：".$obj['age']."</span><br>".
               "<span>国家选择：".$obj['country']."</span><br>".
               "<span>意向：".$obj['intention']."</span><br>".
               "<span>预算：".$obj['price']."</span><br>".
               "<span>是否置业/移民：".$obj['bunch']."</span><br>".
               "<span>时间：".$obj['time']."</span><br>".
               "<span>其他想法：".$obj['other']."</span><br>";

    sendMail($to, $title, $content);
}