$(function () {


	pageControl.pageType = 'article';

	bindArticle(pageControl.firstPage());
	pageControl.bindBtnClick(bindArticle);


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
		bindArticle(pageControl.firstPage());
	});


});


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

        html += '<td>' + article.id + '</td>';
        html += '<td>' + article.title + '</td>';
        html += '<td>' + article.catalog + '</td>';
        html += '<td>' + article.authorName + '</td>';
        html += '<td>' + new Date(article.createTime).format('yyyy-MM-dd HH:mm:ss') + '</td>';
        html += '<td>' + new Date(article.updateTime).format('yyyy-MM-dd HH:mm:ss') + '</td>';
        html += '<td><a href="/back/article/detail/' + article.id + '">详情</a><a href="/back/article/goUpdate/' + article.id + '">修改</a><a name="delete" href="javascript:void(0)"  data-id="' + article.id + '">删除</a></td>'
    });
    $tab.html(html);
    bindDeleteClick();
    $('#total-page-number1').html(pageControl.totalPage);
    $('#total-page-number2').html(pageControl.totalPage);
    $('#current-page-number').html(pageControl.currentPage);
    $('#page-number-input').val(pageControl.currentPage);

    //设置按钮是否可点击
    pageControl.setBtnDisable();
}

//绑定删除事件
function bindDeleteClick() {
    $('a[name=delete]').on('click', function (event) {
        if (!confirm('确定删除?')) {
            return;
        }
        var target = event.target || window.event.srcElement;
        var hf = $(target).attr('data-id');
        hf = '/back/article/delete/' + hf;
        $.ajax({
            url : hf,
            method : 'post',
            success : function (data) {
                if (data >= 0) {
                    alert('删除成功!');
                    bindArticle(pageControl.curPage());
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
}