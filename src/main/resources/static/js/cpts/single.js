/**
 * 定义变量
 */
var startSingleInfo = "";
var id = null;

/**
 * 初始化
 */
$(function () {

    init();
    event();
});

function init() {
    startSingle();
}
function event() {
    $('#addToCart').click(function () {
        addToCart();
    })
    $('#toCart').click(function () {
        toCart();
    })
    $('#cart').click(function () {
        toCart();
    })
}

/**
 * 初始化详情图片
 */
function startSingle() {

   /* for(var i = 1; i < 5; i++){
        startSingleInfo += "<li data-thumb=\"images/singleInfo/s"+i+".jpg\">"+
        "<img src=\"/cpts/images/singleInfo/s"+i+".jpg\" /></li>"
    }*/
    var localStorage = window.localStorage;
    id = localStorage.getItem("id");
    console.log(id)
    var img = null;
    var price = null;
    $.ajax({
        url: contextPath + "cpts/getImgById?shoeId="+ id,
        type: "GET",
        async:false,
        success: function (data) {
            var shoes = data.object;
            img = shoes.img;
            price = shoes.price;
            $("#shoePrice").html("$"+price);
            for(var i = 1; i < 5; i++){
                startSingleInfo += "<li data-thumb=\"images/shoeInfo/"+img+"\">"+
                    "<img src=\"/cpts/images/shoeInfo/"+img+"\" /></li>"
            }
            console.log(startSingleInfo)
            document.getElementById('startSingle').innerHTML = startSingleInfo;
        }
    });
}

/**
 * 加入购物车
 */
function addToCart(){
    var localStorage = window.localStorage;
    id = localStorage.getItem("id");
    //获取商品数量
    var num =  $("#numSelect").find("option:selected").text();
    $.ajax({
        url: contextPath + 'cpts/verifyLoginToCart?id='+ id +"&num=" + num,
        type: 'GET',
        success: function (data) {
            console.log(data);
            if (data.object === null){
                window.location.href =  contextPath + 'login';
            }else {
                alert("添加购物车成功！");
            }
        }
    })
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
