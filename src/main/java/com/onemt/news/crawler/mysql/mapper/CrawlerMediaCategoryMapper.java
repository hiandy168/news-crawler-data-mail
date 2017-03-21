package com.onemt.news.crawler.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.onemt.news.crawler.mysql.entity.MediaCategoryVo;
import com.onemt.news.crawler.mysql.entity.MediaOpenVo;
import com.onemt.news.crawler.mysql.entity.MediaVo;

public interface CrawlerMediaCategoryMapper extends BaseMapper{

    List<MediaCategoryVo> selectByFetchTimeForCategory(String date);
    
    List<MediaVo> selectByFetchTimeForMedia(@Param("date") String date,@Param("type") String type);
    
    List<MediaOpenVo> selectForMedia();
    
}