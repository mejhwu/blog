package cn.mejhwu.service;

import cn.mejhwu.beans.Catalog;

import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午4:40.
 */
public interface CatalogService {
	
	/**
	 * 根据id查询类别
	 * @param id
	 * @return
	 */
	Catalog queryCatalogById(int id);
	
	/**
	 * 查询所有类别
 	 * @return
	 */
	List<Catalog> queryAllCatalog();
	
	/**
	 * 插入类别
	 * @param catalog
	 * @return
	 */
	int insertCatalog(Catalog catalog);
	
	/**
	 * 修改类别
	 * @param catalog
	 * @return
	 */
	int updateCatalog(Catalog catalog);
	
	/**
	 * 删除类别
	 * @param id
	 * @return
	 */
	int deleteCatalog(int id);
}
