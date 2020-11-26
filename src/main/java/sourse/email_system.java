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
		this.final_own_account = this.own_account + "@qq.com";              //��ȡ�����˺�
		this.final_object_account = this.object_account + "@qq.com";
		System.out.println("Welcome to online email!");
		System.out.println("1.���ͼ��ʼ�");
		System.out.println("2.���ͺ�������Դ�ļ�");
		System.out.println("3.���ͺ�������Դ�ļ�");
		System.out.print("��ѡ���ܣ�");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		if (option == 1)
			this.sendSimpleTextEmail();
		else if (option == 2)
			this.sendEmailsWithpicture();
		else if (option == 3)
			this.sendEmailsWithOnlineAttachments();
		else 
			System.out.println("��������޴˹��ܣ�");
	}
	
	public String sendSimpleTextEmail() throws EmailException {
		  this.final_own_account = this.own_account + "@qq.com";
		  this.final_object_account = this.object_account + "@qq.com";
		  String message = "This is a simple test mail from java application.";
		
	       // ���ͼ򵥵�email,������Ӹ���
	       Email email = new SimpleEmail();	 
	       // �ʼ�����������
	       email.setHostName("smtp.qq.com");
	       // �ʼ�������smtpЭ���SSL�˿�
	       email.setSmtpPort(465);
	       // �û���������Ϊ������˺ź�����
	       email.setAuthenticator(new DefaultAuthenticator(this.own_account, this.code));
	       // SSL��ȫ����
	       email.setSSLOnConnect(true);
	       // �����ַ����뷽ʽ
	       email.setCharset("UTF-8");
	       // ������
	       email.setFrom(this.final_own_account);
	       // �ռ���
	       email.addTo(this.final_object_account);
//	     email.addTo(String... emails);//���͸�����
//	     // ����
//	     email.addCc("xxx");
//	     // ����
//	     email.addBcc("xxx");
	       // �ʼ�����
	       email.setSubject("test email");
	       // �ʼ�����
	       email.setMsg(message);
	       // ����
	       email.send();
	       System.out.println("���ͳɹ���");
		return message;
	    }
	
	
	public String sendEmailsWithpicture() throws EmailException {
		  this.final_own_account = this.own_account + "@qq.com";
		  this.final_object_account = this.object_account + "@qq.com";
		  String path = "C:\\\\Users\\\\86182\\\\Desktop\\\\�½��ļ���\\\\IMG_8034(20201106-170907).JPG";
		  
	       // �����࣬������ӱ�����Դ��Ҳ����ָ����������Դ���ڷ���ʱ�Զ�����������Դ���ط���
	       EmailAttachment attachment = new EmailAttachment();
	       // ����·��
	       attachment.setPath(path);
	       // ���帽��
	       attachment.setDisposition(EmailAttachment.ATTACHMENT);
	       // ��������
	       attachment.setDescription("Picture");
	       // ��������Ϊ����ʱҪ������룩
	       attachment.setName("pic.jpg");
	       // �ı��ʼ���������Ӷ������
	       MultiPartEmail email = new MultiPartEmail();
	       email.setHostName("smtp.qq.com");
	       email.setAuthentication(this.own_account, this.code);
	       email.setFrom(this.final_own_account);
	       email.addTo(this.final_object_account);
	       email.setSubject("test message");
	       email.setMsg("Here is a test message.");
	       email.attach(attachment);
	       email.send();
	       System.out.println("���ͳɹ���");
		return path;
	    }
	
	
	
      //���Ͱ����������ʼ�������Ϊ������Դ)
     
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
	       email.setSubject("�����ʼ�");
	       email.setMsg("Here is Baidu's logo.");
	       email.attach(attachment);
	       email.send();
	       System.out.println("���ͳɹ���");
	       return url;
	    }
}
