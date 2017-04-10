package cn.mejhwu.service;

import cn.mejhwu.beans.Article;

import java.util.Date;
import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午4:47.
 */
public interface ArticleService {
	
	/**
	 * 查询所有文章
	 * @return
	 */
	List<Article> queryArticle(Article article, int start, int limit);
	
	/**
	 * 查询总条数
	 * @return
	 */
	int queryArticleCount(Article article);
	
	/**
	 * 根据文章类别查询
	 * @param catalogId
	 * @return
	 */
	List<Article> queryArticleByCatalog(int catalogId, int start, int limit);
	
	/**
	 * 根据作者查询
	 * @param authorId
	 * @return
	 */
	List<Article> queryArticleByAuthor(int authorId, int start, int limit);
	
	/**
	 * 根据标题查询
	 * @param keyWords
	 * @return
	 */
	List<Article> queryArticleByTitle(String keyWords, int start, int limit);
	
	/**
	 * 根据内容查询
	 * @param keyWords
	 * @return
	 */
	List<Article> queryArticleByContent(String keyWords, int start, int limit);
	
	/**
	 * 根据时间查询
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<Article> queryArticleByDate(Date startDate, Date endDate, int start, int limit);
	
	/**
	 * 通过id查询文章
	 * @param id
	 * @return
	 */
	Article queryArticleById(int id);
	
	/**
	 * 插入文章
	 * @param article
	 * @return
	 */
	int insertArticle(Article article);
	
	/**
	 * 修改文章
	 * @param article
	 * @return
	 */
	int updateArticle(Article article);
	
	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	int deleteArticle(int id);
}
