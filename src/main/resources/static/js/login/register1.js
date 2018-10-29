/* 定义变量 */
var param = null;


/* 初始化 */
$(function() {
	init();
	
	eventInit();
});


function init(){
	
}

function eventInit() {
	
}

//获取参数
function userParam(){
	//获取爱好
	var check_val=[];
	var obj = $('input:checkbox[name="love"]');
	 /*obj = document.getElementsByName("love");*/
	for(k in obj){
		if(obj[k].checked){
			check_val.push(obj[k].value);
		}
	}	
	
	param = {
		'name' : $('#user').val(),
		'password' : $('#password').val(),
		'sex' : $('input[name="sex"]:checked').val(),
		'nation' : $('select[name="nation"]').val(),
		'love' : check_val
	}
	
	console.log($('#user').val());
	console.log($('#password').val());
	console.log($('#passwordt').val());
	console.log($('input[name="sex"]:checked').val());
	console.log(check_val);
	console.log($('select[name="nation"]').val());
	
}

/**
 * 验证参数
 */
function check() {
	if(param.name == ""){
		alert("请输入用户名")
		return;
	}
	if(param.password == ""){
		alert("请输入登录密码")
		return;
	}
	if($('#passwordt').val() == ""){
		alert("请输入确认密码")
		return;
	}
	if(param.password != $('#passwordt').val()){
		alert("两次输入的密码不一致");
		return;
	}
}

//注册
function register(){
	userParam();
	//验证
	check();
	
	$.ajax({
		url : contextPath + '/signIn',
		type : 'POST',
		data : param,
		success :function(data) {
			console.log(data);
		}
	});
}