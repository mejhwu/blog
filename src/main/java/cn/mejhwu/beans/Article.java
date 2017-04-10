package cn.mejhwu.beans;

import java.util.Date;

/**
 * 文章
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午2:23.
 */
public class Article {
	private int id;				//文章id
	private String title;		//文章标题
	private String editContent;		//编辑文章内容
	private String htmlContent;		//显示文章内容
	private int authorId;		//文章作者id
	private String authorName;  //文章作者
	private int catalogId;		//文章类别id
	private String catalog;		//文章类别
	private Date createTime;	//创建时间
	private Date updateTime;	//修改时间
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
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
	
	public int getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public int getCatalogId() {
		return catalogId;
	}
	
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
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
		return "Article{" +
				"id=" + id +
				", title='" + title + '\'' +
				", editContent='" + editContent + '\'' +
				", htmlContent='" + htmlContent + '\'' +
				", authorId=" + authorId +
				", authorName='" + authorName + '\'' +
				", catalogId=" + catalogId +
				", catalog='" + catalog + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				"}\n";
	}
}
