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
		//===========点击展示日历选择器==================
			$('.form-datetime').datetimepicker({
				format : 'yyyy-mm-dd hh:ii',
				language : 'zh-CN',
				weekStart : 1,
				todayBtn : 1,
				autoclose : 1,
				todayHighlight : 1,
				defaultDate : new Date(),
				startView : 2,
				forceParse : 0,
				showMeridian : 1
			});
	}); 
	
</script>
</head>
<body>

	<div class="form-group">
		<label for="add_break_time" class="col-md-3 control-label">断站时间：</label>
		<div class="input-group date form-datetime col-md-5" data-date="" data-date-format="yyyy MM dd - HH:ii:ss p" data-link-field="dtp_input1">
			<input class="form-control" id="breaktime" size="16" type="text" name="breaktime">
			<span class="input-group-addon">
				<span class="glyphicon glyphicon-remove"></span>
			</span>
			<span class="input-group-addon">
				<span class="glyphicon glyphicon-th"></span>
			</span>
		</div>
	</div>

</body>
</html>
