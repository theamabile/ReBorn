package com.reborn.web.service.email;

public interface EmailUtil {
	void sendEmail(String toAddress, String subject, String body);

}
