<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录界面</title>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/MIMS/css/style.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$('button').click(function() {
		$.ajax({
			url:'/MIMS/log',
			type:'post',
			data:{
				"admin_name":$("#admin_name").val(),
				"password":$("#password").val()
			},
			success:function(data){
				if (data.msg == 0) {
					alert("用户名或密码错误！")
				} else if (data.msg == 1) {
					window.location.href = "/MIMS/userManage";
				}
			}
		});
	});
});
</script>
</head>
<body>
	<div class="container">
		<form>
			<div class="col-sm-4 col-sm-offset-4 login">
				<h2 class="page-header">用户登录</h2>
				<div class="form-group">
					<label for="admin_name">用户名</label>
					<div class="input-group">
						<span class="glyphicon glyphicon-user input-group-addon" id="basic-addon1"></span>
						<input type="text" class="form-control" aria-describedby="basic-addon1" id="admin_name" name="admin_name" placeholder="admin_name">
					</div>
				 </div>
		
				 <div class="form-group">
				 	<label for="password">密码</label>
				 	<div class="input-group">
				 		<span class="glyphicon glyphicon-lock input-group-addon"></span>
						<input type="password" class="form-control" id="password" name="password" placeholder="password">
					</div>
				 </div>
							
				 <div class="text-center">
				 	<button type="button" class="btn btn-default">登录</button>
				 </div>
			 </div>
		 </form>
	</div>
</body>
</html>