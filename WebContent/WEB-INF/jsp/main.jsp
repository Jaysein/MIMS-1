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
<script type="text/javascript" src="/MIMS/js/nav.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="">
		<div id="left" class="col-sm-2" style="height: 100%;">
			<jsp:include page="nav.jsp"></jsp:include>
		</div>
		<div id="right" class="col-sm-10" style="height: 100%; margin-left: -0.5%;">
			<jsp:include page="home.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>