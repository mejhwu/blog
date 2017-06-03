package cn.mejhwu.controller.back;

import cn.mejhwu.service.ArticleService;
import cn.mejhwu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-14
 * Time: 下午4:17.
 */

@Controller
@RequestMapping("/back/comment")
public class BackCommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping(value = "/list",
					method = RequestMethod.GET)
	public String comment() {
		return "back/comment";
	}
	
	
	@RequestMapping(value = "/goReplay/{articleId}/{commentId}",
					method = RequestMethod.GET)
	public String goReplay(@PathVariable("articleId") int articleId, @PathVariable("commentId") int commentId, Model model) {
		model.addAttribute("title", articleService.queryArticleById(articleId).getTitle());
		model.addAttribute("comment", commentService.queryCommentById(commentId));
		return "/back/replay";
	}
}
