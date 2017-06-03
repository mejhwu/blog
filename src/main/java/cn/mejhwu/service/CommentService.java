package cn.mejhwu.service;

import cn.mejhwu.beans.Comment;

import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-13
 * Time: 下午10:59.
 */
public interface CommentService {
	/**
	 * 插入评论
	 * @param comment
	 * @return
	 */
	int insertComment(Comment comment);
	
	/**
	 * 根据文章ID查询评论
	 * @param articleId
	 * @return
	 */
	List<Comment> queryCommentByArticleId(int articleId, int start ,int limit);
	
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
	List<Comment> queryAllComment(int start ,int limit);
	
	/**
	 * 查询所有评论数量
	 * @return
	 */
	int queryAllCommentCount();
	
	/**
	 * 查询所有未回复评论
	 * @return
	 */
	List<Comment> queryCommentNotCommented(int start ,int limit);
	
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
	List<Comment> queryNotCommentedByArticleId(int articleId, int start ,int limit);
	
	/**
	 * 通过文章ID查询所有未回复评论数量
	 * @param articleId
	 * @return
	 */
	int queryNotCommentedByArticleIdCount(int articleId);
	
	
	
	/**
	 * 查询评论
	 * @param articleId
	 * @return
	 */
	List<Comment> queryComment(int articleId, int commented, int start ,int limit);
	
	/**
	 * 查询评论数量
	 * @param articleId
	 * @return
	 */
	int queryCommentCount(int articleId, int commented);
	
	/**
	 * 通过id查询评论
	 * @param id
	 * @return
	 */
	Comment queryCommentById(int id);
}
