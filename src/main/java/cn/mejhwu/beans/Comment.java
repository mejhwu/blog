package cn.mejhwu.beans;

import java.util.Date;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-13
 * Time: 下午10:19.
 */
public class Comment {
	private int id;
	private String name;
	private String email;
	private String editContent;
	private String htmlContent;
	private int articleId;
	private int commented;
	private Date createTime;
	private Date updateTime;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEditContent() {
		return editContent;
	}
	
	public void setEditContent(String editContent) {
		this.editContent = editContent;
	}
	
	public String getHtmlContent() {
		return htmlContent;
	}
	
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	
	public int getArticleId() {
		return articleId;
	}
	
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	public int getCommented() {
		return commented;
	}
	
	public void setCommented(int commented) {
		this.commented = commented;
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
		return "Comment{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", editContent='" + editContent + '\'' +
				", htmlContent='" + htmlContent + '\'' +
				", articleId=" + articleId +
				", commented=" + commented +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				"}\n";
	}
}
