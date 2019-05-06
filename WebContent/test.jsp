<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>HTML5_ScrollInToView方法</title>
<meta charset="utf-8">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="/MIMS/css/style.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/MIMS/js/nav.js"></script>
</head>
<script type="text/javascript">
var div1 = document.getElementById('div1');
var code = '<TABLE>';
	code += '<TR><TH>姓名</TH><TH>性别</TH></TR>';
	code += '<TR><TD>张三</TD><TD>男</TD></TR>';
	code += '<TR><TD>李三</TD><TD>女</TD></TR>';
	code += '<TR><TD>王三</TD><TD>男</TD></TR>';
	code += '<TR><TD>赵三</TD><TD>男</TD></TR>';
	div1.innerHTML = code + '</TABLE>';
</script>
<body>
	<div id='div1'></div>
</body>
</html>