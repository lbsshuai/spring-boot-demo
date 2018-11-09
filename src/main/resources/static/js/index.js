// 定义变量
var name = "";


//初始化
$(function() {
	/*初始化*/
	init();
	
	//事件初始化
	eventInit();
});

function init() {
	//首页显示
	addNewTab("优选产品", contextPath + "home");
    getUser();
}

/**
 *
 */


/**
 * 事件初始化
 */
function eventInit() {

}

/**
 * 获取用户信息
 */
function getUser() {
	var cookie = getCookie(userName);
	name = cookie.split("#")[0];
	$("#aName").html(name);
}

/**
 * 增加窗口
 * @param tabname 窗口标题
 * @param url 跳转地址
 */
function addNewTab(tabname, url) {
	var index = $('#mainTabs').tabs('getTabIndex', $('#mainTabs').tabs('getSelected'));
	//关掉上一个
	if(index != null) {
		$("#mainTabs").tabs('close',index);
	}
	 
	//创建一个新的窗口，在mainlayout上  
	if(!$("#mainTabs").tabs('getTab', tabname)) {
		$("#mainTabs").tabs('add', {
			title: tabname,
			selected: true,
			closable: true,
			content: "<iframe src='" + url + "' style='width:100%;height:100%'  frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='yes' />"
		});
	} else {
		$('#mainTabs').tabs('select', tabname);
	}
}
