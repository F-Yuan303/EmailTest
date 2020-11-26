package sourse;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class email_systemTest {

	email_system email;
	
	@Before
	public void setUp() throws Exception {
		this.email = new email_system();
		this.email.setown_account("1261661322");
		this.email.setobject_account("1261661322");
		this.email.setcode("lmganceuizazgcga");
	}

	@After
	public void tearDown() throws Exception {
		this.email = null;
	}

	@Test
	public void testMenu() throws MalformedURLException, EmailException {
		this.email.menu();
	}

	@Test
	public void testSendSimpleTextEmail() throws EmailException {
		this.email.sendSimpleTextEmail();
		assertEquals("This is a test mail from java application.", this.email.sendSimpleTextEmail());
	}

	@Test
	public void testSendEmailsWithpicture() throws EmailException {
		this.email.sendEmailsWithpicture();
		assertEquals("C:\\\\Users\\\\86182\\\\Desktop\\\\新建文件夹\\\\IMG_8034(20201106-170907).JPG", this.email.sendEmailsWithpicture());
	}

	@Test
	public void testSendEmailsWithOnlineAttachments() throws MalformedURLException, EmailException {
		this.email.sendEmailsWithOnlineAttachments();
		assertEquals("https://www.baidu.com/img/bd_logo1.png", this.email.sendEmailsWithOnlineAttachments());
	}

}
