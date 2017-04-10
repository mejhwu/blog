package cn.mejhwu.beans;

import java.util.Date;

/**
 * 类别
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午2:32.
 */
public class Catalog {
	private int id;				//类别id
	private String catalog;		//类别
	private Date createTime;		//创建时间
	private Date updateTime;	//修改时间
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCatalog() {
		return catalog;
	}
	
	public void setCatalog(String catalog) {
		this.catalog = catalog;
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
		return "Catalog{" +
				"id=" + id +
				", catalog='" + catalog + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				"}\n";
	}
}
