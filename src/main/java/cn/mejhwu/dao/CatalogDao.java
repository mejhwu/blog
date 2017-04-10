package cn.mejhwu.dao;

import cn.mejhwu.beans.Catalog;

import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午2:35.
 */
public interface CatalogDao {
	
	/**
	 * 查询所有类别
	 * @return
	 */
	List<Catalog> queryAllCatalog();
	
	/**
	 * 根据id查询类别
	 * @param id
	 * @return
	 */
	Catalog queryCatalogById(int id);
	
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
	 * 根据id删除类别
	 * @param id
	 * @return
	 */
	int delteCaatalog(int id);
}
