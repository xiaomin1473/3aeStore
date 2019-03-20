Global = {


   sider: function () {
      var siderCtrl = document.getElementsByClassName("sider-ctrl");
      var swt = true;

      function move(e, data) {
         e.innerHTML = data[0];
         e.parentElement.style.width = data[1];
         e.parentElement.nextElementSibling.style.paddingLeft = data[2];
         e.parentElement.className = data[3];
      }

      siderCtrl[0].onclick = function() {

         if(swt) {
            move(this, ["▶", "42px", "42px", "sider close"]);
            swt = false;
         }
         else {
            move(this, ["◀", "200px", "200px", "sider"]);
            swt = true;
         }
      }
   },

   menu: function() {

      $('.sider-list li').bind("click", function() {
         //var query = location.href.split("/")[3];
         that = this
         $('.sider-list li').each(function () {
            this.className = this == that ? 'items cur' : 'items'
          });
      })
      
   },

   getPage: function (n, container, url) {
      var container = document.getElementsByClassName(container)[0];
      var ajax = new XMLHttpRequest();
      ajax.open('get', url);
      ajax.send();
      ajax.onreadystatechange = function () {
         if (ajax.readyState==4 &&ajax.status==200) {
            container.innerHTML = ajax.responseText
      　　}
      }
      function addCSS(n) {
         var links = document.getElementsByTagName('link');
         var link = document.createElement('link');
         link.href= "./assets/css/" + n + ".css";
         link.rel = "stylesheet";
         links[0].parentNode.removeChild(links[5])
         document.getElementsByTagName('head')[0].appendChild(link);
      }

      function addJS(n) {
         
         var scripts = document.getElementsByTagName('script');
         var script = document.createElement('script');
         script.src= "./assets/js/" + n + ".js";
         scripts[0].parentNode.removeChild(scripts[0]);
         document.getElementsByTagName('head')[0].appendChild(script);
      }

      addCSS(n);
      addJS(n);
   },
   

   turnToPage: function (n) {
      switch(n) {
         
      }
   },
   popTo: function() {
      window.addEventListener("popstate", function() {
         Global.to();
     });
   },

   to: function(url) {
      // var host = window.location.host;
      // console.log(host);
      // var urls = host + url;
      var urls = location.href.split("/")[3];

      if(urls.indexOf('?')) {
         var originUrl = urls;
         urls =  urls.split("?")[0];
         url = '/' + urls;
         
         for(var i = 0; i < Router.length; i++) {
            if(Router[i].url == url) {
   
               this.getPage(Router[i].name, "context", Router[i].component);
               history.pushState({title: Router[i].title}, Router[i].title, originUrl); 
            }
         }
      } else {
         url = '/' + urls;

         for(var i = 0; i < Router.length; i++) {
            if(Router[i].url == url) {

               this.getPage(Router[i].name, "context", Router[i].component);
               history.pushState({title: Router[i].title}, Router[i].title, Router[i].url); 
            }
         }
      }

      $('.sider-list li a').each(function () {
         if(urls === this.href.split("/")[3]) {
            this.parentElement.className = 'items cur'
         } else {
            this.parentElement.className = 'items'
         }
      })
   
   },


   setCookie: function(cookieName, cookie, times) {
      var exp = new Date();
      exp.setTime(exp.getTime() + 24*60*60*1000*times);
      document.cookie = cookieName + "="+ escape (cookie) + ";expires=" + exp.toGMTString();
   },

   getCookie: function(cookieName) {
      var arr,reg = new RegExp("(^| )"+cookieName+"=([^;]*)(;|$)");
      if(arr=document.cookie.match(reg)) {
         return unescape(arr[2]);
      } else {
         return null;
      }
   },
   removeCookie: function(cookieName) {
      var date = new Date();
      date.setTime(date.getTime() - 1);
      var arr,reg = RegExp('(^| )'+cookieName+'=([^;]+)(;|$)');
      if (arr = document.cookie.match(reg)) {
         var delValue = decodeURIComponent(arr[2]);
      }

      if (delValue) {
         document.cookie = cookieName+'='+delValue+';expires='+date.toGMTString();
      }
   },

   checkUserLogin: function() {
      var cookie = this.getCookie("Token");
      if(cookie) {
         return cookie;
      }
      else {
         window.location.href = "/login.html";
      }
   },

   logout: function() {
      var logout = document.getElementById("logout");
      that = this
      logout.addEventListener('click', function() {
         
         that.removeCookie("Token");
         
         window.location.href = "/login.html";

      })
   },

   
   
   _init: function() {
      this.to();
      this.popTo();
      this.sider();
      this.menu();
      this.checkUserLogin();
      this.logout();
   }
}