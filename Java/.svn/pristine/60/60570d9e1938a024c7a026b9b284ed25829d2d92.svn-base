package com.fla.cotizador.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.log4j.Logger;

import javax.activation.*;

public class SendEMail {

	public static boolean sendEMail(String host, String port, final String password, String from, String to, String subject, String texto,
			String adjunto) {
		final String username = "";
		Logger log = Util.getLogger();

		Properties prop = new Properties();

		 BodyPart messageBodyPart = new MimeBodyPart();

		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "172.16.8.130");
		prop.put("mail.smtp.port", "25");
		prop.put("mail.smtp.ssl.trust", "smtp.office365.com");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Multipart multipart = new MimeMultipart();
			messageBodyPart.setText(texto);
			MimeMessage message = new MimeMessage(session);
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(adjunto);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(adjunto);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart );

			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject(subject);


			Transport.send(message);
			log.info("Se envió correo....");
			return true;
		} catch (MessagingException mex) {
			log.error("Error: " + mex.getMessage());
		}
		return false;

	}

}
