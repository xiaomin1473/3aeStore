var user      = $("#user");
var user_tips = $("#user + span");
var user_reg  = /^(?!_)(?!.*?_$)[a-zA-Z_\u4e00-\u9fa5]{2,12}$/;

var tel      = $("#tel");
var tel_tips = $("#tel + span");
var tel_reg  = /^1[34578]\d{9}$/;

var mail      = $("#mail");
var mail_tips = $("#mail + span");
var mail_reg  = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;

//用户名失焦验证
user.blur(function(){
    if("" == user.val()) {
        user_tips.html("称呼不能为空！");
        return false;
    } 
    else if (!user_reg.test(user.val())) {
        user_tips.html("称呼不能少于2位,不能多于12位,也不能为中英文其他字符！");
        return false;
    }
    else if (user_reg.test(user.val())) {
        user_tips.html("√");
    }
});

//手机号失焦验证
tel.blur(function(){
    if("" == tel.val()) {
        tel_tips.html("手机号不能为空！");
        return false;
    } 
    else if (!tel_reg.test(tel.val())) {
        tel_tips.html("手机号格式不正确！");
        return false;
    }
    else if (tel_reg.test(tel.val())) {
        tel_tips.html("√");
    }
});


//邮箱失焦验证
mail.blur(function(){
    if("" == mail.val()) {
        mail_tips.html("邮箱不能为空！");
        return false;
    } 
    else if (!mail_reg.test(mail.val())) {
        mail_tips.html("邮箱格式不正确！");
        return false;
    }
    else if (mail_reg.test(mail.val())) {
        mail_tips.html("√");
    }
});

function get_checked(obj){
    for(i=0;i<obj.length;i++){
        if(obj[i].checked){
            var a = obj[i].value;
        }
    }
    alert(a);
};

$("#submit").on("click", function() {
    var intention = document.getElementsByName('intention');
    var country = document.getElementsByName('country');
    var time = document.getElementsByName('time');
    var swip = false;
    var iswip = false;
    var tswip = false;

    var bunch = $("input[name='bunch']:checked").parent().find("span").html();

    


    if ("" == mail.val() || "" == tel.val() || "" == user.val()) {
        alert("您有未填写的必填信息，请您务必填写，否则我们无法联系到您。");
        return;
    } 


    // for (var i=0; i<country.length; i++) { 
    //     if(country[i].checked) {
    //         break;
    //     } else {
    //         iswip = true;
    //     }
    // }

    // if ( iswip == true) {
    //     alert("国家为必填选项！");
    //     return;
    // }
    
    // for (var i=0; i<intention.length; i++) { 
    //     if(intention[i].checked) {
    //         break;
    //     } else {
    //         swip = true;
    //     }
    // }

    // if ( swip == true) {
    //     alert("意向为必填选项！");
    //     return;
    // }


    // if (bunch == '是') {
    //     for (var i=0; i<time.length; i++) { 
    //         if(time[i].checked) {
    //             break;
    //         } else {
    //             tswip = true;
    //         }
    //     }

    //     if ( tswip == true) {
    //         alert("您选择了打算置业移民，就必填时间！");
    //         return;
    //     }
    // }

    

    var obj = {};
    obj.user = $("#user").val();
    obj.tel = $("#tel").val();
    obj.mail = $("#mail").val();
    obj.sex = $("input[name='sex']:checked").parent().find("span").html();
    var country = document.getElementsByName('country');
    var s= " "; 
    for(var i=0; i<country.length; i++){ 
        if(country[i].checked) s += country[i].value + "  "; //如果选中，将value添加到变量s中 
    } 
    obj.country = s;
    var intention = document.getElementsByName('intention');
    var ai= " "; 
    for(var i=0; i<intention.length; i++){ 
        if(intention[i].checked) ai += intention[i].value + "  "; //如果选中，将value添加到变量s中 
    } 
    obj.intention = ai;
    obj.age = $("input[name='age']:checked").parent().find("span").html();
    obj.price = $("input[name='price']:checked").parent().find("span").html();
    obj.bunch = $("input[name='bunch']:checked").parent().find("span").html();
    obj.time = $("input[name='time']:checked").parent().find("span").html();
    obj.other = $("#textarea").val();
    console.log(obj);
    $.ajax({
        type: "post",
        url:"static/form.php",
        data:obj,
        success:function(data){
            alert("发送成功，点击确定刷新页面");
            document.getElementById("form").reset(); 
            window.location.reload();
        },
        error:function(data){
            alert("发送失败，点击确定刷新页面，再不行请联系管理员");
            document.getElementById("form").reset(); 
        }
    })
    
});