package com.baker.david.quick.computer.dao;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.baker.david.quick.computer.model.ContactDetails;

public class EMailDAO implements IEmailDAO {
	
	//These will work on Cloudbees server, and are the right way to do this, but won't work locally.
	//Local problems anyway due to firewall blocking port
	
	private static final String SMTP_HOST_NAME = System.getProperty("SENDGRID_SMTP_HOST");
    private static final String SMTP_AUTH_USER = System.getProperty("SENDGRID_USERNAME");
    private static final String SMTP_AUTH_PWD  = System.getProperty("SENDGRID_PASSWORD");

//    private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";
//    private static final String SMTP_AUTH_USER = "cloudbees_davidbaker29";
//    private static final String SMTP_AUTH_PWD  = "rfvfp2j7";
    
	@Override
	public void sendEmail(ContactDetails contactDetails) {
	
		try{
			
			System.out.println("*Host***: " + SMTP_HOST_NAME);
			System.out.println("*User***: " + SMTP_AUTH_USER);
			System.out.println("*Pwd***: " + SMTP_AUTH_PWD);
			
		    Properties props = new Properties();
		    props.put("mail.transport.protocol", "smtp");
		    props.put("mail.smtp.host", SMTP_HOST_NAME);
		    props.put("mail.smtp.port", 587);
		    props.put("mail.smtp.auth", "true");
		
		    Authenticator auth = new SMTPAuthenticator();
		    Session mailSession = Session.getInstance(props, auth);
		    // uncomment for debugging infos to stdout
		    mailSession.setDebug(true);
		    Transport transport = mailSession.getTransport();
		
		    MimeMessage message = new MimeMessage(mailSession);
		
		    message.setFrom(new InternetAddress(contactDetails.getEmail()));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("davidbaker29@gmail.com"));
			message.setSubject("Galileo Computers website - customer contact");
			message.setText("Name:" + contactDetails.getName()
				+ "\n Company: " + contactDetails.getCompany()
				+ "\n Email: " + contactDetails.getEmail()
				+ "\n Phone: " + contactDetails.getPhone()
				+ "\n Registered Supplier: " + contactDetails.isRegisteredSupplier()
				+ "\n Supplier Code: " + contactDetails.getSupplierCode()
				+ "\n Issue: " + contactDetails.getIssue());
		
		    transport.connect();
		    transport.sendMessage(message,
		        message.getRecipients(Message.RecipientType.TO));
		    transport.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
	    public PasswordAuthentication getPasswordAuthentication() {
	       String username = SMTP_AUTH_USER;
	       String password = SMTP_AUTH_PWD;
	       return new PasswordAuthentication(username, password);
	    }
	}
}
