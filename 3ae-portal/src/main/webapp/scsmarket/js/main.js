$(document).ready(function () {
    var vwidth = document.documentElement.clientWidth || document.body.clientWidth;
    var vheight = document.documentElement.clientHeight || document.body.clientHeight;

    if(vwidth < vheight) {
        $('.index-slide').removeClass('level-slide');
        $('.index-slide').addClass('vertical-slide');
    }
    else if ( vwidth > vheight) {
        $('.index-slide').removeClass('vertical-slide');
        $('.index-slide').addClass('level-slide');
    }
});



// var hub = document.getElementById('hub');

// setTimeout("hub.className += ' feed-re'", 2500);
// setTimeout("hub.className += ' dply-no'", 3500);



// ;(function menu_btn() {
//     var status = false;
//     var menu_btn = $('.navbar');
//     var nav_wrapper = $('.nav-wrapper');

//     menu_btn.on("click", function() {
//         if ( status == false ) {
//             nav_wrapper.css('display','block');
//             menu_btn.removeClass('opbtn');
//             menu_btn.addClass('xbtn');
//             status = true;
//         }
//         else if ( status == true ) {
//             nav_wrapper.css('display','none');
//             menu_btn.removeClass('xbtn');
//             menu_btn.addClass('opbtn');
//             status = false;
//         }
//     });

//     $('.nav-wrapper').on("click", function() {
//         nav_wrapper.css('display','none');
//         menu_btn.removeClass('nav-btn-x');
//         menu_btn.addClass('nav-btn-opb');
//         status = false;
//     });

// })();



$(window).resize(function() {

    var vwidth = document.documentElement.clientWidth || document.body.clientWidth;
    var vheight = document.documentElement.clientHeight || document.body.clientHeight;

    if(vwidth < vheight) {
        $('.index-slide').removeClass('level-slide');
        $('.index-slide').addClass('vertical-slide');
    }
    else if ( vwidth > vheight) {
        $('.index-slide').removeClass('vertical-slide');
        $('.index-slide').addClass('level-slide');
    }
});



;(function menu_btn_2() {
    var temp = true;

    $(".screen-btn").on("click", function() {
        
        if(temp == true) {
            
                $('.screen-btn').removeClass("hide");
            
            setTimeout(function() {
                $('.screen-btn').removeClass("show");
            }, 100)
            temp = false;
        }
        else {

            $(this).addClass("show");

            setTimeout(function() {
                $('.screen-btn').addClass("hide");
            }, 500)
            
            temp = true;
        }
    })
})();


;(function scroll() {
    $('.btn-tips').on('click', function() {
        $("#mCSB_1_container").animate({left:0},1000);
    })
    
})();


function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) { flag = false; break; }
    }
    return flag;
}


;(function mouse_scroll() {
    if(!IsPC()) {return;}

    var startX = 0;
    var endX = 0;
    var moveTo = 0;

    var sleft = 0; $("#mCSB_1_container").css('left');
    parseInt(sleft);
    console.log(sleft);
    function cancle(e){
        // 判断默认行为是否可以被禁用
        if (e.cancelable) {
            // 判断默认行为是否已经被禁用
            if (!e.defaultPrevented) {
                e.preventDefault();
            }
        }
    }
    
    
    //如果是PC
    $(".slider-wrapper").on("mousedown",function(e){
        cancle(e);
        startX = e.pageX;
        $(".slider-wrapper").addClass('dragel');
    })

    $(".slider-wrapper").on("mouseup",function(e){
        cancle(e);
        endX = e.pageX;
        $(".slider-wrapper").removeClass('dragel');
    })

    

    // $(".slider-wrapper").on("mouseup",function(e){
    //     cancle(e);
    //     endX = e.pageX;
    //     $(".slider-wrapper").removeClass('dragel');
    //     moveTo = endX - startX;

        
    //     sleft = $("#mCSB_1_container").css('left');
    //     parseInt(sleft);

    //     console.log(sleft);

    //     if(sleft > 0) {
    //         $("#mCSB_1_container").animate({left: 0}, 500);
    //         return;
    //     } else {
    //         $("#mCSB_1_container").animate({left: moveTo}, 500);

    //         sleft = $("#mCSB_1_container").css('left');
    //         parseInt(sleft);
    //         if(sleft > 0) {
    //             $("#mCSB_1_container").animate({left: 0}, 500);
    //         }
            
    //     }
        
    // })

    // if(sleft > 0) {
    //     $("#mCSB_1_container").animate({left: 0}, 500);
    // }


})();
