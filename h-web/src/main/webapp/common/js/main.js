(function () {
    "use strict";

    var navItems = $(".nav-wrapper").children("li");

    navItems.hover(function(){
        this.className = "cur";
        console.log(this);
    }, function() {
        this.className = "";
    });



})();