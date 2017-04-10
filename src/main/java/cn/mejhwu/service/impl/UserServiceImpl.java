package cn.mejhwu.service.impl;

import cn.mejhwu.beans.User;
import cn.mejhwu.dao.UserDao;
import cn.mejhwu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午4:38.
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User queryUser(User user) {
		return userDao.queryUser(user);
	}
}
