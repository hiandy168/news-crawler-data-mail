package com.onemt.news.crawler.mysql.entity;

public class ArticleVo {

	private String date;
	private String type;
	private String total;
	public ArticleVo(){}
	public ArticleVo(String date, String type, String total) {
		super();
		this.date = date;
		this.type = type;
		this.total = total;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
}
