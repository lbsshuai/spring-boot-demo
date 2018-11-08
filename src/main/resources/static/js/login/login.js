/* 定义变量 */
var param = null;

/* 初始化 */
$(function() {

});



function reloadCaptcha() {
	var d = new Date();
	$("#captchaImage").attr("src", "login/jcaptcha?" + d.getTime());
	$('#inputCaptcha').textbox('setText', '');
}

function userParam() {
    param = {
        'name' : $('#name').val(),
        'password' : $('#password').val(),
    }

    console.log($('#name').val());
    console.log($('#password').val());
    console.log($('#passwordt').val());
}

function check() {
	if(param.name == ''){
		alert("请输入账号");
	}
	if(param.password == ""){
		alert("请输入密码");
	}
}

function loginIn(){
	//获取参数
    userParam();
    //校验参数
	check();

	$.ajax({
		url:contextPath + 'loginIn',
		type:'POST',
        data:param,
        success:function (data) {
            if(data.flag == 'success'){
                alert("登录成功")
                console.log(contextPath);
            }else{
                alert(data.message);
                return;
            }
            window.location.href=contextPath + "index";
        }
	});
}
