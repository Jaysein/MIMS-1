package com.json.model;

import java.util.List;

public class PageInfo {
	
	private int pageSize; //ÿҳ��ʾ����
	private int pageNumber;//��ǰ�ڼ�ҳ
	private long total;  //��ҳ��
	private List<?> list;  //��ǰҳ����
	private int pageStart;
	private String user_name;
	
	public PageInfo() {
		
	}
	

	public PageInfo(int pageSize, int pageNumber, long total, List<?> list, int pageStart, String user_name) {
		super();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.total = total;
		this.list = list;
		this.pageStart = pageStart;
		this.user_name = user_name;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
	}
	
	public List<?> getList() {
		return list;
	}
	
	public void setList(List<?> list) {
		this.list = list;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public String toString() {
		return "PageInfo [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", total=" + total + ", list=" + list
				+ ", pageStart=" + pageStart + ", user_name=" + user_name + "]";
	}
	
}
