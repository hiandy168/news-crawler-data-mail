package com.onemt.news.crawler.mysql.biz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onemt.news.crawler.mysql.biz.entity.CategoryVo;
import com.onemt.news.crawler.mysql.biz.mapper.ArticleCategoryMapper;

@Repository
public class ArticleCategoryDao {
	
	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;
	
	
	public List<CategoryVo> selectByFetchTime(String date){
		return articleCategoryMapper.selectByFetchTime(date);
	}
}