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
		'name' : $('#name').val(),
		'password' : $('#password').val(),
	}
	
	console.log($('#name').val());
	console.log($('#password').val());
	console.log($('#passwordt').val());
}

/**
 * 验证参数
 */
function check() {
	if(param.name == ""){
		alert("请输入用户名")
		return false;
	}
	if(param.password == ""){
		alert("请输入登录密码")
		return false;
	}
	if($('#passwordt').val() == ""){
		alert("请输入确认密码")
		return false;
	}
	if(param.password != $('#passwordt').val()){
		alert("两次输入的密码不一致");
		return false;
	}
	return true;
}

//注册
function register(){
	userParam();
	//验证
	if(!check()){
		return;
	}
	
	$.ajax({
		url : contextPath + '/signIn',
		type : 'POST',
		data : param,
		success :function(data) {
			if(data.flag == 'success'){
				alert("注册成功")
			}
			window.location.href="http://localhost:8080/login";
		}
	});
}