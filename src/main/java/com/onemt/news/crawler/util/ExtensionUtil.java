package com.onemt.news.crawler.util;

import java.util.HashMap;
import java.util.Map;

public class ExtensionUtil {
	private static Map<String, String> extMap = new HashMap<String, String>();
	static{
		extMap.put("image/jpeg", ".jpg");
		extMap.put("image/jpeg", ".jpg");
		extMap.put("image/png", ".png");
		extMap.put("application/x-png", ".jpg");
		extMap.put("image/tiff", ".tif");
		extMap.put("image/gif", ".gif");
	}
	
	public static String getExt(String contentType){
		return extMap.get(contentType.trim().toLowerCase());
	}
}
