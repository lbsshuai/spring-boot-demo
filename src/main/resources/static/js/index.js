// 定义变量



//初始化
$(function() {
	/*初始化*/
	init();
	
	//事件初始化
	eventInit();
});

function init() {
	addNewTab("优选产品", "localhost:8080/home");
}


/**
 * 事件初始化
 */
function eventInit() {

}

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
			content: "<iframe src='" + 'http://' + url + "' style='width:100%;height:100%'  frameborder='no' border='0' marginwidth='0' marginheight='0' scrolling='yes' />"
		});
	} else {
		$('#mainTabs').tabs('select', tabname);
	}
}
