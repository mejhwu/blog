$(function(){
	//标志变量,true表示是保存,false表示是修改
	// var flag = true;
	$('#save-btn').click(function () {
		var title = $('#title').val();
		var catalogId = $('#catalog').val();
		var editContent = $('#edit-content').val();
		var htmlContent = $('.editormd-preview').html();

		if (title == null || title == '') {
			alert('标题未填写!');
			return;
		}
		if (catalogId == null || catalogId == '') {
			alert('类别未选择!');
			return;
		}
		if (editContent == null || editContent.trim() == '') {
			alert('未编写任何内容!');
			return;
		}
		if (htmlContent == null || htmlContent == '') {
			alert('未能识别编写内容!');
			return;
		}

		var dat = {
			'title' : title,
			'catalogId' : catalogId,
			'editContent' : editContent,
			'htmlContent' : htmlContent
		};
		var url = null;
		if (flag) {
			url = '/back/article/save';
		} else {
			url = '/back/article/update/' + id;
		}
		$.ajax({
			url : url,
			type : 'post',
			data : dat,
			success : function (data) {
				if (data >= 1) {
					alert('保存成功!');
					window.location.href = '/back/article/list';
				} else {
					alert('保存失败!');
				}
			},
			error : function () {
				alert('保存失败!');
			}
		});
	});
})