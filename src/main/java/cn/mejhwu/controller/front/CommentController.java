package cn.mejhwu.controller.front;

import cn.mejhwu.beans.Comment;
import cn.mejhwu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-13
 * Time: 下午11:02.
 */

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/insert",
					method = RequestMethod.POST,
					produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public int insertComment(Comment comment) {
		return commentService.insertComment(comment);
	}
	
}
