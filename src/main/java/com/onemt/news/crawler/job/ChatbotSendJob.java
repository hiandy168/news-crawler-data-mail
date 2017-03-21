package com.onemt.news.crawler.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.onemt.news.crawler.dingding.DingDingMessage;
import com.onemt.news.crawler.dingding.DingDingUtil;
import com.onemt.news.crawler.dingding.Link;

@Component
public class ChatbotSendJob {

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private final static Calendar c = Calendar.getInstance();
	

	@Value("${media.url}")
	private String mediaUrl;
	
	@Value("${category.url}")
	private String categoryUrl;
	

	public void init() {
		c.setTime(new Date());
		c.add(Calendar.DATE, -1);
		String date = sdf.format(c.getTime());
		
		DingDingMessage mediashowMsg = new DingDingMessage();
		mediashowMsg.setMsgtype(DingDingMessage.MSGTYPE_LINK);
		Link mediashowLink = new Link();
		mediashowLink.setTitle("新闻源采集统计");
		mediashowLink.setText(date+"新闻源统计详情");
		mediashowLink.setMessageUrl(mediaUrl+"?date="+date);
		mediashowMsg.setLink(mediashowLink);
		mediashowMsg.setIsAtAll(true);
		DingDingUtil.sendMessage(mediashowMsg);
		
		DingDingMessage categoryshowMsg = new DingDingMessage();
		categoryshowMsg.setMsgtype(DingDingMessage.MSGTYPE_LINK);
		Link categoryshowLink = new Link();
		categoryshowLink.setTitle("分类采集统计");
		categoryshowLink.setText(date+"分类统计详情");
		categoryshowLink.setMessageUrl(categoryUrl+"?date="+date);
		categoryshowMsg.setLink(categoryshowLink);
		categoryshowMsg.setIsAtAll(true);
		DingDingUtil.sendMessage(categoryshowMsg);
	
	}

}
