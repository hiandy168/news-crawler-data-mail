package com.onemt.news.crawler.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.onemt.news.crawler.entity.Book;

@SessionAttributes("date")
@Controller
public class ShowDataCotroller {

	
	@Autowired
	private RedisTemplate<String,String> jedisTemplate;
	 
	private static final String TIMESTAMPKEY="crawler_article";
	
	@RequestMapping("/show")
	public String showIndex(@RequestParam("date") String date, Model model){
		model.addAttribute("date", date);
		
		HashOperations<String, Object, Object> opsForHash = jedisTemplate.opsForHash();
		
		List<Book> books=new ArrayList<Book>();
		Book book=new Book();
		book.setId("1");
		book.setName("英语");
		book.setPrice(100d);
		books.add(book);
		opsForHash.put(TIMESTAMPKEY, date , books);
		
		return "show";
	}
	
	
	@ResponseBody
	@RequestMapping("/data1.json")
	public List<Book> showData(Model model){
		Map<String, Object> asMap = model.asMap();
		System.out.println(asMap.get("date"));
		HashOperations<String, Object, Object> opsForHash = jedisTemplate.opsForHash();
		List<Book> books = (List<Book>) opsForHash.get(TIMESTAMPKEY, asMap.get("date"));
		return books;
	}
	
	
}
