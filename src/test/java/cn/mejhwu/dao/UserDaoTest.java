package cn.mejhwu.dao;

import cn.mejhwu.beans.User;
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
 * Time: 下午1:45.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {
	
	@Resource
	UserDao userDao;
	
	User user = new User();
	{
		user.setId(2);
		user.setUserName("test");
		user.setPassword("test");
		user.setName("test");
	}
	
	@Test
	public void insertUser() throws Exception {
		
		userDao.insertUser(user);
	}
	
	@Test
	public void queryUser() throws Exception {
		System.out.println(userDao.queryUserByUserName("test"));
	}
	
	@Test
	public void queryAllUser() throws Exception {
		System.out.println(userDao.queryAllUser());
	}
	
	@Test
	public void isExsit() throws Exception {
		System.out.println(userDao.queryUser(user));
	}
	
	@Test
	public void updateUser() throws Exception {
		user.setName("test1");
		userDao.updateUser(user);
	}
	
	@Test
	public void deleteUser() throws Exception {
		userDao.deleteUser(2);
	}
}