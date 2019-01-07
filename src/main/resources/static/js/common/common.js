/**
 * 确认提示框
 * @param title 标题
 * @param message 显示信息
 * @param callback 回调函数
 */
function showConfirm(title, message, callback) {
	$.messager.confirm(title, message, function(r){
		if (r) {
			if (typeof callback == "function") {
				callback();
			}
		}
	});
}

/**
 * 警告提示框
 * @param title 标题
 * @param message 显示信息
 * @param iconType 警示图标类型，可用的值是：error、question、info、warning
 */
function showAlert(title, message, iconType) {
	$.messager.alert(title, message, iconType);
}

/**
 * 警告提示框带回调函数
 * @param title 标题
 * @param message 显示信息
 * @param iconType 警示图标类型，可用的值是：error、question、info、warning
 * @param callback 回调函数
 */
function showAlertFn(title, message, iconType, callback) {
	$.messager.alert(title, message, iconType, callback);
}


