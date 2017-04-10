package cn.mejhwu.service;

import cn.mejhwu.beans.User;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午4:18.
 */
public interface UserService {
	
	/**
	 * 判断用户是否存在
	 * @param user
	 * @return
	 */
	User queryUser(User user);
}
