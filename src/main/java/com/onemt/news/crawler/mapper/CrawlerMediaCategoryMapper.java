package com.onemt.news.crawler.mapper;

import java.util.List;

import com.onemt.news.crawler.entity.CrawlerMediaCategory;

public interface CrawlerMediaCategoryMapper extends BaseMapper{

	int deleteByPrimaryKey(Integer id);

	int insert(CrawlerMediaCategory record);

	int insertSelective(CrawlerMediaCategory record);

	CrawlerMediaCategory selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CrawlerMediaCategory record);

	int updateByPrimaryKey(CrawlerMediaCategory record);

    List<CrawlerMediaCategory> selectAllEnable();
    
    List<CrawlerMediaCategory> selectByType(String type);
}