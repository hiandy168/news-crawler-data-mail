package com.onemt.news.crawler.dingding;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class DingDingUtil {

	
	private final static Gson gson = new GsonBuilder().create();
	private static String webhook_token;
	
	@Value("${webhook_token}")  
	public void setWebhook_token(String webhook_token) {
		DingDingUtil.webhook_token = webhook_token;
	}

	public static void sendMessage(DingDingMessage dingDingMessage){
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(webhook_token);
		httppost.addHeader("Content-Type", "application/json; charset=utf-8");
		String textMsg = gson.toJson(dingDingMessage);
		StringEntity se = new StringEntity(textMsg, "utf-8");
		httppost.setEntity(se);
		try {
			HttpResponse response = httpclient.execute(httppost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(response.getEntity());
				System.out.println(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
