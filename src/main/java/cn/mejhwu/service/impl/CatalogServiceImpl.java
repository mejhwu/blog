package cn.mejhwu.service.impl;

import cn.mejhwu.beans.Catalog;
import cn.mejhwu.dao.CatalogDao;
import cn.mejhwu.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午4:44.
 */
@Service
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	CatalogDao catalogDao;
	
	public Catalog queryCatalogById(int id) {
		return catalogDao.queryCatalogById(id);
	}
	
	public List<Catalog> queryAllCatalog() {
		return catalogDao.queryAllCatalog();
	}
	
	public int insertCatalog(Catalog catalog) {
		return catalogDao.insertCatalog(catalog);
	}
	
	public int updateCatalog(Catalog catalog) {
		return catalogDao.updateCatalog(catalog);
	}
	
	public int deleteCatalog(int id) {
		return catalogDao.delteCaatalog(id);
	}
}
