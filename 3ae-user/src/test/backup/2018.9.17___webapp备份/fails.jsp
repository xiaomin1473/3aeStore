<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<head>
		<meta charset="UTF-8">
		<title>fails</title>
	</head>
	
	<body>
		<h1>登录失败！</h1>
		<h5><span id="show">3</span>秒后跳转到登录页</h5>
	</body>
	
	<script>
		
	var t=2;
		setInterval("refer()", 1000); 
		function refer(){ 
		 if(t==0){ 
		 location.href="/login.jsp";
		 } 
		 document.getElementById('show').innerHTML=t;
		 t--;
	} 
	
	</script>