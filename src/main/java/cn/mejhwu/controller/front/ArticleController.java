package cn.mejhwu.controller.front;

import cn.mejhwu.service.ArticleService;
import cn.mejhwu.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by mejhwu on 17-4-11.
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CatalogService catalogService;


    @RequestMapping(value = "/",
                    method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("catalogs", catalogService.queryAllCatalog());
        return "front/index";
    }

    @RequestMapping(value = "/article/{id}",
            method = RequestMethod.GET)
    public String detailArticle(@PathVariable("id") int id, Model model) {
        model.addAttribute("article", articleService.queryArticleById(id));
        return "front/article";
    }
}
