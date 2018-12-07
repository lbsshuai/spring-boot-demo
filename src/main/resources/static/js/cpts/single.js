/**
 * 定义变量
 */
var startSingleInfo = "";

/**
 * 初始化
 */
$(function () {

    init();
});

function init() {
    startSingle();
}

function startSingle() {
    for(var i = 1; i < 5; i++){
        startSingleInfo += "<li data-thumb=\"images/singleInfo/s"+i+".jpg\">"+
        "<img src=\"/cpts/images/singleInfo/s"+i+".jpg\" /></li>"
    }
    document.getElementById('startSingle').innerHTML = startSingleInfo;
}





let app = new Vue({
    el : '#app',
    data: {
        list:["s1.jpg", "s2.jpg", "s3.jpg", "s4.jpg"],
        list1:["images/s1.jpg", "images/s2.jpg", "images/s3.jpg", "images/s4.jpg"],
        list2:["/cpts/images/s1.jpg", "/cpts/images/s2.jpg", "/cpts/images/s3.jpg", "/cpts/images/s4.jpg"]
    }
});



