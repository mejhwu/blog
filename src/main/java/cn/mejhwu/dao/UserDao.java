package cn.mejhwu.dao;

import cn.mejhwu.beans.User;

import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午1:14.
 */
public interface UserDao {
	
	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	int insertUser(User user);
	
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	User queryUserByUserName(String userName);
	
	
	/**
	 * 根据用户id查询用户
	 * @param id
	 * @return
	 */
	User queryUserById(int id);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> queryAllUser();
	
	/**
	 * 查询用户是否存在
	 * @param user
	 * @return
	 */
	User queryUser(User user);
	
	/**
	 * 修改用户属性或删除用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int deleteUser(int id);
}
