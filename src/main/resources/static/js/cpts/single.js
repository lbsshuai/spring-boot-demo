/**
 * 定义变量
 */
var startSingleInfo = "";
var id = null;
var color = '1';
var size = 40;
var num = "";
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
    $('#back').click(function () {
        back();
    })
    $('#toCart').click(function () {
        toCart();
    })
    $('#cart').click(function () {
        toCart();
    })
    $('#color_1').click(function () {
        colorSelect(1);
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
 * 点击颜色方法
 */
colorSelect = function (colorNum){
    console.log(colorNum);
    color = colorNum;
}
/**
 * 鞋号点击
 */
function sizeSelect(sizeNum) {
    console.log(sizeNum);
    size = sizeNum;
}


/**
 * 加入购物车
 */
function addToCart(){
    var localStorage = window.localStorage;
    id = localStorage.getItem("id");
    //获取商品数量
    num =  $("#numSelect").find("option:selected").text();
    console.log(num+ "--------------")
        $.ajax({
        url: contextPath + 'cpts/verifyLoginToCart',
        type: 'POSt',
        data: {
            id: id,
            num: num,
            color: color,
            size: size
            },
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

//返回上一页
function back() {
    window.history.go(-1);
}

//进入购物车页面
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
