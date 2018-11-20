//表单验证
    function login(){
        var userName = $("#user").val();
        var userPwd = $("#pwd").val();
        if(userPwd == '' || userName == '') {
            $("#message").html("用户名或密码不能为空");
            return;
        }
        Params = userName + '/' + userPwd;
        serverUrl = 'http://api.3ae.store';
        $.ajax({
            dataType:"json",
            type: "post",
            url: serverUrl + '/user/login/' + Params,
            data: {"test":"sss"},
            success: function(data) {
                console.log(data);
                if(data.success == false) {
                    console.log(data.error);
                    $("#message").html(data.error);
                } else if(data.success) {
                    console.log(data.success);
                    console.log(data.data);
                    console.log("cookie ==>>" + data.data.userName + ": " + data.data.token);
                    $.cookie(data.data.userName, data.data.token);
                    $.cookie('name','rr',{expires:3});
                    console.log($.cookie('name'));
                    console.log($.cookie(data.data.userName));
                }
            },
            error:function(data) {
                console.log(data);
            }
        });
    }
    