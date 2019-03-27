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
<title>心率</title>
<script type="text/javascript" src="/MIMS/js/echarts.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	
	<div class="background container">
		<div class="row" style="display: flex;align-items: center;border-bottom: 1px solid #DBDBDB;margin: 0 10px">
			<div class="col-sm-3 position">
				<h2 class="">心率数据</h2>
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
			
			<label class="position" style="margin: 30px 5px 0 5px;">至</label>
			
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
			
			<div class="position col-sm-3 " style="margin-bottom: 10px;margin-top: 40px;">
				<form action="/MIMS/tempManage" method="post" class="navbar-form text-right">
					<input type="search" placeholder="搜索" class="form-control" id="data_name"/>
					
				</form>
			</div>	
			
			<div class="col-sm-1" style="margin-top: 30px; margin-left: -20px">
				<button type="button" class="btn btn-primary"  onclick="jChart()">查看</button>
			</div>
		</div>

		
		
	    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	    <div id="main" style="width: 100%;height:400px;margin: 0 auto;"></div>
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
		  		  	var myChart = echarts.init(document.getElementById('main'));
		  		  	//图表显示加载样式
		  		 	myChart.showLoading();
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
				  			   start : 40,
				  			   end : 60
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
		  		    $.ajax({
		  		    	async : true, //同步执行
		  		        url : "<%=basePath%>heart",
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
		  		           	myChart.hideLoading();
		  		      		// 使用刚指定的配置项和数据显示图表
		  		           	myChart.setOption(options);
		  		        },
		  		        error : function(errorMsg) {
		  		            alert("图表请求数据失败啦!");
		  		        }
		  		    })
		  		}
		    </script>
    </div>
</body>


</html>