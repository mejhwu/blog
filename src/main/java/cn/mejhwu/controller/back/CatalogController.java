package cn.mejhwu.controller.back;

import cn.mejhwu.beans.Catalog;
import cn.mejhwu.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
			method = RequestMethod.GET,
			produces = {"application/json;charset=UTF-8"}
	)
	@ResponseBody
	public List<Catalog> all(){
		return catalogService.queryAllCatalog();
	}
	
}
