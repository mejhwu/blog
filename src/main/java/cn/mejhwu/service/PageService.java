package cn.mejhwu.service;

import cn.mejhwu.beans.Article;
import cn.mejhwu.beans.Comment;
import cn.mejhwu.dto.Pager;

import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-14
 * Time: 下午5:49.
 */
public interface PageService {
	
	Pager<Article> getArticlePage(int pageNum, Article article);
	
	
	Pager<Comment> getCommentPage(int pageNum, int type, int articleId);
}
