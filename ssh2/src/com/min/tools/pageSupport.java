package com.min.tools;

import java.util.ArrayList;
import java.util.List;

public class pageSupport<T>{

	// 总记录数
	private int totalCount;
	// 总页数
	private int totalPageCount;
	// 当前页
	private int currPageNo=1;
	// 每页几条
	private int pageSize=5;
	
	private List<T> itme= new ArrayList<T>();
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageCount() {
		if (totalCount%pageSize==0) {
			totalPageCount=totalCount/pageSize;
		}else if (totalCount%pageSize!=0){
			totalPageCount=totalCount/pageSize+1;
		}
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		if (currPageNo<0) {
			this.currPageNo=1;
		}else {
			this.currPageNo=currPageNo;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getItme() {
		return itme;
	}
	public void setItme(List<T> itme) {
		this.itme = itme;
	}
	
	
	
	
}
