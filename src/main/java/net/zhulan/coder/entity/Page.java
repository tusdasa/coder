package net.zhulan.coder.entity;

public class Page {
	private int pageSize=3;
	private int pageNum=0;
	public Page() {
		
	}
	public Page(int pageNum) {
		this.setPageNum(pageNum);
	}
	public Page(int pageSize, int pageNum) {
		this.setPageNum(pageNum);
		this.setPageSize(pageSize);
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
