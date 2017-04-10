package cn.mejhwu.controller;

import cn.mejhwu.beans.Article;
import cn.mejhwu.dto.Pager;
import cn.mejhwu.service.ArticleService;
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
	ArticleService articleService;
	
	@RequestMapping(value = "/{pageNum}/article",
			method = RequestMethod.GET,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public Pager<Article> getPage(@PathVariable("pageNum") int pageNum, HttpServletRequest request){
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
		Pager<Article> pager = new Pager<Article>();
		pager.setCurrentPage(pageNum);
		pager.setPageSize(15);
		
		pager.setTotalRecord(articleService.queryArticleCount(article));
		pager.setTotalPage(pager.caculateTotalPage());
		//分页开始位置
		int start = pager.getPageSize() * (pager.getCurrentPage() - 1);
		//分页数量
		int limit = pager.getPageSize();
		pager.setData(articleService.queryArticle(article, start, limit));
		return pager;
	}
}
