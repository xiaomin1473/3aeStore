(function() {
/***********侧边栏优化改版0511 start******************************/
    /*在线联系动画初始化*/
    
    //当点击跳转链接后，回到页面顶部位置
    $(".Rtop").click(function(){
        $('body,html').animate({scrollTop:0},500);
        return false;
    });

    $(window).scroll(function(){
        var scrollHeight = $(this).scrollTop();
        if(scrollHeight > 100){
            $('.Rtop').removeClass('dn');
            $('.tool-line:last').removeClass('dn');
        }else{
            $('.Rtop').addClass('dn');
            $('.tool-line:last').addClass('dn');
        }
    });


    $('.tel').hover(function () {
        $('.tel img').attr("src", "img/tel_h.png");
        $('.hidetelBox').css("display","block");
    }, function () {
        $('.tel img').attr("src", "img/tel.png");
        $('.hidetelBox').css("display","none");
    });

    $('.mail').hover(function () {
        $('.mail img').attr("src", "img/mail_h.png");
        $('.hidemailBox').css("display","block");
    }, function () {
        $('.mail img').attr("src", "img/mail.png");
        $('.hidemailBox').css("display","none");
    });

    $('.free').hover(function () {
        $('.free img').attr("src", "img/free_h.png");
        $('.hidefreeBox').css("display","block");
    }, function () {
        $('.free img').attr("src", "img/free.png");
        $('.hidefreeBox').css("display","none");
    });

    $('.question').hover(function () {
        $('.question img').attr("src", "img/question_h.png");
        $('.hidequestionBox').css("display","block");
    }, function () {
        $('.question img').attr("src", "img/question.png");
        $('.hidequestionBox').css("display","none");
    });

    $('.tmairuan').hover(function () {
        $('.tmairuan img').eq(0).attr("src", "img/mairuan_h.png");
        $('.hidetmairuanBox').css("display","block");
    }, function () {
        $('.tmairuan img').eq(0).attr("src", "img/mairuan.png");
        $('.hidetmairuanBox').css("display","none");
    });

    $('.Rtop').hover(function () {
        $('.Rtop img').attr("src", "img/top_h.png");
        $('.hideRtop').css("display","block");
    }, function () {
        $('.Rtop img').attr("src", "img/top.png");
        $('.hideRtop').css("display","none");
    });
})();