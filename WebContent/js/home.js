window.onload = function(){
	var total_number = $("#login_total_number").get(0);
	var normal_number = $("#account_normal_number").get(0);
	var cancel_number = $("#account_cancel_number").get(0);
	
	$.ajax({
		type: 'GET',
		url: '/MIMS/homeManage',
		async : true,
		dataType : "json",
		success : function(data) {
			if (data != null) {
				total_number.innerHTML = data.total_number;
				normal_number.innerHTML = data.normal_number;
				cancel_number.innerHTML = data.cancel_number;
			}
		},
		error : function(msg) {
			alert("fail");
		}
	});
}