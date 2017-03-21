package com.onemt.news.crawler.mysql.entity;

public class MediaCategoryVo {

	private String id;

    private String mediaId;

    private String total;

    
	public MediaCategoryVo() {
	}


	public MediaCategoryVo(String id, String mediaId, String total) {
		this.id = id;
		this.mediaId = mediaId;
		this.total = total;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMediaId() {
		return mediaId;
	}


	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}

   
	
}