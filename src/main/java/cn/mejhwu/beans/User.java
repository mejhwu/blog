package cn.mejhwu.beans;

import java.util.Date;

/**
 * 用户bean
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午1:14.
 */
public class User {
	private int id;					//用户id
	private String userName;		//用户名
	private String password;		//用户密码
	private String name;			//用户昵称
	private Date createTime;		//创建时间
	private Date updateTime;		//修改时间
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				"}\n";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		User user = (User) o;
		
		return getId() == user.getId();
		
	}
	
	@Override
	public int hashCode() {
		return getId();
	}
}
