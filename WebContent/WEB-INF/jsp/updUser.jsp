<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改用户</title>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/MIMS/css/style.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/MIMS/js/nav.js"></script>
</head>
<body>
	<div class="background" style="padding-top: 50px;height: 600px;">
		<h2 class="text-center" style="margin-bottom: 20px;">修改用户</h2>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-offset-3" style="text-align: center;" for="user_name">用户名：</label>
			<div class="col-sm-4 input-group">
				<input type="text" class="form-control" aria-describedby="basic-addon1" id="upd_username" name="upd_username">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-offset-3" style="text-align: center;" for="e_mail">电子邮箱：</label>
			<div class="col-sm-4 input-group">
				<input type="text" class="form-control" aria-describedby="basic-addon1" id="upd_email" name="upd_email">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-offset-3" style="text-align: center;" for="phone">手机号码：</label>
			<div class="col-sm-4 input-group">
				<input type="text" class="form-control" aria-describedby="basic-addon1" id="upd_phone" name="upd_phone">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-offset-3" style="text-align: center;" for="sex">性别：</label>
			<div class="col-sm-4 input-group">
				<input type="text" class="form-control" aria-describedby="basic-addon1" id="upd_sex" name="upd_sex">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-offset-3" style="text-align: center;" for="age">年龄：</label>
			<div class="col-sm-4 input-group">
				<input type="text" class="form-control" aria-describedby="basic-addon1" id="upd_age" name="upd_age">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-offset-3" style="text-align: center;" for="height">身高：</label>
			<div class="col-sm-4 input-group">
				<input type="text" class="form-control" aria-describedby="basic-addon1" id="upd_height" name="upd_height">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 col-sm-offset-3" style="text-align: center;" for="weight">体重：</label>
			<div class="col-sm-4 input-group">
				<input type="text" class="form-control" aria-describedby="basic-addon1" id="upd_weight" name="upd_weight">
			</div>
		</div>
		
		<div class="text-center">
			<button id="upd_user" type="button" class="btn btn-default" onclick="updUser()">提交</button>
		</div>
	</div>
</body>
</html>