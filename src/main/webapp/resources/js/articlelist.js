$(function () {
	var type = 'article';
	bindArticle(pageControl.firstPage(type));
	pageControl.bindBtnClick(type, bindArticle);


	$('#search-btn').click(function () {
		var title = $('#title').val();
		var catalog = $('#catalog').val();
		var startTime = $('#start-time').val();
		var endTime = $('#end-time').val();
		var searchData = {};

		if (title != null && title != ''){
			searchData.title = title;
		}
		if (catalog != null && catalog != '') {
			searchData.catalog = catalog;
		}
		if (startTime != null && startTime != ''){
			searchData.startTime = startTime;
		}
		if (endTime != null && endTime != '') {
			searchData.endTime = endTime;
		}

		pageControl.searchData = searchData;
		bindArticle(pageControl.firstPage(type));
	})



	function bindArticle (list) {
		var $tab = $('#article-list');
		$tab.html("");
		var html = '';
		$.each(list, function (i, article) {
			if (i % 2 == 1) {
				html += '<tr class="lightgray-background">';
			} else {
				html += '<tr>';
			}

			html += '<td>' + (i + 1) + '</td>';
			html += '<td>' + article.title + '</td>';
			html += '<td>' + article.catalog + '</td>';
			html += '<td>' + article.authorName + '</td>';
			html += '<td>' + new Date(article.createTime).toLocaleString() + '</td>';
			html += '<td>' + new Date(article.updateTime).toLocaleString() + '</td>';
			html += '<td><a href="/back/article/detail/' + article.id + '">详情</a><a href="/back/article/goUpdate/' + article.id + '">修改</a><a href="/back/article/delete/' + article.id + '">删除</a></td>'
		});
		$tab.html(html);
		$('#total-page-number1').html(pageControl.totalPage);
		$('#total-page-number2').html(pageControl.totalPage);
		$('#current-page-number').html(pageControl.currentPage);
		$('#page-number-input').val(pageControl.currentPage);

		//设置按钮是否可点击
		pageControl.setBtnDisable();
	}
});