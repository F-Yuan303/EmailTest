package sourse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class email_system {
	private String own_account;
	private String final_own_account;
	private String code;
	private String object_account;
	private String final_object_account;
	
	public void setown_account(String own_account) {
		this.own_account = own_account;
	}
	
	public String getown_account() {
		return this.own_account;
	}
	
	public void setcode(String code) {
		this.code = code;
	}
	
	public String getcode() {
		return this.code;
	}
	
	public void setobject_account(String object_account) {
		this.object_account = object_account;
	}
	
	public String getobject_account() {
		return this.object_account;
	}
	
	
	public void menu() throws EmailException, MalformedURLException {
		this.final_own_account = this.own_account + "@qq.com";              //获取完整账号
		this.final_object_account = this.object_account + "@qq.com";
		System.out.println("Welcome to online email!");
		System.out.println("1.发送简单邮件");
		System.out.println("2.发送含本地资源文件");
		System.out.println("3.发送含网络资源文件");
		System.out.print("请选择功能：");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		if (option == 1)
			this.sendSimpleTextEmail();
		else if (option == 2)
			this.sendEmailsWithpicture();
		else if (option == 3)
			this.sendEmailsWithOnlineAttachments();
		else 
			System.out.println("输入错误！无此功能！");
	}
	
	public String sendSimpleTextEmail() throws EmailException {
		  this.final_own_account = this.own_account + "@qq.com";
		  this.final_object_account = this.object_account + "@qq.com";
		  String message = "This is a simple test mail from java application.";
		
	       // 发送简单的email,不能添加附件
	       Email email = new SimpleEmail();	 
	       // 邮件服务器域名
	       email.setHostName("smtp.qq.com");
	       // 邮件服务器smtp协议的SSL端口
	       email.setSmtpPort(465);
	       // 用户名和密码为邮箱的账号和密码
	       email.setAuthenticator(new DefaultAuthenticator(this.own_account, this.code));
	       // SSL安全连接
	       email.setSSLOnConnect(true);
	       // 设置字符编码方式
	       email.setCharset("UTF-8");
	       // 发件人
	       email.setFrom(this.final_own_account);
	       // 收件人
	       email.addTo(this.final_object_account);
//	     email.addTo(String... emails);//发送给多人
//	     // 抄送
//	     email.addCc("xxx");
//	     // 密送
//	     email.addBcc("xxx");
	       // 邮件主题
	       email.setSubject("test email");
	       // 邮件正文
	       email.setMsg(message);
	       // 发送
	       email.send();
	       System.out.println("发送成功！");
		return message;
	    }
	
	
	public String sendEmailsWithpicture() throws EmailException {
		  this.final_own_account = this.own_account + "@qq.com";
		  this.final_object_account = this.object_account + "@qq.com";
		  String path = "C:\\\\Users\\\\86182\\\\Desktop\\\\新建文件夹\\\\IMG_8034(20201106-170907).JPG";
		  
	       // 附件类，可以添加本地资源，也可以指定网络上资源，在发送时自动将网络上资源下载发送
	       EmailAttachment attachment = new EmailAttachment();
	       // 本地路径
	       attachment.setPath(path);
	       // 定义附件
	       attachment.setDisposition(EmailAttachment.ATTACHMENT);
	       // 附件描述
	       attachment.setDescription("Picture");
	       // 附件名（为中文时要处理编码）
	       attachment.setName("pic.jpg");
	       // 文本邮件，可以添加多个附件
	       MultiPartEmail email = new MultiPartEmail();
	       email.setHostName("smtp.qq.com");
	       email.setAuthentication(this.own_account, this.code);
	       email.setFrom(this.final_own_account);
	       email.addTo(this.final_object_account);
	       email.setSubject("test message");
	       email.setMsg("Here is a test message.");
	       email.attach(attachment);
	       email.send();
	       System.out.println("发送成功！");
		return path;
	    }
	
	
	
      //发送包含附件的邮件（附件为在线资源)
     
	public String sendEmailsWithOnlineAttachments() throws EmailException, MalformedURLException {
		  this.final_own_account = this.own_account + "@qq.com";
		  this.final_object_account = this.object_account + "@qq.com";
		  String url = "https://www.baidu.com/img/bd_logo1.png";
		  
	       EmailAttachment attachment = new EmailAttachment();
	       attachment.setURL(new URL(url));
	       attachment.setDisposition(EmailAttachment.ATTACHMENT);
	       attachment.setDescription("Baidu logo");
	       attachment.setName("Baidu.png");
	       MultiPartEmail email = new MultiPartEmail();
	       email.setHostName("smtp.qq.com");
	       email.setAuthentication(this.own_account, this.code);
	       email.setFrom(this.final_own_account);
	       email.addTo(this.final_object_account);
	       email.setSubject("测试邮件");
	       email.setMsg("Here is Baidu's logo.");
	       email.attach(attachment);
	       email.send();
	       System.out.println("发送成功！");
	       return url;
	    }
}
