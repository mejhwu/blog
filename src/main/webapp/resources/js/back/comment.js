$(function () {
	pageControl.pageType = 'comment';
	bindComment(pageControl.firstPage());
	pageControl.bindBtnClick(bindComment);
	
	$('#search-btn').on('click', function (event) {
		event.preventDefault();
		var articleId = $('#article-id').val();
		var commented = $('#commented').val();
		if (articleId == null || articleId == '') {
			articleId = 0;
		}
		var searchData = {
			'articleId' : articleId,
			'commented' : commented
		};
		pageControl.searchData = searchData;
		bindComment(pageControl.firstPage());
        return false;
	});
	
});

function bindComment(list) {
	var $tab = $('#comment-list');
	$tab.html("");
	var html = '';
	$.each(list, function (i, comment) {
		if (i % 2 == 1) {
			html += '<tr class="lightgray-background">';
		} else {
			html += '<tr>';
		}

		html += '<td>' + comment.articleId + '</td>';
		html += '<td>' + comment.name + '</td>';
		html += '<td>' + comment.email + '</td>';
		html += '<td>' + new Date(comment.createTime).format('yyyy-MM-dd HH:mm:ss') + '</td>';
        if (comment.commented == 1) {
            html += '<td>' + '未回复' + '</td>';
        } else if (comment.commented == 2) {
            html += '<td>' + '已回复' + '</td>';
        } else {
            html += '<td>' + '无' + '</td>';
        }
        html += '<td><a name="replay" href="/back/comment/goReplay/' + comment.articleId + '/' + comment.id + '">回复</a></td>';
	});
	$tab.html(html);
	$('#total-page-number1').html(pageControl.totalPage);
	$('#total-page-number2').html(pageControl.totalPage);
	$('#current-page-number').html(pageControl.currentPage);
	$('#page-number-input').val(pageControl.currentPage);

	//设置按钮是否可点击
	pageControl.setBtnDisable();
}
