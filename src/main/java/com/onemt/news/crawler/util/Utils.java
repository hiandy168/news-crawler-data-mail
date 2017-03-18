package com.onemt.news.crawler.util;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工具类，提供一些较为通用的方法
 *
 */
public class Utils {
	private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    /**
     * 私有化构造函数，不允许实例化该类
     */
    private Utils() {
    }
    
    /**
     * 产生随机UUID,不带"-"
     * @return
     */
    public static String randomUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
    

    /**
     * 根据Key取得Map中的值，如果不存在或者为null，则返回默认值
     *
     * @param data
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getMapStringValue(Map<?, ?> data, String key, String defaultValue) {
        Object obj = getMapValue(data, key);
        return obj == null ? defaultValue : obj.toString();
    }

    /**
     * 根据Key取得Map中的Int值，如果不存在或者转换出错，则返回默认值
     *
     * @param data
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getMapIntValue(Map<?, ?> data, String key, int defaultValue) {
        Object obj = getMapValue(data, key);
        int result = defaultValue;
        if (obj != null) {
            if (obj instanceof Integer) {
                result = (Integer) obj;
            } else if (obj instanceof String) {
                try {
                    result = Integer.parseInt((String) obj);
                } catch (Exception ex) {
                	LOG.info("parse integer happen error!");
                }
            }
        }
        return result;
    }

    /**
     * 根据Key取得Map中的Long值，如果不存在或者转换出错，则返回默认值
     *
     * @param data
     * @param key
     * @param defaultValue
     * @return
     */
    public static long getMapLongValue(Map<?, ?> data, String key, long defaultValue) {
        Object obj = getMapValue(data, key);
        long result = defaultValue;
        if (obj != null) {
            if (obj instanceof Long) {
                result = (Long) obj;
            } else if (obj instanceof String) {
                try {
                    result = Long.parseLong((String) obj);
                } catch (Exception ex) {
                    LOG.info("parse long happen error!");
                }
            }
        }
        return result;
    }

    /**
     * 根据Key取得Map中的值，如果不存在则返回null
     *
     * @param data
     * @param key
     * @return
     */
    public static Object getMapValue(Map<?, ?> data, Object key) {
        if (data != null) {
            return data.get(key);
        }
        return null;
    }

    /**
     * 根据Key取得Map中的值，如果不存在或者为null，则返回默认值
     *
     * @param data
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object getMapValue(Map<?, ?> data, Object key, Object defaultValue) {
        Object ret = defaultValue;
        if (data != null) {
            ret = data.get(key);
            ret = ret == null ? defaultValue : ret;
        }
        return ret;
    }


    /**
     * 把字符转换成Boolean，
     * <p/>
     * 当为true/yes/ok/1字符串时，返回true,否则返回false，不区分大小写
     *
     * @param s
     * @return
     */
    public static boolean toBoolean(String s) {
        if (s == null || s.length() == 0) return false;
        return s.compareToIgnoreCase("TRUE") == 0 || s.compareToIgnoreCase("YES") == 0
                || s.compareToIgnoreCase("OK") == 0 || s.compareToIgnoreCase("1") == 0;
    }

    /**
     * 把字符串转换成Integer类型，如果转换出错，则抛出异常
     * <p/>
     * 字符串为数字开头，会直接取得从0索引开始的数字进行转换，
     * 如100a，则返回100，100.9返回100
     *
     * @param s
     * @return
     */
    public static int toInt(String s) throws ParseException {
        DecimalFormat df = new DecimalFormat();
        return df.parse(s).intValue();
    }

    /**
     * 把字符串转换成Integer类型，如果转换出错，则返回0
     * <p/>
     * 字符串为数字开头，会直接取得从0索引开始的数字进行转换，
     * 如100a，则返回100，100.9返回100
     *
     * @param s
     * @return
     */
    public static int toInt(String s, int defaultValue) {
        if (s == null || s.length() == 0) {
            return defaultValue;
        }
        try {
            return toInt(s);
        } catch (ParseException e) {
            return defaultValue;
        }
    }

