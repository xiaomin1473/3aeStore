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
ExpensesController = {


   /****************************************************************
    *
    *
    *                         全局变量
    * 
    * 
    */
   listRange: {
      limit: 6,
      current: 0,
   },
   data: [],



   applyForm: function() {

      var applyForm = document.getElementsByClassName('form-container')[0];

      $('#apply-btn').click(function() {

         applyForm.style.display = 'block';
      })

      $('#cancel').click(function() {

         applyForm.style.display = 'none';
      })
   },

   checkUserPermit: function(data, current) {
      //判断费用归于哪个分类
      
      var arr,reg = new RegExp("(^| )"+"departmentType"+"=([^;]*)(;|$)");
      arr=document.cookie.match(reg);
      
      // 如果条件成立，继续执行（空语句），否则跳过循环，

      if(arr[2] == 0 ) {
         return 1;
      } else if(arr[2] == 1010000 && "YX" == data[current].identifier.substring(0, 2)) {
         return 1;
      } else if(arr[2] == 1020000 && "ZZ" == data[current].identifier.substring(0, 2)) {
         return 1;
      } else if(arr[2] == 1030000 && "YF" == data[current].identifier.substring(0, 2)) {
         return 1;
      } else if(arr[2] == 1040000 && "YY" == data[current].identifier.substring(0, 2)) {
         return 1;
      } else if(arr[2] == 1050000 && "CG" == data[current].identifier.substring(0, 2)) {
         return 1;
      } else {
         return 0;
      }
   },


   /****************************************************************
    *
    *
    *                       获取申请列表
    * 
    * 
    */
   Apply: function() {
      that = this
      
      function getData(data, current, limit) {
         var expensesList = '';
   
   
         for(var i = 0 ; i < limit;) {
            current++;
            
            if(that.checkUserPermit(data, current) == 1) {

            } else {
               continue;
            }

            i++
            expensesList += `<li class="items">
               <a href="/detail?apply=${data[current].identifier}">
                  <div class="items-header">
                     费用申请编号：${data[current].identifier}
                  </div>
                  <div class="items-body">
                     类型：${data[current].ascription}<br>
                     金额：￥${data[current].amount}<br>
                     项目：${data[current].matter}<br>
                     收款单位：${data[current].receiveCompany}
                  </div>
                  <div class="items-footer">
                     申请人：${data[current].ascriptor}  日期：${Ae.date.format(data[current].expensesGmt,'yyyy-MM-dd')}
                     <button class="status-3 frt">已完成</button>
                  </div>
               </a>
            </li>`
         }
         var expensesBody = document.getElementsByClassName('expenses-body')[0];
         expensesBody.innerHTML = expensesList;
      }

      (function getList() {

         Ae.trans.AJAX({
            type: "GET",
            url: "/user/expenses/apply/list",
            async: true,
         }, callback)
      
         function callback(xmls) {
            jsonName = xmls.responseText;
            data = JSON.parse(jsonName);
      
   
            getData(data, that.listRange.current, that.listRange.limit);
         }
      })();
   },


   /****************************************************************
    *
    *
    *                       获取申请列表
    * 
    * 
    */
   Verify: function() {
      that = this
      
      function getData(data, current, limit) {
         var expensesList = '';
         console.log(data[1]);
   
         for(var i = 0 ; i < limit;) {
            current++;
            
            if(that.checkUserPermit(data, current) == 1) {

            } else {
               continue;
            }

            i++
            expensesList += `<li class="items">
               <a href="/detail?verify=${data[current].identifier}">
                  <div class="items-header">
                     费用申请编号：${data[current].identifier }
                  </div>
                  <div class="items-body">
                     类型：${data[current].ascription}<br>
                     金额：￥${data[current].amount}<br>
                     项目：${data[current].matter}<br>
                     收款单位：${data[current].receiveCompany}
                  </div>
                  <div class="items-footer">
                     申请人：${data[current].ascriptor}  日期：${Ae.date.format(data[current].expensesGmt,'yyyy-MM-dd')}
                     <button class="status-3 frt">已完成</button>
                  </div>
               </a>
            </li>`
         }
         var expensesBody = document.getElementsByClassName('expenses-body')[0];
         expensesBody.innerHTML = expensesList;
      }

      (function getList() {

         Ae.trans.AJAX({
            type: "GET",
            url: "/user/expenses/verify/list",
            async: true,
         }, callback)
      
         function callback(xmls) {
            jsonName = xmls.responseText;
            data = JSON.parse(jsonName);
      
   
            getData(data, that.listRange.current, that.listRange.limit);
         }
      })();
   },


   /****************************************************************
    *
    *
    *                       获取支付列表
    * 
    * 
    */
   Payment: function() {
      that = this
      
      function getData(data, current, limit) {
         var expensesList = '';
         console.log(data[1]);
   
         for(var i = 0 ; i < limit;) {
            current++;
            
            if(that.checkUserPermit(data, current) == 1) {

            } else {
               continue;
            }

            i++
            expensesList += `<li class="items">
               <a href="/detail?payment=${data[current].identifier}">
                  <div class="items-header">
                     费用申请编号：${data[current].identifier}
                  </div>
                  <div class="items-body">
                     金额：￥${data[current].amount}<br>
                     支付方式：${data[current].paymentType}<br>
                     交易行：${data[current].paymentBank}
                  </div>
                  <div class="items-footer">
                     处理人：${data[current].handler }  支付日期：${ Ae.date.format(data[current].paymentGmt,'yyyy-MM-dd') }
                     <button class="status-3 frt">已完成</button>
                  </div>
               </a>
            </li>`
         }
         var expensesBody = document.getElementsByClassName('expenses-body')[0];
         expensesBody.innerHTML = expensesList;
      }

      (function getList() {

         Ae.trans.AJAX({
            type: "GET",
            url: "/user/expenses/payment/list",
            async: true,
         }, callback)
      
         function callback(xmls) {
            jsonName = xmls.responseText;
            data = JSON.parse(jsonName);
      
   
            getData(data, that.listRange.current, that.listRange.limit);
         }
      })();
   },
   


   _init: function() {
      this.Apply();
      this.applyForm();
   }


   









   // $('#nextPage').click(function() {
   //    current += limit;
      
   //    getData(data, current, limit)
   // })

   // $('#prePage').click(function() {
      
   //    if(current <= 0) {
   //       alert('到头了。请翻下一页');
   //       return;
   //    }
   //    current -= limit;
   //    getData(data, current, limit)
   // })

   // $('#put').click(function put() {
   //    var context = $("#apply").serialize();

   //       Ae.trans.AJAX({
   //          type: "POST",
   //          url: "/user/expenses/apply/add",
   //          async: true,
   //          context: context,
   //          contentType: "application/x-www-form-urlencoded"
   //       }, callback)

   //       function callback(xmls) {
   //          jsonName = xmls.responseText;
   //          jsonName = JSON.parse(jsonName);
   //       }
   // })


}

ExpensesController._init();

function getApply() {
   ExpensesController.Apply();
}

function getVerify() {
   ExpensesController.Verify();
}

function getPayment() {
   ExpensesController.Payment();
}

/*****************************************************
 * 
 * 
 * 
 * 
 * 
 * 
 */

setTimeout(function() {
   var menu = document.getElementsByClassName('status-list')[0];

   menu.childNodes.forEach((e) => {
      e.addEventListener("click", function() {
         this.parentNode.childNodes.forEach((e)=>{
            e.className = 'items'
         })
         this.className = 'items cur'
      })
   })
}, 300);

// $('.status-list').find("li").click(function() {
//    $('.status-list').find("li").css("items");
//    //this.css("items cur") 
// })