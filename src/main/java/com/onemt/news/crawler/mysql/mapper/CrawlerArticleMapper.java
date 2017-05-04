package com.onemt.news.crawler.mysql.mapper;

import java.util.List;

import com.onemt.news.crawler.mysql.entity.ArticlePerHourStatVo;
import com.onemt.news.crawler.mysql.entity.ArticleVo;

public interface CrawlerArticleMapper extends BaseMapper {
	 
	List<ArticleVo> selectByFetchTime(String date);
	 
	 List<ArticlePerHourStatVo> selectPerHourStat();
}
