$(function () {
	$('a[name=delete]').on('click',function (event) {
		event.preventDefault();
		var catalogId = $(this).attr('data-id');
		$.ajax({
			url : '/back/catalog/delete/' + catalogId,
			type : 'post',
			dataType : 'json',
			success : function (data) {
				if (data == 1) {
					alert('删除成功!');
					window.location.href='/back/catalog/all';
				} else {
					alert('删除失败!');
				}
			},
			error : function () {
				alert('删除失败!');
			}
		});
		return false;
	});
});
