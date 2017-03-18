package com.onemt.news.crawler.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader {
	
	
	public static void downloadFile(String remoteFilePath, String localFilePath) {
		URL urlfile = null;
		HttpURLConnection httpUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
//		CookieStore cookieStore = new BasicCookieStore();
//            BasicClientCookie cookie = new BasicClientCookie("__cfduid","d52955719f26c85492a544e7c1d5a3cc91479806823");
//            cookie.setDomain(".almnatiq.net");
//            cookieStore.addCookie(cookie);
		File f = new File(localFilePath);
		try {
			urlfile = new URL(remoteFilePath);
			httpUrl = (HttpURLConnection) urlfile.openConnection();
//			httpUrl.setRequestProperty("Cookie", "__cfduid=d52955719f26c85492a544e7c1d5a3cc91479806823");
			httpUrl.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(f));
			int len = 2048;
			byte[] b = new byte[len];
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			bis.close();
			httpUrl.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		FileDownloader.downloadFile("http://almnatiq.net/wp-content/uploads/2016/07/%D8%B4%D8%B9%D8%A7%D8%B1%D8%A7%D9%84%D8%B4%D8%B1%D8%B7%D8%A92-1.jpg", "d:/123.jpg");
	}
}
