package com.onemt.news.crawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onemt.news.crawler.multidatasource.DataSource;
import com.onemt.news.crawler.mysql.biz.dao.ArticleSubcategoryDao;
import com.onemt.news.crawler.mysql.biz.entity.SubcategoryVo;

@Service
public class ArticleSubcategoryService {

	
	@Autowired
	private ArticleSubcategoryDao articleSubcategoryDao;
	
	@DataSource("newsDataSource")
	public List<SubcategoryVo> selectByFetchTime(String date){
		return articleSubcategoryDao.selectByFetchTime(date);
	}
}
