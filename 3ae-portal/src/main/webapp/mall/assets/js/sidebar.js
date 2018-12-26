(function() {
/***********侧边栏优化改版0511 start******************************/
    /*在线联系动画初始化*/
    
    //当点击跳转链接后，回到页面顶部位置
    $(".Rtop").click(function(){
        $('body,html').animate({scrollTop:0},500);
        return false;
    });


    /*
    *   左侧升降梯
    */
    (function elevator() {
        var index;
        //绑定字段id
        var elevator = $("#elevator");
        var floors = $(".floor");
        var li = elevator.find("li");

        if(elevator.length == 0 || floors.length == 0) {
            console.log("该页面不支持升降梯");
            return 0;
        }
        
        //自身宽高
        var elevatorHeight = elevator.height();
        var elevatorWidth = elevator.width();

        //页面宽高
        var winHeight = $(window).height();
        var winWidth = $(window).width();

        //计算位置
        var top = (winHeight-elevatorHeight)/2;
        var left = (winWidth-1200)/2-elevatorWidth - 5;
        
        elevator.css({"position":"fixed","top":top,"left":left});
        $(window).resize(function(){
            winWidth = $(this).width();
            left = (winWidth-1200)/2-elevatorWidth - 5;
            elevator.css({"left":left});
        });
        
        
        if(floors.length == 0) {
            console.log(floors);
            return 0;
        }

        //计算楼层高度
        var floorTop = $(".floor").offset().top - top;

        //点击scroll
        li.click(function(){
            index = $(this).index();
            top = parseInt(floors.eq(index).offset().top-60);
            $("body,html").stop().animate({scrollTop:top});
        });
        
        //监听scroll,左侧导航改变样式
        $(window).scroll(function() {
            var scrollTop = $(document).scrollTop();
            var caseLike = $(".brand-list").offset().top;
            var content = $(".brand-wrap").offset().top;

            if (scrollTop>floorTop) {
                elevator.stop().animate({"opacity":1});
                elevator.css({'*display':'block','display':'block'});
            } else{
                elevator.stop().animate({"opacity":0});
                elevator.css({'*display':'none','display':'none'});
            }
            
            if (scrollTop>caseLike-600) {
                elevator.stop().animate({"opacity":0});
                elevator.css({'*display':'none','display':'none'});
            }
            
            for (var i=0;i<floors.length;i++) {
                top =  parseInt(floors.eq(i).offset().top);
                if(scrollTop >= top-500){
                    li.eq(i).addClass("active").siblings().removeClass("active");
                }
            }
            
            //顶部导航
            if (scrollTop>content) {
                $(".scroll-navbar").addClass("show");
            } else{
                $(".scroll-navbar").removeClass("show");
            }
        });
    })();
})();