package com.onemt.news.crawler.multidatasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
/**
 * 
 * 项目名称：news-crawler-sync   
 *
 * 类描述：切面方式在方法线程中注入数据源
 * 类名称：com.onemt.news.crawler.utils.DataSourceAspect     
 * 创建人：liqiao 
 * 创建时间：2016-12-21 下午1:18:57   
 * 修改人：
 * 修改时间：2016-12-21 下午1:18:57   
 * 修改备注：   
 * @version   V1.0
 */
public class DataSourceAspect {

	private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

	/**
     * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
     * 注解优先级:
     * 	1.方法>类
     * 	2.实现类的方法>接口方法,实现类>接口
     * 
     * 
     * @param point
     * @throws Exception
     */
    public void intercept(JoinPoint point) throws Exception {
    	//调用方法对应的本类
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        //方法名称
        String methodName = signature.getMethod().getName();
        //方法参数
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        
        logger.info("===============切换数据源 start===================");
        logger.info("调用方法所属类名:{},调用方法名:{},方法参数:{}", target.getName(),methodName,parameterTypes);
        
        //实现类中的方法
        Method method = target.getMethod(methodName, parameterTypes);
        //方法级别查找注解
        DataSource methodDataSource = AnnotationUtils.findAnnotation(method, DataSource.class);
        if(methodDataSource!=null){
        	MultiDataSourceHolder.setDataSource(methodDataSource.value());
        	logger.info("方法级别 注解,数据源:{}",methodDataSource.value());
        	logger.info("===============切换数据源 end===================");
        	return;
        }
        
        //类级别查找注解
        DataSource classdataSource = AnnotationUtils.findAnnotation(target, DataSource.class);
        if(classdataSource!=null){
        	MultiDataSourceHolder.setDataSource(classdataSource.value());
        	logger.info("类级别注解 ,数据源:{}",classdataSource.value());
        	logger.info("===============切换数据源 end===================");
        	return;
        }
        
        
     /*   //类方法级别 注解处理
        Method method = target.getMethod(methodName, parameterTypes);
        if(method!=null&&method.isAnnotationPresent(DataSource.class)){
        	DataSource dataSource = method.getAnnotation(DataSource.class);
        	MultiDataSourceHolder.setDataSource(dataSource.value());
        	logger.info("类方法级别 ,数据源:{}",dataSource.value());
        	logger.info("===============切换数据源 end===================");
        	return;
        }
        
        //类方法级别没有注解,则查找类级别注解
        if(target.isAnnotationPresent(DataSource.class)){
        	DataSource dataSource = target.getAnnotation(DataSource.class);
        	MultiDataSourceHolder.setDataSource(dataSource.value());
        	logger.info("类级别注解 ,数据源:{}",dataSource.value());
        	logger.info("===============切换数据源 end===================");
        	return;
        }
      
        //类级别没有,则查找接口级别方法注解
        Class<?>[] interfaces = target.getInterfaces();
        for (Class<?> clazz : interfaces) {
        	Method interfaceMethod = clazz.getMethod(methodName, parameterTypes);
        	if(interfaceMethod!=null&&interfaceMethod.isAnnotationPresent(DataSource.class)){
        		DataSource dataSource = interfaceMethod.getAnnotation(DataSource.class);
        		MultiDataSourceHolder.setDataSource(dataSource.value());
        		logger.info("接口级别方法注解 ,数据源:{}",dataSource.value());
            	logger.info("===============切换数据源 end===================");
        		return;
        	}
		}
        
        //接口方法没有注解,则查找接口注解
        for (Class<?> clazz : interfaces) {
        	Method interfaceMethod = clazz.getMethod(methodName,parameterTypes);
        	if(interfaceMethod!=null&&interfaceMethod.isAnnotationPresent(DataSource.class)){
        		DataSource dataSource = clazz.getAnnotation(DataSource.class);
        		MultiDataSourceHolder.setDataSource(dataSource.value());
        		logger.info("接口注解 ,数据源:{}",dataSource.value());
            	logger.info("===============切换数据源 end===================");
        		return;
        	}
		}*/
        
        //都不存在,则使用默认数据源
        logger.info("采用默认注解");
    	logger.info("===============切换数据源 end===================");
    }
    
}
