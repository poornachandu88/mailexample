package mailexample;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
public class SendEmail {
	   
	
	
	public static void main(String[] args) {
		    
		   
		final String username ="frommail@gmail.com";//here your mail address
		final String password = "***your mail password***";//here your mail password
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");//465//587
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", username);
	    properties.put("mail.password", password);

	    Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		Session session = Session.getInstance(properties, auth);
	    		
		
	     Message message =null;	
		try {

	         message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));
	        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("tomail@gmail.com"));
	      
	        
	        message.setSubject("Please Use this system generated password When your Logintime");
	        message.setText("from vupadhi techno services");
	        message.setSentDate(new Date());
	        message.setDescription("this is kpcr");
	      
	       
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message, "text/html");
	      
			messageBodyPart.setText("this is your payslip");  
	       
	        System.out.println("Sending");

	        System.out.println(message);
	        Transport.send(message);

	        System.out.println("Done");
	       

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
		
		
	}
	
	
			
	   }