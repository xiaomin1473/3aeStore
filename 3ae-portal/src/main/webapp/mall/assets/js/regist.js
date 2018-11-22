//表单验证
(function(){
        
    //正则验证对象
    var reg={
        email:/^[a-zA-Z0-9_\.]+@[a-zA-Z0-9-]+[\.a-zA-Z]+$/,
        ftname:/^[a-zA-Z]{1,12}$/,
        ltname:/^[a-zA-Z]{1,12}$/,
        ori:/^[a-zA-Z0-9]{1,30}$/,
        title:/^[a-zA-Z0-9]{1,30}$/,
        country:/^[a-zA-Z]{1,20}$/,
        tel:/^1[34578]\d{9}$/,
        mob:/^1[34578]\d{9}$/,
    }

    //错误提示对象
    var errorObj={
        email:'Email format error!',
        ftname:'Name format error!',
        ltname:'Name format error!',
        ori:'Ori format error!',
        title:'Title format error!',
        country:'Ctry format error!',
        tel:'Tel format error!',
        mob:'Mobel format error!',
    }

    //必填对象
    var emptyObj={
        email:'Email can\'t be empty',
        ftname:'Name can\'t be empty',
        ltname:'Name can\'t be empty',
        ori:'Ori can\'t be empty',
        title:'Title can\'t be empty',
        country:'Ctry can\'t be empty',
        tel:'Tel can\'t be empty',
        mob:'',
    }

    var user      = $("#user");
    var user_tips = $("#user_tips");
    var user_reg  = /^[a-zA-Z]{6,12}$/;
    //用户名失焦验证
    user.blur(function(){
        if("" == user.val()) {
            user_tips.html("用户名不能为空");
            return false;
        } 
        else if (!user_reg.test(user.val())) {
            user_tips.html("用户名不能少于6位,不能多于12位。只能是字母");
            return false;
        }
        else if (user_reg.test(user.val())) {
            user_tips.html("——————————  √  ———————————");
        }
    });


})();