package com.onemt.news.crawler.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.onemt.news.crawler.mysql.entity.MediaCategoryVo;
import com.onemt.news.crawler.mysql.entity.MediaOpenVo;
import com.onemt.news.crawler.mysql.entity.MediaVo;
import com.onemt.news.crawler.service.CrawlerMediaCategoryService;

@SessionAttributes("date")
@Controller
public class MediaShowDataCotroller {

	
	@Autowired
	private CrawlerMediaCategoryService crawlerMediaCategoryService;
	
	@RequestMapping("/mediashow")
	public String showMediaIndex(@RequestParam("date") String date, Model model){
		model.addAttribute("date", date);
		return "mediashow";
	}
	
	 //统计每天数据源采集情况
	@ResponseBody
	@RequestMapping("/media")
	public  List<MediaVo> showData(Model model,@RequestParam(name="type",required=false)String type){
		Map<String, Object> asMap = model.asMap();
		List<MediaVo> mediaVos = crawlerMediaCategoryService.selectByFetchTimeForMedia((String) asMap.get("date"),type);
		return mediaVos;
	}
	
	
	
	// 统计每天数据源及其子分类采集情况
	@ResponseBody
	@RequestMapping("/mediacategory")
	public List<MediaCategoryVo> showMediaCategoryData(Model model) {
		Map<String, Object> asMap = model.asMap();
		List<MediaCategoryVo> mediaCategoryVos = crawlerMediaCategoryService.selectByFetchTimeForCategory((String) asMap.get("date"));
		return mediaCategoryVos;
	}
	
	//统计未开启采集的数据源
	@ResponseBody
	@RequestMapping("/mediaopen")
	public List<MediaOpenVo> showMediaopenData(Model model) {
		List<MediaOpenVo> mediaOpenVos = crawlerMediaCategoryService.selectForMedia();
		return mediaOpenVos;
	}
	

}
