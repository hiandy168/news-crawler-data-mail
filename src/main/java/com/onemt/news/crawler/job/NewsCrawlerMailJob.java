package com.onemt.news.crawler.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class NewsCrawlerMailJob {

	
	@Value("${email.from_mail}")
	public String from_mail;
	
	@Value("${email.to_mail}")
	public String to_mail;
	
	@Autowired
	private RedisTemplate<String,String> jedisTemplate;
	
	private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 
	private static final String TIMESTAMPKEY="crawler_sync:crawler_article:fetch_time";
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void init(){
			Calendar c=Calendar.getInstance();
			c.setTime(new Date());
			c.add(Calendar.DATE, -1);
			String date = sdf.format(c.getTime());
		
			MimeMessage msg = mailSender.createMimeMessage();  
	        // 指定HTML编码，参数true表示为multipart  
	       
			try {
				 MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");
				 helper.setFrom(from_mail); // 发送者邮箱  
				 helper.setTo(to_mail); // 接收者邮箱  
				 //helper.setReplyTo(FROM_MAIL); // 回复邮箱  
				 //helper.setCc(CC_MAIL); // 抄送邮箱  
				 //helper.setBcc(BCC_MAIl); // 密送邮箱  
				 helper.setSentDate(new Date()); // 发送日期  
				 helper.setSubject("爬虫分类统计("+date+")");
				 StringBuilder sb=new StringBuilder();
				 sb.append("<a href='http://'>点击获取爬虫分类统计数据</a>\n")
				 .append("<a href='http://'>点击获取爬虫分类统计数据</a>\n")
				 .append("<a href='http://'>点击获取爬虫分类统计数据</a>\n");
				 helper.setText(sb.toString(), true); // 邮件内容，参数true表示是html代码  
				 //String demo = "demo.docx";  
				 //ClassPathResource resource = new ClassPathResource(demo); // 加载项目路径下资源  
				 //helper.addAttachment(MimeUtility.encodeWord(demo), resource); // 如果文件是中文名，需要转码。  
				 mailSender.send(msg); // 发送邮件  
			} catch (MessagingException e) {
				e.printStackTrace();
			}  
	        System.out.println("Successfully  send mail to the user");  
	        
	}
	
}
