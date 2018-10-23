<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<head>
		<meta charset="UTF-8">
		<title>success</title>
	</head>
	
	<body>
		<h1>登录成功！</h1>
		<h5><span id="show">3</span>秒后跳转到首页</h5>
	</body>
	
	<script>
	var t=2;
		setInterval("refer()", 1000); 
		function refer(){ 
		 if(t==0){ 
		 location.href="/h-user/index.html";
		 } 
		 document.getElementById('show').innerHTML=t;
		 t--;
	} 
	
	</script>