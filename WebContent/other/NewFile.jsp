<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function(){           
	$('table td').click(function(){    
		if(!$(this).is('.input')){    
			$(this).addClass('input').html('<input type="text" value="'+ $(this).text() +'" />').find('input').focus().blur(function(){    
				var thisid = $(this).parent().siblings("th:eq(0)").text();    
				var thisvalue=$(this).val();    
				var thisclass = $(this).parent().attr("class");      
	 
	/*
	//ajax将修改后的数据提交到后台
	$.ajax({    
	 type: 'POST',    
	 url: 'update.php',    
	 data: "thisid="+thisid+"&thisclass="+thisclass+"&thisvalue="+thisvalue    
	});  
	*/
				$(this).parent().removeClass('input').html($(this).val() || 0);
			});                        
		}    
	}).hover(function(){    
		$(this).addClass('hover');    
	},function(){    
		$(this).removeClass('hover');    
	});    

}); 
</script>
</head>
<body>
	<table style="border:0; width: 500px;">
		<thead>
			<tr>
			<th scope="col">列1</th>
			<th scope="col">第二列</th>
			<th scope="col">其他</th>
			</tr>
		</thead>
        <tbody>
 			 <tr>       
                <td class="content"></td>
                <td class="text">测</td>
                <td class="position">0</td>
            </tr>
 			 <tr>
                <td class="content"></td>
                <td class="text">测</td>
                <td class="position">0</td>
            </tr>
 			 <tr>               
                <td class="content">测</td>
                <td class="text">%u53D</td>
                <td class="position">0</td>
            </tr>
 			 <tr>               
                <td class="content">测</td>
                <td class="text">%u624</td>
                <td class="position">1110</td>
            </tr>
  			<tr>                
                <td class="content">欢</td>
                <td class="text"></td>
                <td class="position">0</td>
            </tr>         
        </tbody>
    </table>  
</body>
</html>