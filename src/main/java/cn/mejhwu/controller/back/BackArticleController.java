package cn.mejhwu.controller.back;

import cn.mejhwu.beans.Article;
import cn.mejhwu.beans.User;
import cn.mejhwu.dto.Pager;
import cn.mejhwu.service.ArticleService;
import cn.mejhwu.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-9
 * Time: 上午12:57.
 */
@Controller
@RequestMapping("/back/article")
public class BackArticleController {
	
	private final static Logger logger = LoggerFactory.getLogger(BackArticleController.class);
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	CatalogService catalogService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String articleList(Model model){
		model.addAttribute("catalogs", catalogService.queryAllCatalog());
		return "back/articleList";
	}
	
	@RequestMapping(value = "goEdit", method = RequestMethod.GET)
	public String goEdit(Model model) {
		model.addAttribute("catalogs", catalogService.queryAllCatalog());
		return "back/edit";
	}
	
	@RequestMapping(value = "/save",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public int saveArticle(Article article, HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		logger.info(user.toString());
		article.setAuthorId(user.getId());
		int res = articleService.insertArticle(article);
		return res;
	}
	
	@RequestMapping(value = "goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(@PathVariable("id") int id, Model model) {
		model.addAttribute("catalogs", catalogService.queryAllCatalog());
		model.addAttribute("article", articleService.queryArticleById(id));
		return "back/edit";
	}
	
	@RequestMapping(value = "/update/{id}",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public int updateArticle(Article article, @PathVariable("id") int id) {
		article.setId(id);
		return articleService.updateArticle(article);
	}
	
	
	@RequestMapping(value = "/detail/{id}",
			method = RequestMethod.GET)
	public String deatilArticle(@PathVariable("id") int id, Model model) {
		model.addAttribute("article", articleService.queryArticleById(id));
		return "back/articleDetail";
	}
	
	
	@RequestMapping(value = "/delete/{id}",
					method = RequestMethod.POST,
					produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public int deleteArticle(@PathVariable("id") int id) {
		return articleService.deleteArticle(id);
	}
	
}
