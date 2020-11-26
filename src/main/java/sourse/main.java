package sourse;

import java.net.MalformedURLException;

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
		newemail.menu();
		//newemail.sendSimpleTextEmail();
		//newemail.sendEmailsWithpicture();
		//newemail.sendEmailsWithOnlineAttachments();
	}

}
