<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>导航栏</title>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/MIMS/css/style.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/MIMS/js/home.js"></script>
</head>
<body>
	<div class="row bg" style="color: white;height: 700px;">
		<h2 class="page-header text-center">欢迎使用</h2>
		<div class="row" style="font-size: 20px;">
			<div class="col-sm-3 col-sm-offset-1 text_center" >已注册用户总人数：</div>
			<div id="login_total_number"></div>
		</div>
		
		<div class="row" style="font-size: 20px; margin-top: 10px;">
			<div class="col-sm-5 col-sm-offset-1">
				<div class="col-sm-7 text_center" >账号正常的人数：</div>
				<div id="account_normal_number" class="col-sm-5"></div>
			</div>
			
			<div class="col-sm-5">
				<div class="col-sm-6 text_center" >账号注销的人数：</div>
				<div id="account_cancel_number" class=""></div>
			</div>
		</div>
		
	</div>
</body>
</html>