    /**
     * 把字符串转换成Long类型，如果转换出错，则抛出异常
     * <p/>
     * 字符串为数字开头，会直接取得从0索引开始的数字进行转换，
     * 如100a，则返回100，100.9返回100
     *
     * @param s
     * @return
     */
    public static long toLong(String s) throws ParseException {
        DecimalFormat df = new DecimalFormat();
        return df.parse(s).longValue();
    }

    /**
     * 把字符串转换成Long类型，如果转换出错，则返回0
     * <p/>
     * 字符串为数字开头，会直接取得从0索引开始的数字进行转换，
     * 如100a，则返回100，100.9返回100
     *
     * @param s
     * @return
     */
    public static long toLong(String s, long defaultValue) {
        if (s == null || s.length() == 0) {
            return defaultValue;
        }
        try {
            return toLong(s);
        } catch (ParseException e) {
            return defaultValue;
        }
    }

    /**
     * 根据对象生成Long类型
     * <p/>
     *
     * @param obj 对象
     * @return
     */
    public static long generateLong(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        } else if (obj instanceof Long) {
            return (Long) obj;
        } else if (obj instanceof Date) {
            return ((Date) obj).getTime();
        } else {
            return obj.toString().hashCode();
        }
    }

    /**
     * 把字符串转换成Float型，如果转换出错，则抛出异常
     * <p/>
     * 该Float的精度大概在0.00001左右，转换时请慎重使用
     *
     * @param s
     * @return
     * @deprecated Use #toDouble
     */
    public static float toFloat(String s) {
        BigDecimal dec = new BigDecimal(s);
        return dec.floatValue();
    }

    /**
     * 把字符串转换成Float型，如果转换出错，则返回0
     * <p/>
     * 该Float的精度大概在0.00001左右，转换时请慎重使用
     *
     * @param s
     * @return
     * @deprecated Use #toDouble
     */
    public static float toFloat(String s, float defaultValue) {
        if (s == null || s.length() == 0) {
            return defaultValue;
        }
        try {
            return toFloat(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 把字符串转换成Double类型，如果转换出错，则抛出异常
     * <p/>
     * 字符串为数字开头，会直接取得从0索引开始的数字进行转换，
     * 如100a，则返回100，100.9返回100
     *
     * @param s
     * @return
     */
    public static double toDouble(String s) {
        BigDecimal dec = new BigDecimal(s);
        return dec.doubleValue();
    }

    /**
     * 把字符串转换成Double类型，如果转换出错，则返回0
     * <p/>
     * 字符串为数字开头，会直接取得从0索引开始的数字进行转换，
     * 如100a，则返回100，100.9返回100
     *
     * @param s
     * @return
     */
    public static double toDouble(String s, double defaultValue) {
        if (s == null || s.length() == 0) {
            return defaultValue;
        }
        try {
            return toDouble(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * @Description 包含阿语的url转换为urlcode
     * @param urls
     * @return 转换后的列表集合
     * @exception Exception
     * <p/>
     * 阿语在链接最后时可调用，如：http://atyabtabkha.3a2ilati.com/خلية-النحل-من-ألذ-ما-جربت-1321
     * 转换后为：http://atyabtabkha.3a2ilati.com/cookbook/%D8%AE%D9%84%D9%8A%D8%A9-%D8%A7%D9%84%D9%86%D8%AD%D9%84-%D9%85%D9%86-%D8%A3%D9%84%D8%B0-%D9%85%D8%A7-%D8%AC%D8%B1%D8%A8%D8%AA-1321
     * */
    public static List<String> urlEncode(List<String> urls) throws Exception{
        List<String> targetUrls = new ArrayList<>();
        for(String url:urls){
            String temp[] = url.split("/");
            String arStr = temp[temp.length-1];
            String myStr = URLEncoder.encode(arStr,"utf-8");
            targetUrls.add(url.replace(arStr,"")+myStr);
        }
        return targetUrls;
    }
}

