<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
		 
		<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="/MIMS/js/moment-with-locales.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">
	 $(function() {
		$('#datetimepicker1').datetimepicker({
			format : 'YYYY-MM-DD hh:mm:ss',
			locale : moment.locale('zh-cn')
		});
		$('#datetimepicker2').datetimepicker({
			format : 'YYYY-MM-DD hh:mm:ss',
			locale : moment.locale('zh-cn')
		});
	}); 
	
</script>
</head>
<body>

	<div class="row">
		<div class='col-sm-6'>
			<div class="form-group">
				<label>选择日期：</label>
				<!--指定 date标记-->
				<div class='input-group date' id='datetimepicker1'>
					<input type='text' class="form-control" /> <span
						class="input-group-addon"> <span
						class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>
		<div class='col-sm-6'>
			<div class="form-group">
				<label>选择日期+时间：</label>
				<!--指定 date标记-->
				<div class='input-group date' id='datetimepicker2'>
					<input type='text' class="form-control" />
					 <span class="input-group-addon"> 
					 <span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
