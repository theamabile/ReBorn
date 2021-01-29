package com.reborn.web.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailClient {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	MailContentBuilder mailContentBuilder;
	public void prepareAndSend(String recipient, String subject, String title, String location, String feature, int id) {
		MimeMessagePreparator messagePreparator = miemMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(miemMessage);
			messageHelper.setFrom("rebornmailservice@gmail.com");
			messageHelper.setTo(recipient);
			messageHelper.setSubject(subject);
			String content = mailContentBuilder.build(title, location, feature, id);
			messageHelper.setText(content,true);
			
		};
		mailSender.send(messagePreparator);
	}
}