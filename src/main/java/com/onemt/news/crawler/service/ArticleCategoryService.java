package com.onemt.news.crawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onemt.news.crawler.multidatasource.DataSource;
import com.onemt.news.crawler.mysql.biz.dao.ArticleCategoryDao;
import com.onemt.news.crawler.mysql.biz.entity.CategoryVo;

@Service
public class ArticleCategoryService {

	@Autowired
	private ArticleCategoryDao articleCategoryDao;
	
	@DataSource("newsDataSource")
	public List<CategoryVo> selectByFetchTime(String date){
		return articleCategoryDao.selectByFetchTime(date);
	}
	
}
