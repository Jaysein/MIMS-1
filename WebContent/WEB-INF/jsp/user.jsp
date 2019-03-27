<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户管理</title>
<script type="text/javascript">
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
</script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	
	<div class="background container">
	<div  class="row" style="display: flex;align-items: center;border-bottom: 1px solid #DBDBDB;margin: 0 10px">
		<div class="col-sm-3 position">
			<h2 class="">用户管理</h2>
		</div>
		
		<div class="position  col-sm-9" style="margin-bottom: 10px">
			<form action="/MIMS/userManage" method="post" class="navbar-form text-right">
				<input type="search" placeholder="搜索" class="form-control" name="user_name"/>
				<button type="submit">
					<span class="glyphicon glyphicon-search"></span>
				</button>
			</form>
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
			<tbody>
				<c:forEach var="user" items="${pageinfo.list}" varStatus="status">
					<tr>
						<td>${user.user_name}</td>
						<td>${user.age}</td>
						<td>${user.sex}</td>
						<td>${user.height}</td>
						<td>${user.weight}</td>
						<td>${user.e_mail}</td>
						<td>${user.phone}</td>
						<td>${user.user_status}</td>
						<td>${user.create_time}</td>
						<td>${user.cancel_time}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
		
		<div class="text-center">
			<a href="" class="page_a btn btn-primary btn-sm navbar-btn">上一页</a>
			<a href="" class="page_a btn btn-primary btn-sm navbar-btn">下一页</a>
		</div>
	</div>

</body>
</html>