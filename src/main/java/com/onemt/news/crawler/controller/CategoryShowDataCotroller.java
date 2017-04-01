package com.onemt.news.crawler.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.onemt.news.crawler.mysql.biz.entity.CategoryVo;
import com.onemt.news.crawler.mysql.biz.entity.SubcategoryVo;
import com.onemt.news.crawler.mysql.entity.ArticleVo;
import com.onemt.news.crawler.pojo.CrawlerData;
import com.onemt.news.crawler.service.ArticleCategoryService;
import com.onemt.news.crawler.service.ArticleSubcategoryService;
import com.onemt.news.crawler.service.CrawlerArticleService;

@SessionAttributes("date")
@Controller
public class CategoryShowDataCotroller {
	
	@Autowired
	private ArticleCategoryService articleCategoryService;
	
	@Autowired
	private ArticleSubcategoryService articleSubcategoryService;
	
	@Autowired
	private CrawlerArticleService crawlerArticleService;
	
	@RequestMapping("/categoryshow")
	public String showCategoryIndex(@RequestParam("date") String date, Model model){
		model.addAttribute("date", date);
		return "categoryshow";
	}

	
	// 统计每天数据源采集情况
	@ResponseBody
	@RequestMapping("/article")
	public CrawlerData showArticleData(Model model) {
		Map<String, Object> asMap = model.asMap();
		List<ArticleVo> articleVos = crawlerArticleService.selectByFetchTime((String) asMap.get("date"));
		
		Set<String> dateSet=new LinkedHashSet<>();
		List<String> textList=new ArrayList<>();
		List<String> galleryList=new ArrayList<>();
		List<String> videoList=new ArrayList<>();
		
		for (ArticleVo articleVo : articleVos) {
			dateSet.add(articleVo.getDate());
		}
		
		for (String date : dateSet) {
			textList.add(getArticleVo(articleVos,date,"text"));
			galleryList.add(getArticleVo(articleVos,date,"gallery"));
			videoList.add(getArticleVo(articleVos,date,"video"));
		}

		CrawlerData crawlerData=new CrawlerData();
		crawlerData.setDate(dateSet.toArray(new String[dateSet.size()]));
		crawlerData.setTextData(textList.toArray(new String[textList.size()]));
		crawlerData.setGalleryData(galleryList.toArray(new String[galleryList.size()]));
		crawlerData.setVideoData(videoList.toArray(new String[galleryList.size()]));
		
		return crawlerData;
	}
	
	
	private String getArticleVo(List<ArticleVo> articleVos, String date,String type) {
		for (ArticleVo articleVo : articleVos) {
			if(date.equals(articleVo.getDate())&&type.equals(articleVo.getType())){
					return articleVo.getTotal();
			}
		}
		return "";
	}


	// 统计每天数据源采集情况
	@ResponseBody
	@RequestMapping("/category")
	public List<CategoryVo> showCategoryData(Model model) {
		Map<String, Object> asMap = model.asMap();
		List<CategoryVo> categoryVos = articleCategoryService.selectByFetchTime((String) asMap.get("date"));
		return categoryVos;
	}

	// 统计每天数据源采集情况
	@ResponseBody
	@RequestMapping("/subcategory")
	public List<SubcategoryVo> showSubcategoryData(Model model) {
		Map<String, Object> asMap = model.asMap();
		List<SubcategoryVo> subcategoryVos = articleSubcategoryService.selectByFetchTime((String) asMap.get("date"));
		return subcategoryVos;
	}

}
