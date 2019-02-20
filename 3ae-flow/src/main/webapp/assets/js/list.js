
(function list() {
   var success = document.getElementsByClassName('status-3');

   var apply = document.getElementsByClassName('apply')[0];

   apply.addEventListener('click', function() {
      console.log("aaa");

      apply.style.display = 'block';
   })



   var cancel = document.getElementsByClassName('cancel')[0];
   var apply = document.getElementsByClassName('apply-form')[0];

   cancel.addEventListener('click', function() {
      console.log("aaa");

      apply.style.display = 'none';
   })

})();
