package com.onemt.news.crawler.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;


public final class StringUtils extends org.apache.commons.lang.StringUtils{
	/**
     * 私有化构造函数，不允许实例化该类
     */
    private StringUtils() {
    }

    /**
     * 检查指定字符串长度，表示是否有值
     * <p><pre>
     * StringUtils.hasLength(null) = false
     * StringUtils.hasLength("") = false
     * StringUtils.hasLength(" ") = true
     * StringUtils.hasLength(" \t\n") = true
     * StringUtils.hasLength("Hello") = true
     * </pre>
     *
     * @param str 要检查的字符串
     * @return <code>true</code> 如果不为null或者空，则返回真
     * @see #hasText(CharSequence)
     * @see #isEmpty(String)
     */
    public static boolean hasLength(CharSequence str) {
        return str != null && str.length() > 0;
    }

    /**
     * 检查指定字符串是否有内容，如果为null或者全为空白字符，则返回false
     * NOTE:空字符包括空格、换行符、Tab符等
     * <p><pre>
     * StringUtils.hasText(null) = false
     * StringUtils.hasText("") = false
     * StringUtils.hasText(" ") = false
     * StringUtils.hasText(" \n\t") = false
     * StringUtils.hasText("12345") = true
     * StringUtils.hasText(" 12345 ") = true
     * </pre>
     *
     * @param str 要检查的字符串
     * @return 如果不为null且不全为空字符，则返回<code>true</code> e
     * @see Character#isWhitespace
     */
    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 检查指定字符串长度是否为空字符串
     * <p><pre>
     * StringUtils.isEmpty(null) = true
     * StringUtils.isEmpty("") = true
     * StringUtils.isEmpty(" ") = false
     * StringUtils.isEmpty("Hello") = false
     * </pre>
     *
     * @param str 要检查的字符串
     * @return 如果为null或者空，则返回<code>true</code>
     * @see #hasLength(CharSequence)
     */
    public static boolean isEmpty(String str) {
        return !hasLength(str);
    }

    /**
     * 
    * @Title: swapCase
    * @Description: 首字母大学替换成小写
    * @param @param str
    * @param @return   
    * @return String    
    * @throws
     */
	public static String swapCase(String str) {
		char[] chars = new char[1];
		chars[0] = str.charAt(0);
		String temp = new String(chars);
		if (chars[0] >= 'A' && chars[0] <= 'Z') {
			str =  str.replaceFirst(temp, temp.toLowerCase());
		}
		return str;
	}
	
	public static String replaceHtmlElement(String html) {
		Pattern p = Pattern
				.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
		Matcher m = p.matcher(html);
		List<String> srcs = new ArrayList<String>();
		while (m.find()) {
			srcs.add(m.group(1));
		}
		String regex = "<[^>]*>";
		return html.replaceAll(regex, "");
	}
	
	/**
	 * 
	* @Title: urlEncodeLastUrl
	* @Description: 将url地址最后一个斜杆后面的字符urlencode
	* @param @param urls
	* @param @return   
	* @return List<String>    
	* @throws
	 */
	public static List<String> urlEncodeLastUrl(List<String> urls){
		List<String> returnList = new ArrayList<String>();
		for(String str:urls){
			try{
				returnList.add(NewsURLEncoder.encode(str, "UTF-8"));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return returnList;
	}
	
	public static String encode(String str){
		try{
			str = URLEncoder.encode(str, "UTF-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String decode(String str){
		try{
			str = URLDecoder.decode(str, "UTF-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("http://www.aljazeera.net/news/arabic/2016/11/21/اشتباكات-بحلب-والنظام-يواصل-قصف-الأحياء-السكنية");
		System.out.println(new Gson().toJson(StringUtils.urlEncodeLastUrl(l)));
	}
	 
}
