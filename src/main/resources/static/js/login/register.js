/* 定义变量 */
var param = null;


/* 初始化 */
$(function () {
    init();

    eventInit();
});


function init() {

}

function eventInit() {

}

//获取参数
function userParam() {
    param = {
        'name': $('#name').val(),
        'password': $('#password').val(),
    }
}

/**
 * 验证参数
 */
function check() {
    if (param.name == "") {
        alert("请输入用户名")
        return false;
    }
    if (param.password == "") {
        alert("请输入登录密码")
        return false;
    }
    if ($('#passwordt').val() == "") {
        alert("请输入确认密码")
        return false;
    }
    if (param.password != $('#passwordt').val()) {
        alert("两次输入的密码不一致");
        return false;
    }
    return true;
}

//注册
function register() {
    userParam();
    //验证
    if (!check()) {
        return;
    }
    //是否同意注册协议
    var checkbox = $("input[type='checkbox']").is(':checked');
    if (!checkbox) {
        alert("亲，你又调皮了。不勾选协议，休想过去！")
        return;
    }
    $.ajax({
        url: contextPath + 'signIn',
        type: 'POST',
        data: param,
        success: function (data) {
            if (data.flag == 'success') {
                alert("注册成功")
            } else {
                alert(data.message);
                return;
            }
            window.location.href = contextPath + "login";
        }
    });
}