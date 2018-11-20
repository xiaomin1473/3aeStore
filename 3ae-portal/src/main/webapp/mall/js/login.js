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
                    $.cookie(data.data.userName, data.data.token, {expires:3});
                    $(location).attr('href', './index.html');
                }
            },
            error:function(data) {
                console.log(data);
            }
        });
    }
    