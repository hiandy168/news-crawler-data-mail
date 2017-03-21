package com.onemt.news.crawler.mysql.biz.mapper;

import java.util.List;

import com.onemt.news.crawler.mysql.biz.entity.CategoryVo;
import com.onemt.news.crawler.mysql.mapper.BaseMapper;

public interface ArticleCategoryMapper  extends BaseMapper{
	List<CategoryVo> selectByFetchTime(String date);
}
