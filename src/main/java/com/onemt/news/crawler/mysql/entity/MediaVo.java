package com.onemt.news.crawler.mysql.entity;

public class MediaVo {

    private String id;

    private String total;

    
	public MediaVo() {
	}


	public MediaVo(String id, String total) {
		this.id = id;
		this.total = total;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}

}
