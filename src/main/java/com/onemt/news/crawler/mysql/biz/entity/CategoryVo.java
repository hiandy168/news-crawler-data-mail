package com.onemt.news.crawler.mysql.biz.entity;

import java.io.Serializable;

public class CategoryVo implements Serializable{

	private static final long serialVersionUID = -1483294958132880032L;
	
	private String id;
	private String note;
	private String total;
	
	
	public CategoryVo() {
	}


	public CategoryVo(String id, String note, String total) {
		super();
		this.id = id;
		this.note = note;
		this.total = total;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
	
}
