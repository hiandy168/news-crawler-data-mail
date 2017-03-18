package com.onemt.news.crawler.util;

import java.text.DecimalFormat;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 系统配置管理
 */
public final class ProjectConfig {
    /**
     * Logger对象
     */
	private static final Logger LOG = LoggerFactory.getLogger(ProjectConfig.class);
	public static final String CONFIG_PROJECT_PROPERTIES_FILE = "config/project.properties";

    /**
     * 用于处理于锁
     */
    private Object syncObject = new Object();
    /**
     * 系统的配置文件
     */
    private Properties properties;

    public static ProjectConfig Instance = new ProjectConfig();

    private ProjectConfig() {

    }

    /**
     * 载入项目的配置文件，将会覆盖system.properies
     * 如果在system.properties有配置，项目名称(project.name)，则所对应项目配置文件会被载入
     * 文件名称为project.XXXXXXX.properties,XXXXXXX为配置的项目名称
     * 默认载入project.properties
     *
     * @return
     */
    private Properties getProjectProperties() {
        Properties projectProperties = new Properties();
        try {
            projectProperties = PropertiesLoaderUtils.loadProperties(CONFIG_PROJECT_PROPERTIES_FILE);
        } catch (Exception ex) {
        	LOG.info("载入项目配置文件(" + CONFIG_PROJECT_PROPERTIES_FILE + ")失败！", ex);
        }
        return projectProperties;
    }

    /**
     * 取得配置文件
     *
     * @return
     */
    public Properties getProperties() {
        if (this.properties == null) {
            synchronized (syncObject) {
                try {
                    this.properties =this.getProjectProperties();
                } catch (Exception ex) {
                	LOG.warn("载入系统配置文件(" + CONFIG_PROJECT_PROPERTIES_FILE + ")出错！" + ex.getMessage(), ex);
                }
            }
        }
        return this.properties;
    }

    public void setProperties(Properties systemProperties) {
        this.properties = systemProperties;
    }

    public String getProperty(String key) {
        return getProperties().getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        String value = getProperties().getProperty(key);
        if (StringUtils.isEmpty(value)) {
            value = defaultValue;
        }
        return value;
    }

    public boolean getBooleanProperty(String key) {
        String value = getProperties().getProperty(key);
        return Utils.toBoolean(value);
    }

    public int getIntProperty(String key) {
        return getIntProperty(key, 0);
    }

    public int getIntProperty(String key, int defaultValue) {
        String value = getProperties().getProperty(key);
        try {
            DecimalFormat df = new DecimalFormat();
            return df.parse(value).intValue();
        } catch (Exception ex) {
            return defaultValue;
        }
    }


    /**
     * 重新初始化，清空所有缓存
     */
    public static void reset() {
        Instance = new ProjectConfig();
    }
}
