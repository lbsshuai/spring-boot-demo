


$(function() {
	
	//初始化
	init();
	
	//事件初始化
	eventInit();
})

function init() {
	
}

function eventInit() {
}

function submitonclick() {
	var fileInfo = $('input[name="test"]').attr('value');
	console.log(fileInfo);
}

//检验文件格式并预览
function previewImage(preImageId, imageFile) {
	console.log(preImageId);
	console.log(imageFile);
	var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
	if (!pattern.test(imageFile.value)) {
		console.log(pattern);
		alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
		imageFile.focus();
		$(imageFile).val("");
		return false;
	} else {
		var path;
		if (document.all)// IE
		{
			imageFile.select();
			path = document.selection.createRange().text;
		} else// FF
		{
			path = URL.createObjectURL(imageFile.files[0]);
		}
		$('#' + preImageId).attr('src', path);
	}
}

$('#submit').on('click', function() {
	var formData = new FormData($("#uploadForm")[0]);
	console.log(formData);
	$.ajax({
		type : 'POST',
		url : '/upload',
		data : formData,
		contentType : false,
		processData : false,
		success : function(result) {
			console.log(result);
		},
	});
});