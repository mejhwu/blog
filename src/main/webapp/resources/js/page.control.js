var pageControl = {
    isLoading : false, //是否正在加载更多数据
	totalPage : 0,
	currentPage : 0,
	totalRecord : 0,
	pageType : null,
	searchData : null,
	firstPage : function () {
		return pageControl.pageJump(1);
	},
	nextPage : function () {
		return pageControl.pageJump(pageControl.currentPage + 1);
	},
	prePage : function () {
		return pageControl.pageJump(pageControl.currentPage - 1);
	},
	curPage : function () {
		return pageControl.pageJump(pageControl.currentPage);
	},
	pageJump : function (pageNum) {

        if (pageControl.isLoading) {
            return;
        }
        pageControl.isLoading = true;
		var res = null;
		$.ajax({
			url : '/page/' + pageNum + '/' + pageControl.pageType,
			type : 'get',
			dataType : 'json',
			async : false,
			data : pageControl.searchData,
			success : function (data) {
				pageControl.currentPage = data.currentPage;
				pageControl.totalPage = data.totalPage;
				if (pageControl.totalPage <= 0) {
					pageControl.totalPage = 1;
				}
				pageControl.totalRecord = data.totalRecord;

				res = data.data;
				pageControl.isLoading = false;
			},
			error : function (data) {
				alert('加载失败!');
			}
		});
		return res;
	},

	/**
	 * 绑定分页按钮的click事件
	 * @param bind	毁掉函数,讲结果绑定到表格
	 */
	bindBtnClick : function (bind) {
		//绑定上一页点击事件
		$('#pre-page-btn').click(function () {
			bind(pageControl.prePage());
		});
		//绑定下一页点击事件
		$('#next-page-btn').click(function () {
			bind(pageControl.nextPage());
		});
		//绑定页面转跳事件
		$('#page-jump-btn').click(function () {
			var pageNum = $('#page-number-input').val();
			if (pageNum >= pageControl.totalPage) {
				pageNum = pageControl.totalPage;
			}
			if (pageNum <= 1) {
				pageNum = 1;
			}
			bind(pageControl.pageJump(pageNum));
		});
	},

	/**
	 * 设置上一页和下一页按钮是否可点击
	 */
	setBtnDisable : function () {
		if (pageControl.currentPage >= pageControl.totalPage) {
			$('#next-page-btn').attr('disabled',true);
		} else {
			$('#next-page-btn').attr('disabled',false);
		}

		if (pageControl.currentPage <= 1) {
			$('#pre-page-btn').attr('disabled',true);
		} else {
			$('#pre-page-btn').attr('disabled',false);
		}
	}


}