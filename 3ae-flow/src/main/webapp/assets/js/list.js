/****************************************************************
 * 
 * 
 * 
 *                      费用申报列表
 * 
 * 
 * 
 */



/****************************************************************
 * 
 * 
 *                      弹出申报页面
 * 
 * 
 */
(function() {
   var success = document.getElementsByClassName('status-3');

   var applyForm = document.getElementsByClassName('apply-form')[0];

   $('#apply-btn').click(function() {
      console.log("block");

      applyForm.style.display = 'block';
   })

   $('#cancel').click(function() {
      console.log("none");

      applyForm.style.display = 'none';
   })
})();



/****************************************************************
 *
 *
 *                         全局变量
 * 
 * 
 */

var limit = 6;
var current = 0;
var data = [];


/****************************************************************
 *
 *
 *                        时间格式化
 * 
 * 
 */
var format = function(time, format){
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
}

/****************************************************************
 *
 *
 *                       发送已完成请求
 * 
 * 
 */
Ae.trans.AJAX({
   type: "GET",
   url: "/user/expenses/apply/list",
   async: true,
}, callback)

function callback(xmls) {
   jsonName = xmls.responseText;
   data = JSON.parse(jsonName);

   current = 0;
   limit = 6;
   getData(data, current, limit);
}


function getData(data, current, limit) {
   var expensesList = '';
   var arr,reg = new RegExp("(^| )"+"UserPermit"+"=([^;]*)(;|$)");
   arr=document.cookie.match(reg);


   for(var i = 0 ; i < limit;) {
      current++;

      //判断费用归于哪个分类
      if(arr[2] == 0 ) {

      } else if(arr[2] == 1010000 && "YX" == data[current].identifier.substring(0, 2)) {

      } else if(arr[2] == 1020000 && "ZZ" == data[current].identifier.substring(0, 2)) {

      } else if(arr[2] == 1030000 && "YF" == data[current].identifier.substring(0, 2)) {

      } else if(arr[2] == 1040000 && "YY" == data[current].identifier.substring(0, 2)) {

      } else if(arr[2] == 1050000 && "CG" == data[current].identifier.substring(0, 2)) {

      } else {
         continue;
      }
      
      i++
      expensesList += `<li class="items" onclick="turnToPage('detail')">
         <div class="items-header">
            费用申请编号：` + data[current].identifier +`
         </div>
         <div class="items-body">
            类型：` + data[current].ascription + `<br>
            金额：￥` + data[current].amount + `<br>
            项目：`+ data[current].matter + `<br>
            收款单位： ` + data[current].receiveCompany + `
         </div>
         <div class="items-footer">
            申请人：`+ data[current].ascriptor +  `  日期：` + format(data[current].expensesGmt,'yyyy-MM-dd') + `
            <button class="status-3 frt">已完成</button>
         </div>
      </li>`
   }
   var expensesBody = document.getElementsByClassName('expenses-body')[0];
   expensesBody.innerHTML = expensesList;
}









$('#nextPage').click(function() {
   current += limit;
   
   getData(data, current, limit)
})

$('#prePage').click(function() {
   
   if(current <= 0) {
      alert('到头了。请翻下一页');
      return;
   }
   current -= limit;
   getData(data, current, limit)
})

$('#put').click(function put() {
   var context = $("#apply").serialize();
   console.log("序列化为url格式为："+context);
   //context = decodeURIComponent(context,true);

   console.log("反列化为url格式为："+context);

      Ae.trans.AJAX({
         type: "POST",
         url: "/user/expenses/apply/add",
         async: true,
         context: context,
         contentType: "application/x-www-form-urlencoded"
      }, callback)

      function callback(xmls) {
         jsonName = xmls.responseText;
         jsonName = JSON.parse(jsonName);
      }
})







/*****************************************************
 * 
 * 
 * 
 * 
 * 
 * 
 */


var menu = document.getElementsByClassName('status-list')[0];

menu.childNodes.forEach((e) => {
   e.addEventListener("click", function() {
      this.parentNode.childNodes.forEach((e)=>{
         e.className = 'items'
      })
      this.className = 'items cur'
   })
})