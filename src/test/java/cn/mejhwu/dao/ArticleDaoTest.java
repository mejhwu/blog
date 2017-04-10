package cn.mejhwu.dao;

import cn.mejhwu.beans.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午3:29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ArticleDaoTest {
	
	/*@Resource
	ArticleDao articleDao;
	
	Article article = new Article();
	{
		article.setId(1);
		article.setTitle("test");
		article.setContent("test");
		article.setAuthorId(2);
		article.setCatalogId(5);
	}
	
	@Test
	public void queryAllArticle() throws Exception {
		System.out.println(articleDao.queryAllArticle(0, 0));
	}
	
	@Test
	public void queryArticleByCatalog() throws Exception {
		System.out.println(articleDao.queryArticleByCatalog(5,0, 0));
	}
	
	@Test
	public void queryArticleByAuthor() throws Exception {
		System.out.println(articleDao.queryArticleByAuthor(1,0, 0));
	}
	
	@Test
	public void queryArticleByTitle() throws Exception {
		System.out.println(articleDao.queryArticleByTitle("3",0, 0));
	}
	
	@Test
	public void queryArticleByContent() throws Exception {
		System.out.println(articleDao.queryArticleByContent("t",0, 0));
	}
	
	@Test
	public void queryArticleByDate() throws Exception {
		
		Date startDate = new Date("2017/4/9");
		Date endDate = new Date("2017/4/10");
		
		System.out.println(articleDao.queryArticleByDate(null, endDate,0, 0));
		System.out.println(articleDao.queryArticleByDate(startDate, null,0, 0));
		System.out.println(articleDao.queryArticleByDate(startDate,endDate,0, 0));
	}
	
	@Test
	public void insertArticle() throws Exception {
		article.setTitle("test3");
		article.setContent("test3");
		article.setAuthorId(1);
		article.setCatalogId(5);
		articleDao.insertArticle(article);
	}
	
	@Test
	public void updateArticle() throws Exception {
		article.setTitle("test2");
		articleDao.updateArticle(article);
	}
	
	@Test
	public void deleteArticle() throws Exception {
		articleDao.deleteArticle(2);
	}*/
	
}