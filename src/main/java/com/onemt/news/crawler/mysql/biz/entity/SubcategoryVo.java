package com.onemt.news.crawler.mysql.biz.entity;

import java.io.Serializable;

public class SubcategoryVo implements Serializable{

	private static final long serialVersionUID = -1560002646517807907L;
	private String id;
	private String categoryId;
	private String name;
	private String total;
	
	
	
	public SubcategoryVo() {
		super();
	}



	public SubcategoryVo(String id, String categoryId, String name, String total) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.total = total;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTotal() {
		return total;
	}



	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
}
