
(function list() {

   (function() {
      var success = document.getElementsByClassName('status-3');

      var apply = document.getElementsByClassName('apply')[0];
      var applyForm = document.getElementsByClassName('apply-form')[0];
      var cancel = document.getElementsByClassName('cancel')[0];

      apply.addEventListener('click', function() {
         console.log("block");

         applyForm.style.display = 'block';
      })

      cancel.addEventListener('click', function() {
         console.log("none");

         applyForm.style.display = 'none';
      })
   })();

   var limit = 6;
   var current = 0;
   var data = [];

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

      for(var i = 0 ; i < limit; i++) {
         current++;
         expensesList += `<li class="items">
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

   nextPage.addEventListener('click', function() {
      current += limit;
      
      getData(data, current, limit)
   })

   prePage.addEventListener('click', function() {
      
      if(current <= 0) {
         alert('到头了。请翻下一页');
         return;
      }
      current -= limit;
      getData(data, current, limit)
   })
   

})();