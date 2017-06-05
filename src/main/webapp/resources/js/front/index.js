$(function () {

    //是否正在加载更多数据
    var isLoading = false;

    pageControl.pageType = 'article';

    bindArticle(pageControl.firstPage());

    //绑定类别点击事件
    $('a[name=catalog]').on('click', function () {
        var catalogId = $(this).attr('data-id');
        var searchData = {
            'catalog' : catalogId
        };
        pageControl.searchData = searchData;
        $('#content').html('');
        bindArticle(pageControl.firstPage());
    });

    //绑定搜索按钮点击事件
    $('#search-btn').on('click', function (event) {
        event.preventDefault();
        var searchText = $('#search-content').val();
        if (searchText == null || searchText == ''){
            return;
        }
        var catalog = $('#catalog').val();
        var searchData = {
            'title' : searchText,
            'catalog' : catalog
        }
        pageControl.searchData = searchData;
        $('#content').html('');
        bindArticle(pageControl.firstPage());
    });

    //添加滚动事件,滚动加载更多
    $(window).on('scroll', function () {
        var docHeight = $(document).height();
        var winHeight = $(window).height();
        var winScrollHeight = $(window).scrollTop();
        if (docHeight - 200 <= winHeight + winScrollHeight) {
            bindArticle(pageControl.nextPage());
        }
        //如果加载完所有数据,解绑滚动事件
        if (pageControl.currentPage >= pageControl.totalPage) {
            $(window).off('scroll');
        }
    })
});

function bindArticle (list) {
    if (list == null) {
        return;
    }
    var $content = $('#content');
    var html = '';
    $.each(list, function (i, article) {
        html += '<div class="content-item">';
        html += '<h4>';
        html += '<a href="/article/' + article.id + '">' + article.title.replace($('#search-content').val(), '<span class="search-key-words">' + $('#search-content').val() + '</span>') + '</a><br>';
        html += '<small><span class="catalog-time">类别:' + article.catalog + '</span>';
        html += '<span class="catalog-time">日期:' + new Date(article.createTime).format('yyyy-MM-dd HH:mm:ss') + '</span>';
        html += '</small></h4><p class="content-validity-p">';
        var content = new String(article.htmlContent).replace(/<.+?>/g, '');
        html += content.substr(0, Math.min(content.length, 300)) + '...';
        html += '';
        html += '</p>';
        html += '</div>';
    });
    $content.append(html);
}
