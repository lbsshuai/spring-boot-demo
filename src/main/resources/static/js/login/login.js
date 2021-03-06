/* 定义变量 */
var param = null;
var rememberMe = 0;
/* 初始化 */
$(function () {

    //初始化
    init();
});

/**
 * 页面初始化
 */
function init() {


}

/**
 * 页面根据Cookie值填充用户名 密码
 */
$(document).ready(function () {
//记住密码功能
    var str = getCookie(userCookie);
    var username = str.split("#")[0];
    var password = str.split("#")[1];
//自动填充用户名 密码
    $("#name").val(username);
    $("#password").val(password);
});

function reloadCaptcha() {
    var d = new Date();
    $("#captchaImage").attr("src", "login/jcaptcha?" + d.getTime());
    $('#inputCaptcha').textbox('setText', '');
}

/**
 * 获取参数
 */
function userParam() {
    //是否记住密码
    var checkbox = $("input[type='checkbox']").is(':checked');
    if (checkbox) {
        rememberMe = 1;
    }
    param = {
        'name': $('#name').val(),
        'password': $('#password').val(),
        'rememberMe': rememberMe
    }
}

/**
 * 校验参数
 */
function check() {
    if (param.name == '') {
        alert("请输入账号");
    }
    if (param.password == "") {
        alert("请输入密码");
    }
}

/**
 * 登陆功能
 */
function loginIn() {
    //获取参数
    userParam();
    //校验参数
    check();

    $.ajax({
        url: contextPath + 'loginIn',
        type: 'POST',
        data: param,
        success: function (data) {
            if (data.flag == 'success') {
                setTimeout(function () {
                    alert("登录成功")
                },1000)
            } else {
                setTimeout(function () {
                    alert(data.message);
                },1000)
                return;
            }
            //跳转VUE页面
            window.location.href = vueContextPath + "index";
        }
    });
}
