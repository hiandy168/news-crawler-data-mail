package com.onemt.news.crawler.mysql.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onemt.news.crawler.mysql.entity.MediaCategoryVo;
import com.onemt.news.crawler.mysql.entity.MediaOpenVo;
import com.onemt.news.crawler.mysql.entity.MediaVo;
import com.onemt.news.crawler.mysql.mapper.CrawlerMediaCategoryMapper;


@Repository
public class CrawlerMediaCategoryDao {
	
	@Autowired
	private CrawlerMediaCategoryMapper crawlerMediaCategoryMapper;
	
	public List<MediaCategoryVo> selectByFetchTimeForCategory(String date){
		return crawlerMediaCategoryMapper.selectByFetchTimeForCategory(date);
	}
	
	public List<MediaVo> selectByFetchTimeForMedia(String date,String type){
		return crawlerMediaCategoryMapper.selectByFetchTimeForMedia(date,type);
	}
	
	public List<MediaOpenVo> selectForMedia(){
		return crawlerMediaCategoryMapper.selectForMedia();
	}
	
}