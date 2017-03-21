package com.onemt.news.crawler.pojo;

import java.io.Serializable;

public class CrawlerData implements Serializable {

	private static final long serialVersionUID = 2473191523500349454L;
	private String[] date;
	private String[] textData;
	private String[] galleryData;
	private String[] videoData;
	
	public CrawlerData() {
	}

	public CrawlerData(String[] date, String[] textData, String[] galleryData,
			String[] videoData) {
		this.date = date;
		this.textData = textData;
		this.galleryData = galleryData;
		this.videoData = videoData;
	}
	
	
	
	public String[] getDate() {
		return date;
	}


	public void setDate(String[] date) {
		this.date = date;
	}


	public String[] getTextData() {
		return textData;
	}


	public void setTextData(String[] textData) {
		this.textData = textData;
	}


	public String[] getGalleryData() {
		return galleryData;
	}


	public void setGalleryData(String[] galleryData) {
		this.galleryData = galleryData;
	}


	public String[] getVideoData() {
		return videoData;
	}


	public void setVideoData(String[] videoData) {
		this.videoData = videoData;
	}


	
}
