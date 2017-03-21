package com.onemt.news.crawler.mysql.biz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onemt.news.crawler.mysql.biz.entity.SubcategoryVo;
import com.onemt.news.crawler.mysql.biz.mapper.ArticleSubcategoryMapper;

@Component
public class ArticleSubcategoryDao {
	
	@Autowired
	private ArticleSubcategoryMapper articleSubcategoryMapper;
	
	
	public List<SubcategoryVo> selectByFetchTime(String date){
		return articleSubcategoryMapper.selectByFetchTime(date);
	}
	
}