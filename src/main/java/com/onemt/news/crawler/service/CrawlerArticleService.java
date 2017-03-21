package com.onemt.news.crawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onemt.news.crawler.multidatasource.DataSource;
import com.onemt.news.crawler.mysql.dao.CrawlerArticleDao;
import com.onemt.news.crawler.mysql.entity.ArticleVo;

@Service
public class CrawlerArticleService {

	@Autowired
	private CrawlerArticleDao crawlerArticleDao;
	
	
	@DataSource("crawlerDataSource")
	public List<ArticleVo> selectByFetchTime(String date){
		 return crawlerArticleDao.selectByFetchTime(date);
	 }
	
}
