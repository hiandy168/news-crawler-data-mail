package com.onemt.news.crawler.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
* @ClassName: HttpDownloadUtils
* @Description: http下载网络文件工具类
* @author lennon dai
* @date 2016-5-4 下午12:01:11
*
 */
public class HttpDownloadUtils {
	
	private static Logger logger = LoggerFactory.getLogger(HttpDownloadUtils.class);

	public static String downLoadFromUrl(String urlStr,String saveFileName,String savePath,String extension){
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        //文件保存位置
		File saveDir = new File(savePath);
		if(!saveDir.exists()){
			saveDir.mkdir();
		}
		
        try{
            urlfile = new URL(clearUrl(urlStr));
            //java在访问https资源时，忽略证书信任问题,需要在创建connection之前调用两个方法
            if(urlStr.contains("https:")){   //如果图片是https协议打头的话
            	trustAllHttpsCertificates();
            	HttpsURLConnection.setDefaultHostnameVerifier(hv);   //设置默认的主机证书
            }
            httpUrl = (HttpURLConnection)urlfile.openConnection();
            //设置忽略所有的证书验证，方便下载相应的图片
            httpUrl.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
            httpUrl.connect();
            String webExtension = ExtensionUtil.getExt(httpUrl.getContentType());
            if(!StringUtils.isBlank(webExtension)){
            	extension = webExtension;
            }
            File f = new File(saveDir+ File.separator+saveFileName+extension);
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 1024*10;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1){
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
            return f.getName();
        }catch (Exception e){
        	logger.error("Download file failed!",e);
        }finally{
            try{
            	if(null!=bis){
            		bis.close();
            	}
            	if(null!=bos){
            		bos.close();
            	}
            }catch (IOException e){
            	logger.error("Download file failed!",e);
            }
        }
        logger.info("Download file success:"+urlStr); 
        return "";
    }
	
	public static String clearUrl(String urlStr){
		try {
			urlStr = NewsURLEncoder.encode(urlStr, "UTF-8");
			
			if(urlStr.indexOf("%")<0){
				URL url=new URL(urlStr);
				String query = url.getQuery();
				if(StringUtils.isNotBlank(query)){
					//减一去掉问号
					urlStr= urlStr.substring(0, urlStr.indexOf(query)-1);
				}
				urlStr = NewsURLEncoder.encode(urlStr, "UTF-8")+(StringUtils.isNotBlank(query)?"?"+query:"");
			}
		} catch (Exception e) {
			logger.error("Clear url failed!",e);
		}
		
		
		return urlStr;
	}
	
	
	/**
	 * 主机是否开启证书验证
	 */
	static HostnameVerifier hv = new HostnameVerifier() {
        public boolean verify(String urlHostName, SSLSession session) {
            System.out.println("Warning: URL Host: " + urlHostName + " vs. "
                               + session.getPeerHost());
            return true;
        }
    };
	
    /**
     * 开启信任所有的证书
     * @throws Exception
     */
	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
				.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
				.getSocketFactory());
	}

	static class miTM implements javax.net.ssl.TrustManager,
			javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}	
}
