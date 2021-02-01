package com.reborn.web.controller.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.reborn.web.service.email.EmailUtil;

@Component
public class EmailUtilImp implements EmailUtil{
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void sendEmail(String toAdDress, String subject, String body) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		 
	    try {
	      helper.setTo(toAdDress);
	      helper.setSubject(subject);
	      helper.setText(body);
	    } catch (MessagingException e) {
	      e.printStackTrace();
	    }
		   
		sender.send(message);
	}

}
