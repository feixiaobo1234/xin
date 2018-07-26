package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	ÿ�ֵļ���
	private  List<T> date;
//	һ����ҳ
	private  int totalPage;
//	��ǰ��ҳ
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
