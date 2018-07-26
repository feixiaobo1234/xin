package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	每种的集合
	private  List<T> date;
//	一共几页
	private  int totalPage;
//	当前几页
	private int currentPage;
	
	public PageModel(List<T> date, int totalPage) {
		super();
		this.date = date;
		this.totalPage = totalPage;
		
	}

public PageModel(List<T> date, int totalPage, int currentPage) {
	super();
	this.date = date;
	this.totalPage = totalPage;
	this.currentPage = currentPage;
}
public PageModel() {
	super();
}
public List<T> getDate() {
	return date;
}
public void setDate(List<T> date) {
	this.date = date;
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
	
	
	
}
