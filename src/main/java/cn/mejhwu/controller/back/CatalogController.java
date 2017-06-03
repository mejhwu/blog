package cn.mejhwu.controller.back;

import cn.mejhwu.beans.Catalog;
import cn.mejhwu.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-9
 * Time: 下午7:12.
 */
@Controller
@RequestMapping("/back/catalog")
public class CatalogController {
	
	@Autowired
	CatalogService catalogService;
	
	@RequestMapping(value = "/all",
			method = RequestMethod.GET
	)
	public String all(Model model){
		model.addAttribute("catalogs", catalogService.queryAllCatalog());
		return "back/catalog";
	}
	
	
	@RequestMapping(value = "/add",
					method = RequestMethod.POST)
	public String add(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String catalogInput = request.getParameter("catalogInput");
		System.out.println(catalogInput);
		if (catalogInput != null || !"".equals(catalogInput.trim())) {
			Catalog catalog = new Catalog();
			catalog.setCatalog(catalogInput);
			catalogService.insertCatalog(catalog);
		}
		return "redirect:/back/catalog/all";
	}
	
	@RequestMapping(value = "/delete/{catalogId}",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public int delete(@PathVariable("catalogId") int catalogId) {
		return catalogService.deleteCatalog(catalogId);
	}
}
