package cn.mejhwu.dao;

import cn.mejhwu.beans.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Date;
/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午2:51.
 */
public interface ArticleDao {
	
	/**
	 * 查询所有文章
	 * @param start 分页开始位置
	 * @param limit 分页数量,如果为0,表示不分页
	 * @return
	 */
	List<Article> queryArticle(@Param("article") Article article, @Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 查询所有条数
	 * @return
	 */
	int queryArticleCount(@Param("article") Article article);
	
	/**
	 * 根据文章类别查询
	 * @param start 分页开始位置
	 * @param limit 分页数量,如果为0,表示不分页*
	 * @param catalogId
	 * @return
	 */
	List<Article> queryArticleByCatalog(int catalogId, @Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 根据文章作者查询
	 * @param start 分页开始位置
	 * @param limit 分页数量,如果为0,表示不分页
	 * @param authorId
	 * @return
	 */
	List<Article> queryArticleByAuthor(int authorId, @Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 根据文章标题查询
	 * @param keyWords
	 ** @param start 分页开始位置
	 * @param limit 分页数量,如果为0,表示不分页
	 * @return
	 */
	List<Article> queryArticleByTitle(String keyWords, @Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 根据文章内容查询
	 * @param keyWords
	 * @param start 分页开始位置
	 * @param limit 分页数量,如果为0,表示不分页
	 * @return
	 */
	List<Article> queryArticleByContent(String keyWords, @Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 根据时间范围查询
	 * @param startDate	  开始时间, 如果为null,则查询早与结束时间的文章
	 * @param endDate	  结束时间, 如果为null,则查询晚于开始时间的文章
	 * @param start 分页开始位置
	 * @param limit 分页数量,如果为0,表示不分页
	 * @return
	 */
	List<Article> queryArticleByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("start") int start, @Param("limit") int limit);
	
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
	 *  删除文章
	 * @param id
	 * @return
	 */
	int deleteArticle(int id);
}
