package cn.mejhwu.service.impl;

import cn.mejhwu.beans.Comment;
import cn.mejhwu.dao.CommentDao;
import cn.mejhwu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-13
 * Time: 下午11:00.
 */

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentDao commentDao;
	
	public int insertComment(Comment comment) {
		return commentDao.insertComment(comment);
	}
	
	public List<Comment> queryCommentByArticleId(int articleId, int start ,int limit) {
		return commentDao.queryCommentByArticleId(articleId, start, limit);
	}
	
	public int queryCommentByArticleIdCount(int articleId){
		return commentDao.queryCommentByArticleIdCount(articleId);
	}
	
	public List<Comment> queryAllComment(int start ,int limit) {
		return commentDao.queryAllComment(start, limit);
	}
	
	public int queryAllCommentCount() {
		return commentDao.queryAllCommentCount();
	}
	
	public List<Comment> queryCommentNotCommented(int start ,int limit) {
		return commentDao.queryCommentNotCommented(start, limit);
	}
	
	public int queryCommentNotCommentedCount() {
		return commentDao.queryCommentNotCommentedCount();
	}
	
	public List<Comment> queryNotCommentedByArticleId(int articleId, int start ,int limit) {
		return commentDao.queryNotCommentedByArticleId(articleId, start, limit);
	}
	
	public int queryNotCommentedByArticleIdCount(int articleId) {
		return commentDao.queryNotCommentedByArticleIdCount(articleId);
	}
	
	public List<Comment> queryComment(int articleId, int commented, int start, int limit) {
		return commentDao.queryComment(articleId, commented, start, limit);
	}
	
	public int queryCommentCount(int articleId, int commented) {
		return commentDao.queryCommentCount(articleId, commented);
	}
	
	public Comment queryCommentById(int id){
		return commentDao.queryCommentById(id);
	}
}
