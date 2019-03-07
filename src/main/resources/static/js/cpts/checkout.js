/** 定义变量*/
var loginUserName = "";
var cartInfo = "";
var totalPrices = null;


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

    //返回前一页 点击事件
    $('#backToPREV').click(function () {
        backToPREV();
    });
    //返回首页 点击事件
    $('#backToHome').click(function () {
        backToHome();
    });
    //提交订单 点击事件
    $('#submitOrder').click(function () {
        submitOrder();
    });
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
           var object = data.object;
           if(data === null){
               return;
           }
           console.log(object);
           for(var i = 0, len = object.length; i < len; i++){
               var id = object[i]['id'];
               var img = object[i]['img'];
               var name = object[i]['name'];
               var num = object[i]['num'];
               var price = object[i]['price'];
               totalPrices = totalPrices + num * price;
               cartInfo = cartInfo + '<ul class="cart-header">'+
                   '<li  style="width: 15%;" class="ring-in">'+
                   '<img src="/cpts/images/shoeInfo/'+img+'" class="img-responsive"></li>'+
                   '<li style="width: 15%;"><span>'+ name +'</span></li>'+
                   '<li style="width: 15%;"><span style="color: red">$'+ price +'</span></li>'+
                   '<li style="width: 15%;"><span>In Stock</span></li>'+
                   '<li style="width: 15%;"><span>'+ num +'</span></li>'+
                   '<li style="width: 15%;"><span style="color: red">$'+ num * price +'</span></li>'+
                   '<li style="width: 15%;"><div onclick="deleteCartInfo('+id+')" class="close1 close11"> </div></li>'+
                   '<div class="clearfix"> </div></ul>';
           }
           if(object.length > 0){
               cartInfo = cartInfo + '<ul class="cart-header">'+
                   '<li  style="width: 78%; text-align: right;">TotalPrices:</li>'+
                   '<li style="width: 20%; text-align: left; margin-left: 2%; color: red;">$'+ totalPrices +'</li>'+
                   '<div> </div></ul>';
           }
           document.getElementById('cartInfo').innerHTML = cartInfo;
       }
    });
}

/**
 * 删除购物车中商品信息
 */
function deleteCartInfo(id) {
    console.log(id);
    $.ajax({
        url: contextPath + "cpts/delectCartInfo?id=" + id +"&userName="+ loginUserName,
        type: 'GET',
        success: function () {
            history.go(0);
        }
    })
}

/**
 * 返回上一页
 */
function backToPREV() {
    window.history.go(-1);
}
/**
 * 返回首页
 */
function backToHome() {
    window.open('index.html','_self');
}
/**
 * 提交订单
 */
function submitOrder() {
    if(totalPrices != null){
        window.open('submitOrder.html', '_self');
    }
}