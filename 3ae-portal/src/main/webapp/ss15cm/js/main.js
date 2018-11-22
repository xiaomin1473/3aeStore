var second = document.getElementById('second');
var minute = document.getElementById('minute');
var hours = document.getElementById('hours');
var time_block = document.getElementById('time_block');
var black_content = document.getElementById('black_content');
var sheng = document.getElementById('sheng');
var shi = document.getElementById('shi');
var fift = document.getElementById('fift');
var line = document.getElementById('line');
var text = document.getElementById('text');
var text1 = document.getElementById('text1');
var text2 = document.getElementById('text2');
var text3 = document.getElementById('text3');
var text4 = document.getElementById('text4');
var wenan = document.getElementById('wenan');
var btn2 = document.getElementById('btn2');

setTimeout("text.style = 'display: none'",12000);

var next = function next() {
    second.className += " feed-re";
    setTimeout("minute.className += ' feed-re'",500);
    setTimeout("hours.className += ' feed-re'",1000);
    setTimeout("black_content.className += ' feed-re'",1500);
    setTimeout("black_content.style = 'display: none'",2500);
    setTimeout("line.style = 'display: none'",3500);
    setTimeout("text.style = 'display: none'",3500);
    setTimeout("text1.style = 'display: none'",3500);
    setTimeout("text2.style = 'display: none'",3500);
    setTimeout("text3.style = 'display: none'",3500);
    setTimeout("text4.style = 'display: none'",3500);
    setTimeout("time_block.className += ' feed-re'",2500);
    setTimeout("time_block.style = 'display: none'",5500);
    setTimeout("black_background.className += ' mymove60-re'",3500);
    // setTimeout("black_background.style = 'display: none'",7500);
    setTimeout("black_content.style = 'display: block'",3500);
    setTimeout("black_content.className -= ' feed-re'",3500);
    setTimeout("sheng.className = 'sheng2'",3500);
    setTimeout("shi.className = 'shi2'",3500);
    setTimeout("fift.className = 'fift2'",3500);
    setTimeout("wenan.style = 'display: block'",5000);
    setTimeout("wenan.className += ' feed'",5000);
    setTimeout("btn2.style = 'display: block'",6000);
    setTimeout("btn2.className += ' feed'",6000);
}

var next2 = function next2() {
    setTimeout("black_background.className = 'black-background mymove100'");
    setTimeout("wenan.style = 'display: none'", 2000);
    setTimeout("btn2.className += ' feed-re'");
    setTimeout("btn2.style = 'display: none'", 3000);
    setTimeout("sheng.className += ' mymovesheng'",500);
    setTimeout("shi.className += ' mymoveshi'",500);
    setTimeout("fift.className += ' mymovefift'",500);
}



var timer=null;
var num=1;
timer=setInterval(function(){
    $("#text"+num).addClass("feed-re");
    setTimeout(function(){
        if(num==4){
            num=1;
            $("#text"+num).removeClass("feed-re").addClass("feed");
        }else{
            num++;
            if(document.getElementById("text"+num).className.indexOf("feed-re")>-1){
                $("#text"+num).removeClass("feed-re").addClass("feed");
            }else{
                $("#text"+num).addClass("feed");
            }
        }
    },6000)
},6000)

var timer2=null;
var num2=1;
timer2=setInterval(function(){
    $("#coo-text"+num2).addClass("feed-re");
    setTimeout(function(){
        if(num2==2){
            num2=1;
            $("#coo-text"+num2).removeClass("feed-re").addClass("feed");
        }else{
            num2++;
            if(document.getElementById("coo-text"+num2).className.indexOf("feed-re")>-1){
                $("#coo-text"+num2).removeClass("feed-re").addClass("feed");
            }else{
                $("#coo-text"+num2).addClass("feed");
            }
        }
    },6000)
},6000)