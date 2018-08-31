<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
</head>

<body>
	<h1>欢迎登陆</h1>
	<form action="./login" method="POST">
		<input id="name" type="text" name="name" placeholder="name"><br>
		<input id="pwd" type="text" name="pwd" placeholder="password">
		<input id="btn" type="submit">
	</form>
	
	<div class="context" id="context3">
		THIS IS YOUR WORLD!
	</div>
</body>

<script src="https://cdn.bootcss.com/jquery/1.12.2/jquery.min.js"></script>
<script>
	/* var obj ={};
	obj.name = $("#name").val();
	obj.pwd = $("pwd").val();

	$("#btn").click(function(){
		ctx=$.ajax({
			type: "POST",
			url:"/h-web/login",
			data: obj,
			success: function() {
				$("#context").html(ctx.responseText);
			}
		});
	}) */
</script>