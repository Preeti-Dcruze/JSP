package com.WT;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {

	public static void sendMail(String email, String message) {

		final String username = "glenorine2000@gmail.com";
		final String password = "mariajai12072000";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop);
		session.setDebug(true);
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
		try {

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			msg.setSubject("Testing Gmail");
			msg.setText("Sir," + "\n\n" + message);
			Transport trans = session.getTransport("smtp");
			trans.connect("smtp.gmail.com", 587, username, password);
			trans.sendMessage(msg, msg.getAllRecipients());

			System.out.println("Message Sent!");
			System.out.println("Done");
		}

		catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}