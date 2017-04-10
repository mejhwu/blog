package cn.mejhwu.dto;

import java.util.List;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-9
 * Time: 下午12:06.
 */
public class Pager<T> {
	private int pageSize;		//每页显示多少条记录
	private int currentPage;	//当前第几页
	private int totalRecord;	//一共多少条记录
	private int totalPage;		//一共多少页
	private List<T> data;		//要显示的数据
	
	public Pager(){}
	
	public Pager(int pageSize, int currentPage, int totalRecord, int totalPage, List<T> data) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.data = data;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getTotalRecord() {
		return totalRecord;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int caculateTotalPage() {
		int num = getTotalRecord() / getPageSize();
		if (getTotalRecord() % getPageSize() != 0) {
			num ++;
		}
		return num;
	}
}
