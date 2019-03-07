/**
 * 定义变量
 */
var id = null;

/**
 * 初始化
 */
$(function () {

    init();
    event();
});

function init() {

}
function event() {
    $('#submitButton').click(function () {
        submitInfo();
    });
}

function cleanData() {
        $('#consignee').val(null);
        $('#consigneePhone').val(null);
        $('#consigneeAddress').val(null);
        $('#consigneeZipCode').val(null);
}

function check() {
    if($('#consignee').val() === ''){
        alert("请输入收件人信息！")
        return false;
    }else if($('#consigneePhone').val() === '') {
        alert("请输入收件人手机号！")
        return false;
    }else if($('#consigneeAddress').val()=== '' ){
        alert("请输入收件人地址！")
        return false;
    }else if($('#consigneeZipCode').val() === ''){
        alert("请输入收件人邮编！")
        return false;
    }
    return true;
}

function submitInfo() {
    if(!check()){
        return;
    }
    var localStorage = window.localStorage;
    id = localStorage.getItem("id");
    var formInfo = {
        consignee: $('#consignee').val(),
        consigneePhone: $('#consigneePhone').val(),
        consigneeAddress: $('#consigneeAddress').val(),
        consigneeZipCode: $('#consigneeZipCode').val(),
        id: id,
    }
    $.ajax({
        url: contextPath + "cpts/submit",
        type: "POST",
        data: formInfo,
        success: function (data) {
            console.log(data)
            if(data.flag === "false"){
                alert(data.message);
                window.location.href =  contextPath + 'login';
                return;
            }
            alert("提交订单成功");
            window.location.href = contextPath + 'cpts/pay.html';
        },
    })

   console.log(formInfo)
}













