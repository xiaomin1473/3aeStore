/* ********************************************************************* *
**                                                                       *
**                                                                       *
**                    progress_name : mobile_JS                          *
**                           author : sid                                *
**                          version : 1.0                                *
**                      create_time : 2017.12.7                          *
**                                                                       *
**                                                                       *
 * ********************************************************************* */





/******************************************************************
**
**
**                          显示隐藏密码
**  
*/   

    function pwdShow() {
        var pwdEye  = document.getElementById('switch');
        var pwd     = document.getElementById('pwd');
        var temp    = true;

        pwdEye.onclick = function() {
            if(temp) {
                pwdEye.className = 'op-eye';
                pwd.type = 'text';
                temp = !temp;
            } else {
                pwdEye.className = 'eye';
                pwd.type = 'password';
                temp = !temp;
            }
        }
    }

//--------------- pwdShow  end

    

/******************************************************************
**
**
**                      获取验证码 倒计时60s
**
*/

    var countdown = 60;
    function settime(obj) {
        if (countdown == 0) {
            obj.removeAttribute("disabled");
            obj.value="获取验证码";
            countdown = 60;
            return;
        } else {
            obj.setAttribute("disabled", true);
            obj.value="重新发送(" + countdown + ")";
            countdown--;
        }
        setTimeout(function() {
            settime(obj) 
        },1000)
    }

//--------------- settime  end




/******************************************************************
**
**
**                         显示隐藏菜单
**
*/

    function menu() {
        var menu = document.getElementById('menu');
        var menuBtn = document.getElementById('menu_btn');
        var close = document.getElementById('close');

        menuBtn.onclick = function() {
            menu.style.display = "block";
        }

        menu.onclick = function() {
            menu.style.display = "none";
        }

        close.onclick = function() {
            menu.style.display = "none";
        }

    }

//--------------- settime  end