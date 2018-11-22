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




var hub = document.getElementById('hub');

setTimeout("hub.className += ' feed-re'", 2500);
setTimeout("hub.className += ' dply-no'", 3500);

;(function menu_btn() {
    var status = false;
    var menu_btn = $('#menu_btn');
    var nav_wrapper = $('.nav-wrapper');

    menu_btn.on("click", function() {
        if ( status == false ) {
            nav_wrapper.css('display','block');
            menu_btn.removeClass('nav-btn-op');
            menu_btn.addClass('nav-btn-x');
            status = true;
        }
        else if ( status == true ) {
            nav_wrapper.css('display','none');
            menu_btn.removeClass('nav-btn-x');
            menu_btn.addClass('nav-btn-op');
            status = false;
        }
    });

    $('.nav-wrapper').on("click", function() {
        nav_wrapper.css('display','none');
        menu_btn.removeClass('nav-btn-x');
        menu_btn.addClass('nav-btn-op');
        status = false;
    });

})();

;(function menu_btn() {
    var status = false;
    var menu_btn = $('#menu_btnw');
    var nav_wrapper = $('.nav-wrapper');

    menu_btn.on("click", function() {
        if ( status == false ) {
            nav_wrapper.css('display','block');
            menu_btn.removeClass('nav-btn-opb');
            menu_btn.addClass('nav-btn-x');
            status = true;
        }
        else if ( status == true ) {
            nav_wrapper.css('display','none');
            menu_btn.removeClass('nav-btn-x');
            menu_btn.addClass('nav-btn-opb');
            status = false;
        }
    });

    $('.nav-wrapper').on("click", function() {
        nav_wrapper.css('display','none');
        menu_btn.removeClass('nav-btn-x');
        menu_btn.addClass('nav-btn-opb');
        status = false;
    });

})();


$("#btn_open").on("click", function(){
    $(".alert").show();
})

$("#close").on("click", function(){
    $(".alert").hide();
})

$('.link-us').on("click", function() {
    $('#register-form').css('display','block');
});

$('.x').on("click", function() {
    $('#register-form').css('display','none');
    
});

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
