/**
 * 左侧导航栏
 * @returns
 */
$(function() {
	$(".panel-heading").click(function(e) {
		/*切换折叠指示图标*/
		$(this).find("span").toggleClass("glyphicon-chevron-down");
		$(this).find("span").toggleClass("glyphicon-chevron-up");
	});
});

function loadPage(url) {
	$.ajax({
		type : "post",
		url : url,
		async : true,
		dataType : "html",
		contentType : 'application/json; charset=utf-8',
		success : function(html) {
			$('#right').html(html);
			//$('#right').load(url);//load函数同样能实现效果
		}
	});
}

window.onload = function(){
	document.querySelector("#nav_step").onclick = function(){
		document.querySelector("#data_step").scrollIntoView(false);
	}
	
	document.querySelector("#nav_temp").onclick = function(){
		document.querySelector("#data_temp").scrollIntoView(false);
	}
	
	document.querySelector("#nav_heart").onclick = function(){
		document.querySelector("#data_heart").scrollIntoView(false);
	}
}

/**
 * 查询用户
 */
selUser = function() {
	var username = $("#searchUser").val();
	var tbody = document.getElementById("userTB");
	var code = "";
	$.ajax({
		type : "get",
		url : "/MIMS/selectUser",
		async : true,
		data:{"username":username},
		dataType : "json",
		success : function(data) {
			var user = null;
			if (data != null) {
				for(var i=0; i<data.list.length;i++){
					code += '<tr>'
						 + '<td>'+data.list[i].user_name+'</td>'
						 + '<td>'+data.list[i].age+'</td>'
						 + '<td>'+data.list[i].sex+'</td>'
						 + '<td>'+data.list[i].height+'</td>'
						 + '<td>'+data.list[i].weight+'</td>'
						 + '<td>'+data.list[i].e_mail+'</td>'
						 + '<td>'+data.list[i].phone+'</td>'
						 + '<td>'+data.list[i].user_status+'</td>'
						 + '<td>'+data.list[i].create_time+'</td>'
						 + '<td>'+data.list[i].cancel_time+'</td>'
				}
				tbody.innerHTML = code;
			}
		},
		error : function(msg) {
			alert("fail");
		}
	});
};

/**
 * 新增用户
 */
insUser = function() {
	var user_name = $("#ins_username").val();
	var e_mail = $("#ins_email").val();
	var phone = $("#ins_phone").val();
	var sex = $("#ins_sex").val();
	var age = $("#ins_age").val();
	var height = $("#ins_height").val();
	var weight = $("#ins_weight").val();
	
	$.ajax({
		type : "POST",
		url: '/MIMS/insertUser',
		async : true,
		data:{"user_name":user_name,
			  "e_mail":e_mail,
			  "phone":phone,
			  "sex":sex,
			  "age":age,
			  "height":height,
			  "weight":weight
		},
		dataType : "json",
		success : function(data) {
			if (data.ins_flag == "ins_success") {
				alert("操作成功")
			} else if (data.ins_flag == "ins_fails") {
				alert("操作失败");
			} else if(data.ins_flag == "user_exist") {
				alert("该用户已存在");
			}
		},
		error : function(msg) {
			alert("fail");
		}
	});
};

/**
 * 修改用户
 */
updUser = function() {
	var user_name = $("#upd_username").val();
	var e_mail = $("#upd_email").val();
	var phone = $("#upd_phone").val();
	var sex = $("#upd_sex").val();
	var age = $("#upd_age").val();
	var height = $("#upd_height").val();
	var weight = $("#upd_weight").val();
	
	$.ajax({
		type : "POST",
		url: '/MIMS/updateUser',
		async : true,
		data:{"user_name":user_name,
			  "e_mail":e_mail,
			  "phone":phone,
			  "sex":sex,
			  "age":age,
			  "height":height,
			  "weight":weight
		},
		dataType : "json",
		success : function(data) {
			if (data.upd_flag == "upd_success") {
				alert("操作成功")
			} else if (data.upd_flag == "upd_fails") {
				alert("操作失败");
			} else if(data.upd_flag == "user_no_exist") {
				alert("该用户不存在");
			}
		},
		error : function(msg) {
			alert("fail");
		}
	});
};

/**
 * 注销用户
 */
cancelUser = function() {
	var user_name = $("#cancel_username").val();
	
	$.ajax({
		type : "POST",
		url: '/MIMS/cancelUser',
		async : true,
		data:{"user_name":user_name,},
		dataType : "json",
		success : function(data) {
			if (data.cancel_flag == "cancel_success") {
				alert("操作成功")
			} else if (data.cancel_flag == "cancel_fails") {
				alert("操作失败");
			} else if (data.cancel_flag == "cancel_no_exist") {
				alert("该用户不存在");
			}
		},
		error : function(msg) {
			alert("fail");
		}
	});
};
