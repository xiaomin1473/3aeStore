

/****************************************************************
 *
 *
 *                         全局对象
 * 
 * 
 */
var UserController = {
   userList:{},

/****************************************************************
 *
 *
 *                         全局函数
 * 
 * 
 */
   format: function(time, format){
      var t = new Date(time);
      var tf = function(i){return (i < 10 ? '0' : '') + i};
      return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
      switch(a){
            case 'yyyy':
               return tf(t.getFullYear());
               break;
            case 'MM':
               return tf(t.getMonth() + 1);
               break;
            case 'mm':
               return tf(t.getMinutes());
               break;
            case 'dd':
               return tf(t.getDate());
               break;
            case 'HH':
               return tf(t.getHours());
               break;
            case 'ss':
               return tf(t.getSeconds());
               break;
            }
      }) 
   },

   getPermit: function(data) {
      if(data == '1030000') {
         return "研发中心"
      } else if(data == "0") {
         return "管理员"
      } else if(data == "1040000") {
         return "运营中心"
      } else {
         return "未分配"
      }
   },


   addUser: function() {

      $('#addUser').click(function() {
         var applyForm = document.getElementsByClassName('form-container')[0];
         applyForm.style.display = 'block';
      })
   },

   cancel: function() {
      $('#cancel').click(function() {
         var applyForm = document.getElementsByClassName('form-container')[0];
   
         applyForm.style.display = 'none';
      })
   },
/****************************************************************
 *
 *
 *                       发送已完成请求
 * 
 * 
 */
   getdata: function(urls) {
      that = this
      Ae.trans.AJAX({
         type: "GET",
         url: urls,
         async: true,
      }, callback)
      
      function callback(xmls) {
         jsonName = xmls.responseText;
         that.userList = JSON.parse(jsonName);

         that.wrapList(that.userList);
      }
   },

/****************************************************************
 *
 *
 *                       包装数据
 * 
 * 
 */ 
   wrapList: function(data) {
      var controllerList = document.getElementById('controllerList');
      var es = '';
      for(var i = 0; i < data.length; i++) {
         es +=`<li class="items">
            <span class="col-1">`+ data[i].userId + `</span>
            <span class="col-2">`+ data[i].userGroupId + `</span>
            <span class="col-2">`+ data[i].userName + `</span>
            <span class="col-2">`+ this.getPermit(data[i].userPermit) + `</span>
            <span class="col-2">`+ this.format(data[i].gmtCreate, 'yyyy-MM-dd') + `</span>
            <span class="col-3">
               <button class="btn-small">查看</button>
               <button class="btn-small">编辑</button>
               <button class="btn-small" onclick="alert('删除成功')">删除</button>
            </span>
         </li>`
      }
      controllerList.innerHTML = es;
   },

/****************************************************************
 *
 *
 *                       初始化函数
 * 
 * 
 */
   _init: function() {
      this.getdata("/user/list");
      this.addUser();
      this.cancel();
   }
}

UserController._init();

/*****************************************************
 * 
 * 
 * 
 * 
 * 
 * 
 */


var menu = document.getElementsByClassName('control-menu')[0];

menu.childNodes.forEach((e) => {
   e.addEventListener("click", function() {
      this.parentNode.childNodes.forEach((e)=>{
         e.className = 'items'
      })
      this.className = 'items cur'
   })
})