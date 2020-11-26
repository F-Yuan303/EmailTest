package sourse;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.net.MalformedURLException;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;

public class integrationTest {
	private email_system email;
	
	@Before
	public void setUp() throws Exception {
		email = mock(email_system.class);
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
		//email.menu();
		when(email.sendSimpleTextEmail()).thenReturn("�����ʼ�����1");
        when(email.sendEmailsWithpicture()).thenReturn("�����ʼ�����2");
        when(email.sendEmailsWithOnlineAttachments()).thenReturn("�����ʼ�����3");
		//System.out.println(email.sendSimpleTextEmail());
		//System.out.println(email.sendEmailsWithpicture());
		//System.out.println(email.sendEmailsWithOnlineAttachments());
		email.sendSimpleTextEmail();
        verify(email, times(1)).sendSimpleTextEmail();
		email.sendSimpleTextEmail();
		verify(email, times(2)).sendSimpleTextEmail();
		String ret1 = (String)email.sendSimpleTextEmail();
        Assert.assertEquals(ret1, "�����ʼ�����1");
		
		email.sendEmailsWithpicture();
		verify(email, atLeastOnce()).sendSimpleTextEmail();
		String ret2 = (String)email.sendEmailsWithpicture();
        Assert.assertEquals(ret2, "�����ʼ�����2");
        
		
        verify(email, never()).sendEmailsWithOnlineAttachments();
        
        //verifyNoMoreInteractions(email);
        //verifyZeroInteractions(email);
	}
	

}
