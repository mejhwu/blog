var pageControl = {
	totalPage : 0,
	currentPage : 0,
	totalRecord : 0,
	searchData : null,
	firstPage : function (type) {
		return pageControl.pageJump(1, type);
	},
	nextPage : function (type) {
		return pageControl.pageJump(pageControl.currentPage + 1, type);
	},
	prePage : function (type) {
		return pageControl.pageJump(pageControl.currentPage - 1, type);
	},
	pageJump : function (pageNum, type) {
		var res;
		console.log(pageControl.searchData);
		$.ajax({
			url : '/page/' + pageNum + '/' + type,
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
			},
			error : function (data) {
				alert('加载失败!');
			}
		});
		return res;
	},

	/**
	 * 绑定分页按钮的click时间
	 * @param type	请求内容类型
	 * @param dat	搜索内容
	 * @param bind	毁掉函数,讲结果绑定到表格
	 */
	bindBtnClick : function (type, bind) {
		//绑定上一页点击事件
		$('#pre-page-btn').click(function () {
			bind(pageControl.prePage(type));
		});
		//绑定下一页点击事件
		$('#next-page-btn').click(function () {
			bind(pageControl.nextPage(type));
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
			bind(pageControl.pageJump(pageNum, type));
		});
	},

	/**
	 * 设置上一页和下一页按钮是否可点击
	 */
	setBtnDisable : function () {
		if (pageControl.currentPage >= pageControl.totalPage) {
			console.log('next');
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