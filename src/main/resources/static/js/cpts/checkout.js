/** 定义变量*/
var loginUserName = "";



$(function () {
    init();
    event();
})

//初始化
function init() {
    getLoginUser();
    getCartInfo();
}

//事件
function event() {
}

/**
 * 获取登录人
 */
function getLoginUser() {
    var localStorage = window.localStorage;
    loginUserName = localStorage.getItem("loginUserName");
    $('#loginUserName').html(loginUserName);
}

/**
 * 获取购物车信息
 */
function getCartInfo() {
    console.log(loginUserName)
    $.ajax({
       url: contextPath + "cpts/getCartInfo?userName=" + loginUserName,
       type: 'GET',
       success: function (data) {
            console.log(data)
       }
    });
}
