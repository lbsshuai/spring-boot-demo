/**
 * 定义变量
 */
var shoeInfo = "";

/**
 * 初始化
 */
$(function () {
    init();

});


/**
 * 鞋子初始化
 */
function init() {
    $.ajax({
       url: contextPath + "cpts/shoeInfo",
       type: 'GET',
       success: function (data) {
           console.log(data);
           if(data.flag == "success"){
                var list = data['object'];
                for (var i = 0; i < list.length; i++){
                    var shoe = list[i];
                    var img = shoe['img'];
                    var name = shoe['name'];
                    var price = shoe['price'];
                    var id = shoe['id'];
                    console.log(img + name + price)
                    shoeInfo = shoeInfo + '<div class="col-md-3 product-left">'+
                        '<div class="p-one simpleCart_shelfItem">'+
                        '<a href="/cpts/single.html?id='+ id +'">'+
                        '<img src="/cpts/images/'+ img +'" alt="" />'+
                        '<div class="mask">'+
                        '<span>Quick View</span>'+
                        '</div></a>'+
                        '<h4>'+name+'</h4>'+
                        '<p><a class="item_add" href="/cpts/#"><i></i> <span class=" item_price">'+price+'</span></a></p>'+
                        '</div></div>';
                }
           }
           console.log(shoeInfo);
           document.getElementById('shoeInfo').innerHTML = shoeInfo;
       }
    });
}




