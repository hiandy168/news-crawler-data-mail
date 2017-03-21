package com.onemt.news.crawler.mysql.biz.mapper;

import java.util.List;

import com.onemt.news.crawler.mysql.biz.entity.SubcategoryVo;
import com.onemt.news.crawler.mysql.mapper.BaseMapper;

public interface ArticleSubcategoryMapper extends BaseMapper {

	List<SubcategoryVo> selectByFetchTime(String date);
	
}
