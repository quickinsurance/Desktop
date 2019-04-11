package services.impl;

import java.util.Date;
import java.util.Properties;


import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

import entities.Messagerie;
import entities.User;
public class EmailMessages {

	User sender;
	User receiver;
	Messagerie m;
	public EmailMessages(User sender,User receiver,Messagerie m)
	{
		try{
		String host ="smtp.gmail.com" ;
        String user = sender.getEmail();
        String pass = "dghdghdgh";
        String to = receiver.getEmail();
        String from = sender.getEmail();
        String subject =m.getSubject() ;
        String messageText = m.getContenu();
        boolean sessionDebug = false;

        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.required", "true");

        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(from));
        InternetAddress[] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject); msg.setSentDate(new Date());
        msg.setText(messageText);

       Transport transport=mailSession.getTransport("smtp");
       transport.connect(host, user, pass);
       transport.sendMessage(msg, msg.getAllRecipients());
       transport.close();
       System.out.println("message send successfully");
	 }catch(Exception ex)
     {
         System.out.println(ex);
     }
	}
}
