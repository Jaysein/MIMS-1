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
<div class="row" style="background-color: transparent; margin-top: -3%">
	<div class="panel-group table-responsive" role="tablist">
		<div class="panel panel-default leftMenu">
			<!-- 利用data-target指定要折叠的分组列表 -->
			<div class="panel-heading" id="collapseListGroupHeading1"
				data-toggle="collapse" data-target="#collapseListGroup1" role="tab">
				<h4 class="panel-title">
					用户管理 <span class="glyphicon glyphicon-chevron-down right"></span>
				</h4>
			</div>
			<!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
			<div id="collapseListGroup1" class="panel-collapse collapse"
				role="tabpanel" aria-labelledby="collapseListGroupHeading1">
				<ul class="list-group">
					<li class="list-group-item">
						<!-- 利用data-target指定URL -->
						<button class="menu-item-left" data-target="test2.html">
							<span class="glyphicon glyphicon-triangle-right"></span>
							<span onclick="loadPage('/MIMS/seluser')">查询用户</span>
						</button>
					</li>
					<li class="list-group-item">
						<button class="menu-item-left">
							<span class="glyphicon glyphicon-triangle-right"></span>
							<span onclick="loadPage('/MIMS/insuser')">新增用户</span>
						</button>
					</li>
					<li class="list-group-item">
						<button class="menu-item-left">
							<span class="glyphicon glyphicon-triangle-right"></span>
							<span onclick="loadPage('/MIMS/upduser')">修改用户</span>
						</button>
					</li>
					<li class="list-group-item">
						<button class="menu-item-left">
							<span class="glyphicon glyphicon-triangle-right"></span>
							<span onclick="loadPage('/MIMS/canceluser')">注销用户</span>
						</button>
					</li>
				</ul>
			</div>
		</div>
		<!--panel end-->
		<div class="panel panel-default leftMenu">
			<div class="panel-heading" id="collapseListGroupHeading2"
				data-toggle="collapse" data-target="#collapseListGroup2" role="tab">
				<h4 class="panel-title" onclick="loadPage('/MIMS/dataManage')">
					数据管理 <span class="glyphicon glyphicon-chevron-down right"></span>
				</h4>
			</div>
			<div id="collapseListGroup2" class="panel-collapse collapse"
				role="tabpanel" aria-labelledby="collapseListGroupHeading2">
				<ul class="list-group">
					<li class="list-group-item">
						<button class="menu-item-left">
							<span class="glyphicon glyphicon-triangle-right"></span>
							<span id="nav_step">步数数据</span>
						</button>
					</li>
					<li class="list-group-item">
						<button class="menu-item-left">
							<span class="glyphicon glyphicon-triangle-right"></span>
							<span id="nav_temp">体温数据</span>
						</button>
					</li>
					<li class="list-group-item">
						<button class="menu-item-left">
							<span class="glyphicon glyphicon-triangle-right"></span>
							<span id="nav_heart">心率数据</span>
						</button>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
</body>
</html>