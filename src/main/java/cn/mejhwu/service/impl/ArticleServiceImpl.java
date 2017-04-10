package cn.mejhwu.service.impl;

import cn.mejhwu.beans.Article;
import cn.mejhwu.dao.ArticleDao;
import cn.mejhwu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午4:58.
 */

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleDao articleDao;
	
	public List<Article> queryArticle(Article article, int start, int limit) {
		return articleDao.queryArticle(article, start, limit);
	}
	
	public int queryArticleCount(Article article){
		return articleDao.queryArticleCount(article);
	}
	
	public List<Article> queryArticleByCatalog(int catalogId, int start, int limit) {
		return articleDao.queryArticleByCatalog(catalogId,start, limit);
	}
	
	public List<Article> queryArticleByAuthor(int authorId, int start, int limit) {
		return articleDao.queryArticleByAuthor(authorId, start, limit);
	}
	
	public List<Article> queryArticleByTitle(String keyWords, int start, int limit) {
		return articleDao.queryArticleByTitle(keyWords, start, limit);
	}
	
	public List<Article> queryArticleByContent(String keyWords, int start, int limit) {
		return articleDao.queryArticleByContent(keyWords, start, limit);
	}
	
	public List<Article> queryArticleByDate(Date startDate, Date endDate, int start, int limit) {
		return articleDao.queryArticleByDate(startDate, endDate,start, limit);
	}
	
	public Article queryArticleById(int id) {
		return articleDao.queryArticleById(id);
	}
	
	public int insertArticle(Article article) {
		return articleDao.insertArticle(article);
	}
	
	public int updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}
	
	public int deleteArticle(int id) {
		return articleDao.deleteArticle(id);
	}
	
	/**
	 * 前台查询操作接口
	 * @param keyWords
	 * @return
	 */
	public List<Article> search(String keyWords, int start, int limit) {
		List<Article> searchTitles = queryArticleByTitle(keyWords, start, limit);
		List<Article> searchContents = queryArticleByContent(keyWords, start, limit);
		searchTitles.addAll(searchContents);
		return searchTitles;
	}
}
