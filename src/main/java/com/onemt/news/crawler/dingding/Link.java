package com.onemt.news.crawler.dingding;

public class Link {
	private String title;
	private String text;
	private String picUrl;
	private String messageUrl;

	public Link() {
		super();
	}

	public Link(String title, String text, String picUrl, String messageUrl) {
		super();
		this.title = title;
		this.text = text;
		this.picUrl = picUrl;
		this.messageUrl = messageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMessageUrl() {
		return messageUrl;
	}

	public void setMessageUrl(String messageUrl) {
		this.messageUrl = messageUrl;
	}
}
