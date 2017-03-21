package com.onemt.news.crawler.mysql.entity;

public class MediaOpenVo {

    private String id;

    private String type;

    
	public MediaOpenVo() {
	}


	public MediaOpenVo(String id, String type) {
		this.id = id;
		this.type = type;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
}
