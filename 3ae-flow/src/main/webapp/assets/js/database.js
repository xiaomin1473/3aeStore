(function() {
   

   var file = document.getElementById('file');
   

   $('#putFile').click(function() {

      var formData = new FormData();

      formData.append("file", file.files[0]);

      if(!file.files[0]) {
         alert("文件不能为空！");
         return ;
      }
      formData.append("name",file.files[0].name);



      Ae.trans.AJAX({
         type: "POST",
         url: "/user/database/upload/filexls",
         async: true,
         context: formData
      }, callback)

      function callback(xmls) {
         jsonName = xmls.responseText;
         alert(jsonName);
         
      }
   })
})();