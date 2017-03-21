package com.onemt.news.crawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onemt.news.crawler.multidatasource.DataSource;
import com.onemt.news.crawler.mysql.dao.CrawlerMediaCategoryDao;
import com.onemt.news.crawler.mysql.entity.MediaCategoryVo;
import com.onemt.news.crawler.mysql.entity.MediaOpenVo;
import com.onemt.news.crawler.mysql.entity.MediaVo;

@Service
public class CrawlerMediaCategoryService {

	@Autowired
	private CrawlerMediaCategoryDao crawlerMediaCategoryDao;
	
	@DataSource("crawlerDataSource")
	public List<MediaCategoryVo> selectByFetchTimeForCategory(String date){
		return crawlerMediaCategoryDao.selectByFetchTimeForCategory(date);
	}
	
	
	@DataSource("crawlerDataSource")
	public List<MediaVo> selectByFetchTimeForMedia(String date,String type){
		return crawlerMediaCategoryDao.selectByFetchTimeForMedia(date,type);
	}
	
	@DataSource("crawlerDataSource")
	public List<MediaOpenVo> selectForMedia(){
		return crawlerMediaCategoryDao.selectForMedia();
	}
	
}
