(function(){
    "use strict";

    (function(){
        var navItems = $(".topbar-wrapper").children("li");
        navItems.hover(function(){
                this.className = "cur";
                console.log(this);
            }, 
            function() {
                this.className = "";
            });
    })();

    (function(){
        var contentItem = $('#brief').children();
        if(0 == contentItem.length) {
            console.log("节点不存在");
            return;
        }
        console.log(contentItem);
        var i = 0;
        var interText = setInterval(function() {
            contentItem[i].className = "ae-riseIn ae-d3";
            i++;
            if(i === contentItem.length) {
                clearInterval(interText);
            }
        }, 100);

        var bgMusic = document.getElementById("music");
        var status = false;

        (function(status) {
            $('#cd').click(function() {
                if (!status) {
                    bgMusic.play();
                    cd.className = "cd circle";
                    status = true;
                } else {
                    bgMusic.pause();
                    cd.className = "cd";
                    status = false;
                }
            })
        })
    })()
})()