package cn.mejhwu.controller;

import cn.mejhwu.beans.Article;
import cn.mejhwu.dto.Pager;
import cn.mejhwu.service.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-9
 * Time: 下午2:17.
 */
@Controller
@RequestMapping("/page")
public class PageController {
	
	private final static Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	PageService pageService;
	
	/**
	 * 文章分页管理
	 * @param pageNum
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/{pageNum}/article",
			method = RequestMethod.GET,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public Pager<Article> getArticlePage(@PathVariable("pageNum") int pageNum, HttpServletRequest request){
		logger.info(request.getParameterMap().toString());
		Article article = new Article();
		article.setTitle(request.getParameter("title"));
		if (request.getParameter("catalog") != null) {
			article.setCatalogId(Integer.valueOf(request.getParameter("catalog")));
		}
		//查询时用createTime代表查询时间范围的开始时间,updateTime代表结束时间
		if (request.getParameter("startTime") != null) {
			article.setCreateTime(new Date(request.getParameter("startTime").replaceAll("-","/")));
		}
		if (request.getParameter("endTime") != null) {
			article.setUpdateTime(new Date(request.getParameter("endTime").replaceAll("-","/")));
		}
		return pageService.getArticlePage(pageNum, article);
	}
	
	
	/**
	 * 评论分页
	 * @param pageNum
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = "/{pageNum}/comment",
			method = RequestMethod.GET,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public Pager<Comment> getCommentPage(@PathVariable("pageNum") int pageNum, HttpServletRequest request){
		logger.info(request.getParameterMap().toString());
		
		int commented = 0;
		if (request.getParameter("commented") != null) {
			commented = Integer.parseInt(request.getParameter("commented"));
		}
		String articleId = request.getParameter("articleId");
		int id = 0;
		if (articleId != null) {
			id = Integer.parseInt(articleId);
		}
		return pageService.getCommentPage(pageNum, commented, id);
	}*/
}
