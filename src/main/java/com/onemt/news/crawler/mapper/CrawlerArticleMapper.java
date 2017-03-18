package com.onemt.news.crawler.mapper;

import com.onemt.news.crawler.entity.CrawlerArticle;

public interface CrawlerArticleMapper extends BaseMapper{


	int deleteByPrimaryKey(Long id);

	int insert(CrawlerArticle record);
	
	int insertSelective(CrawlerArticle record);

	int updateByPrimaryKey(CrawlerArticle record);
	
	int updateByPrimaryKeySelective(CrawlerArticle record);
}