<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/MIMS/css/style.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
		<div class="search-position" >
			<form action="/MIMS/userManage" method="post" class="navbar-form text-right">
				<input type="search" placeholder="搜索" class="form-control" id="data_name"/>
				<button type="submit">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</form>
		</div>	
		<hr/>
		

		<div style="margin: 0 auto;">
			<span>开始时间：</span><input type="date" id="start">
			<span>结束时间：</span><input type="date" id="end"><br/>
			<button type="button" class="btn btn-primary"  onclick="jChart()">查看</button>
		</div>
</body>
</html>