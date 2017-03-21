package com.onemt.news.crawler.multidatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 
 * 项目名称：news-crawler-sync   
 *
 * 类描述：
 * 类名称：com.onemt.news.crawler.utils.DynamicDataSource     
 * 创建人：liqiao 
 * 创建时间：2016-12-21 下午1:06:01   
 * 修改人：
 * 修改时间：2016-12-21 下午1:06:01   
 * 修改备注：   
 * @version   V1.0
 */
public class MultiDataSource extends AbstractRoutingDataSource {

	/**
	 * 重写此方法 获取动态数据源标识
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return MultiDataSourceHolder.getDataSource();
	}

}
