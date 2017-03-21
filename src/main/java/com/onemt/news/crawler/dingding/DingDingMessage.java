package com.onemt.news.crawler.dingding;


public class DingDingMessage {
	public static final String MSGTYPE_TEXT = "text";
	public static final String MSGTYPE_LINK = "link";
	public static final String MSGTYPE_MARKDOWN = "markdown";

	private String msgtype;
	private Text text;
	private Link link;
	private Markdown markdown;
	private At at;
	private Boolean isAtAll;

	public DingDingMessage() {
	}

	public DingDingMessage(String msgtype, Text text, Link link,
			Markdown markdown, At at, Boolean isAtAll) {
		this.msgtype = msgtype;
		this.text = text;
		this.link = link;
		this.markdown = markdown;
		this.at = at;
		this.isAtAll = isAtAll;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public Markdown getMarkdown() {
		return markdown;
	}

	public void setMarkdown(Markdown markdown) {
		this.markdown = markdown;
	}

	public At getAt() {
		return at;
	}

	public void setAt(At at) {
		this.at = at;
	}

	public Boolean getIsAtAll() {
		return isAtAll;
	}

	public void setIsAtAll(Boolean isAtAll) {
		this.isAtAll = isAtAll;
	}
}
