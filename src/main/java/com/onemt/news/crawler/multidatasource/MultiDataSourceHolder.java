package com.onemt.news.crawler.multidatasource;

/**
 * 
 * 项目名称：news-crawler-sync   
 *
 * 类描述：
 * 类名称：com.onemt.news.crawler.utils.DynamicDataSourceHolder     
 * 创建人：liqiao 
 * 创建时间：2016-12-21 下午1:00:39   
 * 修改人：
 * 修改时间：2016-12-21 下午1:00:39   
 * 修改备注：   
 * @version   V1.0
 */
public class MultiDataSourceHolder {

	/**
	 * 将数据源标识保存在线程变量中,避免其他线程访问,导致共享问题.
	 */
	private static final ThreadLocal<String> THREAD_DATA_SOURCE=new ThreadLocal<>();

	public static String getDataSource(){
		return THREAD_DATA_SOURCE.get();
	}
	
	public static void setDataSource(String dataSource){
		THREAD_DATA_SOURCE.set(dataSource);
	}
	
	public static void clearDataSource(){
		THREAD_DATA_SOURCE.remove();
	}
}
