<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户管理</title>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<link href="/MIMS/css/style.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/MIMS/js/nav.js"></script>
<!-- <script type="text/javascript">
$(function(){
	var pageSize = "${pageinfo.pageSize}";
	var pageNumber = "${pageinfo.pageNumber}";
	var total = ${pageinfo.total};

	//点击上一页
	$(".page_a:eq(0)").click(function(){
		pageNumber=parseInt(pageNumber)-1;
		if(pageNumber>=1){
			location.href="userManage?pageSize="+pageSize+"&pageNumber="+pageNumber;
		}else{
			pageNumber = 1;
		}
		return false;
	});
	//点击下一页
	$(".page_a:eq(1)").click(function(){
		pageNumber=parseInt(pageNumber)+1;
		if(pageNumber<=total){
			location.href="userManage?pageSize="+pageSize+"&pageNumber="+pageNumber;
		}else{
			pageNumber = total;
		}
		return false;
	});
});

</script> -->
</head>
<body>
	<div class="background">
	<div  class="row" style="display: flex;align-items: center;border-bottom: 1px solid #DBDBDB;margin: 0 10px">
		<div class="col-sm-3 position">
			<h2 class="">查询用户</h2>
		</div>
		
		<div class="position  col-sm-9" style="margin-bottom: 10px">
			<div class="navbar-form text-right">
				<input id="searchUser" type="search" placeholder="搜索" class="form-control" name="user_name"/>
				<button type="submit">
					<span class="glyphicon glyphicon-search" onclick="selUser()"></span>
				</button>
			</div>
		</div>
		
		</div>	
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>用户名</th>
					<th>年龄</th>
					<th>性别</th>
					<th>身高</th>
					<th>体重</th>
					<th>电子邮箱</th>
					<th>联系电话</th>
					<th>用户状态</th>
					<th>创建时间</th>
					<th>注销时间</th>
				</tr>
			</thead>
			<tbody id="userTB">
				
			</tbody>
		</table>	
		
		<div class="text-center">
			<a href="" class="page_a btn btn-primary btn-sm navbar-btn">上一页</a>
			<a href="" class="page_a btn btn-primary btn-sm navbar-btn">下一页</a>
		</div>
	</div>

</body>
</html>