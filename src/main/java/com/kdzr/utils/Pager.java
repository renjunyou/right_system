package com.kdzr.utils;

@SuppressWarnings({"unused"})
public class Pager {

	private int currentPage;//当前页
	private int pageSize=3;//每页显示行数
	private int totalSize;//总行数
	private int totalPage;//总页数
	private boolean hasFirst;//是否 首页
	private boolean hasPrevious;//是否有 上一页
	private boolean hasNext;//是否有 下一页
	private boolean hasLast;//是否 尾页
	private String isFirst="yes";
	public Pager(){	
	}
	public Pager(int currentPage, int totalSize) {
		this.currentPage = currentPage;
		this.totalSize = totalSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public boolean isHasFirst() {
		if (currentPage == 1 || currentPage == 0)
			return false;
		else
			return true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	public boolean isHasLast() {
		if (currentPage == getTotalPage()||getTotalPage()==0)
			return false;
		else
			return true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	public boolean isHasNext() {
		if (isHasLast())
			return true;
		else
			return false;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public boolean isHasPrevious() {
		if(currentPage == 0 || currentPage==1) return false;//|| currentPage==-1
		if (isHasFirst())
			return true;
		else
			return false;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		totalPage = totalSize / pageSize;
		if (totalSize % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	public String getIsFirst() {
		return isFirst;
	}


	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}
}
