package cn.mejhwu.dao;

import cn.mejhwu.beans.Catalog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午2:46.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class CatalogDaoTest {
	
	@Resource
	CatalogDao catalogDao;
	
	Catalog catalog = new Catalog();
	{
		catalog.setId(4);
		catalog.setCatalog("test");
	}
	
	@Test
	public void queryAllCatalog() throws Exception {
		System.out.println(catalogDao.queryAllCatalog());
	}
	
	@Test
	public void insertCatalog() throws Exception {
		catalogDao.insertCatalog(catalog);
	}
	
	@Test
	public void updateCatalog() throws Exception {
		catalog.setCatalog("test2");
		catalogDao.updateCatalog(catalog);
	}
	
	@Test
	public void delteCaatalog() throws Exception {
		catalogDao.delteCaatalog(4);
	}
	
}