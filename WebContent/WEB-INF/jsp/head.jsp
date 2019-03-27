<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>导航栏</title>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="/MIMS/css/style.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/MIMS/js/moment-with-locales.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="/MIMS/js/datatimpicker.js"></script>
</head>
<body>	
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" data-toggle="collapse" data-target="#responsive-navbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="" class="navbar-brand"><strong>Monitor</strong>.net</a>
			</div>
			<div class="collapse navbar-collapse"  id="responsive-navbar">
				<ul class="nav navbar-nav">
					<li><a href="/MIMS/userManage">用户管理</a></li>
					<li><a href="/MIMS/dataManage">数据管理</a></li>
				</ul>			
				<div class="navbar-right">
					<p class="profile navbar-text navbar-btn ">您好，<a href="#" class="navbar-link">${real_name}</a></p>
					<a href="/MIMS/cancel" class="btn btn-primary btn-sm navbar-btn">注销</a>
				</div>	
			</div>
		</div>
	</nav>
</body>
</html>