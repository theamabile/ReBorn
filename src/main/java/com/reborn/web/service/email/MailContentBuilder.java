package com.reborn.web.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {
	@Autowired
	private TemplateEngine templateEngine;
	
	
	public String build(String title, String location, String feature, int id) {
		Context context = new Context();
		context.setVariable("title", title);
		context.setVariable("location", location);
		context.setVariable("feature", feature);
		context.setVariable("id", id);
		return templateEngine.process("mail-template", context);
	}
}
