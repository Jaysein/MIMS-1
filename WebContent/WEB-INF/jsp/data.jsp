<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>数据管理</title>
<script type="text/javascript" src="/MIMS/js/echarts.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	
	<div class="background container">
		<div class="row" style="display: flex;align-items: center;border-bottom: 1px solid #DBDBDB;margin: 0 10px">
			<div class="col-sm-3 position">
				<h2 class="raw">步数数据</h2>
			</div>
			
			<div class='col-sm-3 position' style="margin-top: 45px">
				<div class="form-group row">
					<div class='input-group date' id='datetimepicker1'>
						<input type='text' placeholder="起始时间：" class="form-control" id="start"/>
						 <span class="input-group-addon"> 
						 	<span class="glyphicon glyphicon-calendar"></span>
						 </span>
					</div>	
				</div>
			</div>
			
			<label class="position" style="margin: 10px 5px 0 5px;">至</label>
			
			<div class='col-sm-3 position' style="margin-top: 45px">
				<div class="form-group row">
					<div class='input-group date' id='datetimepicker2'>
						<input type='text' placeholder="终止时间" class="form-control" id="end"/>
						 <span class="input-group-addon"> 
						 <span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>
			</div>
			
			<div class="position col-sm-3 " style="margin-top: 30px;">
				<form action="/MIMS/tempManage" method="post" class="navbar-form text-right">
					<input type="search" placeholder="搜索" class="form-control" id="data_name"/>
					
				</form>
			</div>	
			
			<div class="col-sm-1" style="margin-top: 10px; margin-left: -20px">
				<button type="button" class="btn btn-primary"  onclick="jChart()">查看</button>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">a</div>
			<div class="col-sm-6" id="step" style="height: 400px;"></div>
		</div>
		
		<div class="row">
			<div class="col-sm-6" id="temp" style="height: 400px;"></div>
			<div class="col-sm-6" id="heart" style="height: 400px;"></div>
		</div>	
		
		<script type="text/javascript">
		  		//-------------------图表开始--------------------
		  		function jChart(){
		  			var data_name = $("#data_name").val();
		  			//获取参数
		  			var startDate=$("#start").val();
		  			var endDate=$("#end").val();
		  			
		  			if ((startDate == null || startDate == "") || (endDate == null || endDate == "")) {
						alert("请输入日期！")
						return ;
					}
		  			
		  			//基于准备好的dom，初始化echarts实例
		  		  	var stepChart = echarts.init(document.getElementById('step'));		  			
		  		  	//图表显示加载样式
		  		 	stepChart.showLoading();
		  		  	var options = {
		  		 			title: {
		  		               text: "",
		  		           },
		  		           tooltip: {
		  		               trigger: 'axis'
		  		           },
		  		           legend: {
		  		               data: []
		  		           },
			  		       toolbox: {
			  		           show : true,
			  		           feature : {
			  		               mark : {show: true},
			  		               dataView : {show: true, readOnly: false},
			  		               magicType : {show: true, type: ['line', 'bar']},
			  		               restore : {show: true},
			  		               saveAsImage : {show: true}
			  		           }
			  		       },
			  		       dataZoom: {
				  			   show : true,
				  			   realtime : true,
				  			   height : 20,
				  			   start : 10,
				  			   end : 70
				  		   },
		  		           calculable: true,
		  		           label:{ 
		  		        	   normal:{ 
		  		        	   show: true, 
		  		        	   position: 'inside'} 
		  		        	},
		  		           xAxis: [
		  		               {
				                   type: 'category',
				                   data: []
		  		               }
		  		           ],
		  		           yAxis: [
		  		               {
		  		                   type: 'value',
		  		                   splitArea: { show: true }
		  		               }
		  		           ],
		  		           series: []
		  		   	};
		  		    //通过Ajax获取数据
		  		    stepAjax = $.ajax({
		  		    	async : false, //同步执行
		  		        url : "<%=basePath%>step",
		  		        data: {"data_name":data_name,"startDate":startDate,"endDate":endDate},
		  		        dataType : "json",
		  		        success:function(data) {
		  		            //将返回的category和series对象赋值给options对象内的category和series
		  		            options.title.text = data.title;
		  		            //主体内容
		  		           	options.series = data.series;
		  		            //头部动态选择
		  		          	options.legend.data = data.legend;
		  		            //因为xAxis是一个数组 这里需要是xAxis[i]的形式,横坐标
		  		        	options.xAxis[0].data = data.category;
		  		        	stepChart.hideLoading();
		  		      		// 使用刚指定的配置项和数据显示图表
		  		           	stepChart.setOption(options);
		  		        },
		  		        error : function(errorMsg) {
		  		            alert("图表请求数据失败啦!");
		  		        }
		  		    });
		  		    
			  		var tempChart = echarts.init(document.getElementById('temp'));
			  		tempChart.showLoading();
		  		  	var optiont = {
		  		 			title: {
		  		               text: "",
		  		           },
		  		           tooltip: {
		  		               trigger: 'axis'
		  		           },
		  		           legend: {
		  		               data: []
		  		           },
			  		       toolbox: {
			  		           show : true,
			  		           feature : {
			  		               mark : {show: true},
			  		               dataView : {show: true, readOnly: false},
			  		               magicType : {show: true, type: ['line', 'bar']},
			  		               restore : {show: true},
			  		               saveAsImage : {show: true}
			  		           }
			  		       },
			  		       dataZoom: {
				  			   show : true,
				  			   realtime : true,
				  			   height : 20,
				  			   start : 10,
				  			   end : 70
				  		   },
		  		           calculable: true,
		  		           label:{ 
		  		        	   normal:{ 
		  		        	   show: true, 
		  		        	   position: 'inside'} 
		  		        	},
		  		           xAxis: [
		  		               {
				                   type: 'category',
				                   data: []
		  		               }
		  		           ],
		  		           yAxis: [
		  		               {
		  		                   type: 'value',
		  		                   splitArea: { show: true }
		  		               }
		  		           ],
		  		           series: []
		  		   	};
		  		  	tempAjax = $.ajax({
		  		    	async : false, //同步执行
		  		        url : "<%=basePath%>temp",
		  		        data: {"data_name":data_name,"startDate":startDate,"endDate":endDate},
		  		        dataType : "json",
		  		        success:function(data) {
		  		            //将返回的category和series对象赋值给options对象内的category和series
		  		            optiont.title.text = data.title;
		  		            //主体内容
		  		           	optiont.series = data.series;
		  		            //头部动态选择
		  		          	optiont.legend.data = data.legend;
		  		            //因为xAxis是一个数组 这里需要是xAxis[i]的形式,横坐标
		  		        	optiont.xAxis[0].data = data.category;
		  		        	tempChart.hideLoading();
		  		      		// 使用刚指定的配置项和数据显示图表
		  		           	tempChart.setOption(optiont);
		  		        },
		  		        error : function(errorMsg) {
		  		            alert("图表请求数据失败啦!");
		  		        }
		  		    });
		  		  	
		  		  	var heartChart = echarts.init(document.getElementById('heart'));
		  		 	heartChart.showLoading();
		  		  	var optionh = {
		  		 			title: {
		  		               text: "",
		  		           },
		  		           tooltip: {
		  		               trigger: 'axis'
		  		           },
		  		           legend: {
		  		               data: []
		  		           },
			  		       toolbox: {
			  		           show : true,
			  		           feature : {
			  		               mark : {show: true},
			  		               dataView : {show: true, readOnly: false},
			  		               magicType : {show: true, type: ['line', 'bar']},
			  		               restore : {show: true},
			  		               saveAsImage : {show: true}
			  		           }
			  		       },
			  		       dataZoom: {
				  			   show : true,
				  			   realtime : true,
				  			   height : 20,
				  			   start : 10,
				  			   end : 70
				  		   },
		  		           calculable: true,
		  		           label:{ 
		  		        	   normal:{ 
		  		        	   show: true, 
		  		        	   position: 'inside'} 
		  		        	},
		  		           xAxis: [
		  		               {
				                   type: 'category',
				                   data: []
		  		               }
		  		           ],
		  		           yAxis: [
		  		               {
		  		                   type: 'value',
		  		                   splitArea: { show: true }
		  		               }
		  		           ],
		  		           series: []
		  		   	};
		  		  	heartAjax = $.ajax({
		  		    	async : false, //同步执行
		  		        url : "<%=basePath%>heart",
		  		        data: {"data_name":data_name,"startDate":startDate,"endDate":endDate},
		  		        dataType : "json",
		  		        success:function(data) {
		  		            //将返回的category和series对象赋值给options对象内的category和series
		  		            optionh.title.text = data.title;
		  		            //主体内容
		  		           	optionh.series = data.series;
		  		            //头部动态选择
		  		          	optionh.legend.data = data.legend;
		  		            //因为xAxis是一个数组 这里需要是xAxis[i]的形式,横坐标
		  		        	optionh.xAxis[0].data = data.category;
		  		        	heartChart.hideLoading();
		  		      		// 使用刚指定的配置项和数据显示图表
		  		           	heartChart.setOption(optionh);
		  		        },
		  		        error : function(errorMsg) {
		  		            alert("图表请求数据失败啦!");
		  		        }
		  		    });
		  			$.when(stepAjax, tempAjax, heartChart).done(function () {
		          	  
		            });
		  		}
		    </script>
		
	</div>		
</body>
</html>