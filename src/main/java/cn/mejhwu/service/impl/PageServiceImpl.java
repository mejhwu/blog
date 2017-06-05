package cn.mejhwu.service.impl;

import cn.mejhwu.beans.Article;
import cn.mejhwu.dto.Pager;
import cn.mejhwu.service.ArticleService;
import cn.mejhwu.service.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-14
 * Time: 下午5:52.
 */

@Service
public class PageServiceImpl implements PageService {
	
	private final static Logger logger = LoggerFactory.getLogger(PageServiceImpl.class);
	
	@Autowired
	ArticleService articleService;
	

	public Pager<Article> getArticlePage(int pageNum, Article article) {
		Pager<Article> pager = new Pager<Article>();
		pager.setCurrentPage(pageNum);
		pager.setPageSize(15);
		
		pager.setTotalRecord(articleService.queryArticleCount(article));
		pager.setTotalPage(pager.caculateTotalPage());
		//分页开始位置
		int start = pager.getPageSize() * (pager.getCurrentPage() - 1);
		//分页数量
		int limit = pager.getPageSize();
		pager.setData(articleService.queryArticle(article, start, limit));
		logger.info(pager.toString());
		return pager;
	}
	/*
	public Pager<Comment> getCommentPage(int pageNum, int commented, int articleId) {
		
		Pager<Comment> pager = new Pager<Comment>();
		pager.setCurrentPage(pageNum);
		pager.setPageSize(15);
		pager.setTotalRecord(commentService.queryCommentCount(articleId, commented));
		pager.setTotalPage(pager.caculateTotalPage());
		//分页开始位置
		int start = pager.getPageSize() * (pager.getCurrentPage() - 1);
		//分页数量
		int limit = pager.getPageSize();
		
		pager.setData(commentService.queryComment(articleId, commented, start, limit));

		logger.info(pager.toString());
		return pager;
	}*/
}
