(function () {
    "use strict";

    
    (function(){
        var navItems = $(".nav-wrapper").children("li");
        navItems.hover(function(){
                this.className = "cur";
                console.log(this);
            }, 
            function() {
                this.className = "";
            });
    })();

    (function(){
        var contentItem = $('.content').children();
        console.log(contentItem);
        var i = 0;
        var interText = setInterval(function() {
            contentItem[i].className = "ae-riseIn ae-d3";
            i++;
            if(i === contentItem.length) {
                clearInterval(interText);
            }
        }, 200);
        
    })();
    
    
    
})();