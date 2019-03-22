Global = {

   cookie: {
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
      }
   },

   menu: function() {

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

      $('.sider-list li a').bind("click", function() {
         //var query = location.href.split("/")[3];
         that = this.parentElement;
         
         $('.sider-list li').each(function () {
            this.className = this == that ? 'items cur' : 'items'
          });
      })
      
   },

   getPage: function (n, container, urls) {
      
      var componentName = this.getComponent(urls);

      if(componentName == "pages") {
         var container = document.getElementsByTagName('body')[0];
         Ae.trans.AJAX({
            type: "GET",
            url: urls,
            async: true,
         }, callback)
   
         function callback(xmls) {
            container.innerHTML = xmls.responseText;
         }
      } else {
         var container = document.getElementsByClassName(container)[0];
         Ae.trans.AJAX({
            type: "GET",
            url: urls,
            async: true,
         }, callback)
   
         function callback(xmls) {
            container.innerHTML = xmls.responseText;
         }
      }

      function addCSS(n) {
         var links = document.getElementsByTagName('link');
         var link = document.createElement('link');
         link.href= Config.alias.cssPath + n + ".css";
         link.rel = "stylesheet";
         links[0].parentNode.removeChild(links[5])
         document.getElementsByTagName('head')[0].appendChild(link);
      }

      function addJS(n) {
         
         var scripts = document.getElementsByTagName('script');
         var script = document.createElement('script');
         script.src= Config.alias.jsPath + n + ".js";
         scripts[0].parentNode.removeChild(scripts[0]);
         document.getElementsByTagName('head')[0].appendChild(script);
      }
      addCSS(n);
      addJS(n);
      
   },

   popTo: function() {
      if(history.pushState) {

         this.to();

         window.addEventListener("popstate", function() {

            Global.to();
      });
      }
   },

   getComponent: function(url) {
      var originUrl = url.split("/")[3];
      var urls = location.href.split("/")[3];

      if(originUrl == urls) {
         return urls;
      } else {
         return originUrl;
      }
   },

   getComponentName: function() {
      var urls = location.href.split("/")[3];

      return urls;
   },

   to: function(url) {
      // var host = window.location.host;
      // console.log(host);
      // var urls = host + url;
      if(!this.checkRouter()) {
         this.getPage("error", "context", "/docker/views/pages/error/404.html");
         return;
      }
      var urls = location.href.split("/")[3];
      if(!urls) { urls = 'portal'; }
      url = '/' + urls;

      if(urls.indexOf('?')) {
         var originUrl = urls;
         urls =  urls.split("?")[0];
         url = '/' + urls;
         
         for(var i = 0; i < Router.length; i++) {
            if(Router[i].url == url) {
               history.pushState({title: Router[i].title}, Router[i].title, originUrl);
               this.getPage(Router[i].name, "context", Router[i].component);
               
            }
         }
      } else {

         for(var i = 0; i < Router.length; i++) {
            if(Router[i].url == url) {
               history.pushState({title: Router[i].title}, Router[i].title, Router[i].url);
               this.getPage(Router[i].name, "context", Router[i].component);
               
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


   

   checkUserLogin: function() {
      var cookie = Global.cookie.getCookie("Token");
      if(cookie) {
         return cookie;
      } else {
         this.getPage("login", "context", "/docker/views/pages/login.html");
      }
   },

   logout: function() {
      var logout = document.getElementById("logout");
      that = this
      logout.addEventListener('click', function() {
         
         Global.cookie.removeCookie("Token");
         
         window.location.href = "/login";

      })
   },

   checkRouter: function() {
      var componentName = this.getComponentName();

      for(var i = 0; i < Router.length; i++) {

         if(Router[i].name == componentName) {
            return true;
         }
      }

      return false;
   },
   
   
   _init: function() {
      /* 

      1. 获取当前的URL，遍历router，查询是否有该组件，若无返回404页面。
      2. 获取当前的Token
      3. 验证用户是否有获取该组件的权限

      
      */
      this.popTo();
      this.checkUserLogin();
      this.menu();
      this.logout();
   }
}