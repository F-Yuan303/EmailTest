package sourse;

import java.net.MalformedURLException;
import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class main {

	public static void main(String[] args) throws EmailException, MalformedURLException {
		// TODO Auto-generated method stub
		
		email_system newemail = new email_system();
		newemail.setown_account("1261661322");
		newemail.setobject_account("1261661322");
		newemail.setcode("lmganceuizazgcga");
		System.out.println("Welcome to online email!");
		System.out.println("1.发送简单邮件");
		System.out.println("2.发送含本地资源文件");
		System.out.println("3.发送含网络资源文件");
		System.out.print("请选择功能：");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		newemail.menu(option);
		//newemail.sendSimpleTextEmail();
		//newemail.sendEmailsWithpicture();
		//newemail.sendEmailsWithOnlineAttachments();
	}

}
