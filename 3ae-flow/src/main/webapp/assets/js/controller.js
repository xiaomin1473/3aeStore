/****************************************************************
 *
 *
 *                         全局对象
 * 
 * 
 */
var UserController = {
   userList:{},



   getPermit: function(data) {
      if(data == '1030000') {
         return "研发中心"
      } else if(data == "0") {
         return "管理员"
      } else if(data == "1040000") {
         return "运营中心"
      } else if(data == "1") {
         return "普通员工"
      } else {
         return "未分配"
      }
   },


   addUserWrapper: function() {
      var applyForm = document.getElementsByClassName('form-container')[0];
      $('#addUser').click(function() {
         applyForm.style.display = 'block';
      })

      $('#cancelAdd').click(function() {
         applyForm.style.display = 'none';
      })
   },
/****************************************************************
 *
 *
 *                       获取用户列表
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
 *                       发送添加用户请求
 * 
 * 
 */
   addUserRequest: function(context) {
      that = this
      Ae.trans.AJAX({
         type: "POST",
         url: "/user/manage/account/add",
         async: true,
         context: context,
         contentType: "application/x-www-form-urlencoded"
      }, callback)
      
      function callback(xmls) {
         jsonName = xmls.responseText;
         var data = JSON.parse(jsonName);

         console.log(data);
         

         var applyForm = document.getElementsByClassName('form-container')[0];
         applyForm.style.display = 'none';
         that.getdata("/user/list");
      }
   },

/****************************************************************
 *
 *
 *                   封装添加用户信息表单并发送
 * 
 * 
 */
   putAddUserRequest: function() {
      that = this
      $("#putAdd").click(function() {
         var context = $("#control").serialize();
         var userName = $("#userName").val();
         var userPwd = $("#userPwd").val();
         if(!userName || !userPwd) {
            alert("用户名密码不能为空！");
            return;
         } 
         that.addUserRequest(context);
      })
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
            <span class="col-1">`+ data[i].userGroupId + `</span>
            <span class="col-2">`+ data[i].userName + `</span>
            <span class="col-2">`+ this.getPermit(data[i].departmentType) + `</span>
            <span class="col-1">`+ this.getPermit(data[i].userPermit) + `</span>
            <span class="col-2">`+ Ae.date.format(data[i].gmtCreate, 'yyyy-MM-dd') + `</span>
            <span class="col-3">
               <button class="btn-small">查看</button>
               <button class="btn-small">编辑</button>
               <button class="btn-small" onclick="del('`+ data[i].userName +`')">删除</button>
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
      this.addUserWrapper();
      this.putAddUserRequest();
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

function del(userName) {
   Ae.trans.AJAX({
      type: "POST",
      url: "/user/manage/account/del/"+ userName,
      async: true,
   }, callback)
   
   function callback(xmls) {

      alert("删除成功！")

      UserController.getdata("/user/list");
   }
}