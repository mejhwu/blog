package cn.mejhwu.dao;

import cn.mejhwu.beans.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-13
 * Time: 下午10:19.
 */
public interface CommentDao {
	
	/**
	 * 插入评论
	 * @param comment
	 * @return
	 */
	int insertComment(Comment comment);
	
	
	/**
	 * 查询评论
	 * @param articleId
	 * @return
	 */
	List<Comment> queryComment(@Param("articleId") int articleId, @Param("commented") int commented, @Param("start") int start ,@Param("limit") int limit);
	
	/**
	 * 查询评论数量
	 * @param articleId
	 * @return
	 */
	int queryCommentCount(@Param("articleId") int articleId, @Param("commented") int commented);
	
	
	/**
	 * 根据文章ID查询评论
	 * @param articleId
	 * @return
	 */
	List<Comment> queryCommentByArticleId(@Param("articleId") int articleId, @Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 根据文章ID查询评论数据
	 * @param articleId
	 * @return
	 */
	int queryCommentByArticleIdCount(int articleId);
	
	/**
	 * 查询所有评论
	 * @return
	 */
	List<Comment> queryAllComment(@Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 查询所有评论数量
	 * @return
	 */
	int queryAllCommentCount();
	
	
	
	/**
	 * 查询所有未回复评论
	 * @return
	 */
	List<Comment> queryCommentNotCommented(@Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 查询所有未回复评论数量
	 * @return
	 */
	int queryCommentNotCommentedCount();
	
	/**
	 * 通过文章ID查询所有未回复评论
	 * @param articleId
	 * @return
	 */
	List<Comment> queryNotCommentedByArticleId(@Param("articleId") int articleId, @Param("start") int start, @Param("limit") int limit);
	
	/**
	 * 通过文章ID查询所有未回复评论数量
	 * @param articleId
	 * @return
	 */
	int queryNotCommentedByArticleIdCount(int articleId);
	
	/**
	 * 根据id查询评论
	 * @param id
	 * @return
	 */
	Comment queryCommentById(int id);
}
