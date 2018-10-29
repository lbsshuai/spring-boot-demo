/* 定义变量 */

/* 初始化 */
$(function() {

});

function reloadCaptcha() {
	var d = new Date();
	$("#captchaImage").attr("src", "login/jcaptcha?" + d.getTime());
	$('#inputCaptcha').textbox('setText', '');
}
