/**
 * 定义变量
 */
var shoeInfo = "";
var pageNum = null;
var pageSize = 8;

/**
 * 初始化
 */
$(function () {
    init();
    event();
});

function event() {
    //退出 点击事件
    $("#loginout").click(function () {
        loginout();
    })
    //购物车图标点击事件
    $("#cart").click(function () {
        toCart();
    })
    //主页 用户登录名
    getLoginUser();
}

function getLoginUser() {
    $.ajax({
        url: contextPath + "getLoginUser",
        type: "GET",
        success: function (data) {
            $("#loginUserName").html(data.object);
        }
    })
}

function toSingle(id){
    var localStorage = window.localStorage;
    localStorage.setItem("id", id);
    //跳转详情页
    window.location.href = contextPath + "cpts/single.html";
}

/**
 * 鞋子初始化
 */
function init() {
    pageNum = 1;
    $.ajax({
       url: contextPath + "cpts/shoeInfo?pageNum="+ pageNum + "&pageSize=" + pageSize,
       type: 'GET',
       success: function (data) {
           console.log(data);
           if(data.flag == "success"){
                var object = data['object'];
                var list = object['list'];
               console.log(list);
                for (var i = 0; i < list.length; i++){
                    var shoe = list[i];
                    var img = shoe['img'];
                    var name = shoe['name'];
                    var price = shoe['price'];
                    var id = shoe['id'];
                    shoeInfo = shoeInfo + '<div class="col-md-3 product-left">'+
                        '<div class="p-one simpleCart_shelfItem">'+
                        '<a href="javascript:void(0);" onclick="toSingle('+id+')">'+
                        '<img src="/cpts/images/shoeInfo/'+ img +'" alt="" />'+
                        '<div class="mask">'+
                        '<span>Quick View</span>'+
                        '</div></a>'+
                        '<h4>'+name+'</h4>'+
                        '<p><a class="item_add" href="javascript:void(0);"><i></i> <span class=" item_price">'+price+'</span></a></p>'+
                        '</div></div>';
                }
           }
           document.getElementById('shoeInfo').innerHTML = shoeInfo;
       }
    });
}

function loginout() {
    $.ajax({
       url: contextPath + "loginout",
       type:"GET" ,
        success: function (data) {
           if(data.flag === "000"){
               alert("用户还未登录！");
               return;
           }
           if(data.flag === "111"){
               $("#loginUserName").html("");
               alert("用户已退出登录！");
               return;
           }
        }
    });
}

function toCart() {
    //验证是否登录
    $.ajax({
        url: contextPath + "cpts/verifyLogin",
        type: "GET",
        success: function (data) {
            var object = data.object;
            if(object === null){
                window.location.href = contextPath + 'login';
            }else{
                window.location.href = contextPath + 'cpts/checkout.html';
            }
        }
    })
}

