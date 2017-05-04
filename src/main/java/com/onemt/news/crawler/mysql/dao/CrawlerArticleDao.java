package com.onemt.news.crawler.mysql.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onemt.news.crawler.mysql.entity.ArticlePerHourStatVo;
import com.onemt.news.crawler.mysql.entity.ArticleVo;
import com.onemt.news.crawler.mysql.mapper.CrawlerArticleMapper;

@Repository
public class CrawlerArticleDao {

	@Autowired
	private CrawlerArticleMapper crawlerArticleMapper;
	
	 public List<ArticleVo> selectByFetchTime(String date){
		 return crawlerArticleMapper.selectByFetchTime(date);
	 }
	 
	 
	 public  List<ArticlePerHourStatVo> selectPerHourStat(){
		 return crawlerArticleMapper.selectPerHourStat();
	 }
}
