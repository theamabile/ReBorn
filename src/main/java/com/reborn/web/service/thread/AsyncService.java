package com.reborn.web.service.thread;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.reborn.web.service.email.EmailUtil;
import com.reborn.web.service.email.MailClient;


@Service
public class AsyncService {
    

  	//메일
  	@Autowired
  	private MailClient mailClient;

  //비동기로 동작하는 메소드
    @Async("mailExecutor")
    public void send(String email, String subject, String title, String location, String feature, int id) {
    	//테스트
    	//mailClient.prepareAndSend("hyk1272@gmail.com", subject ,title, location, feature, id);
 		
    	//실제코드
    	mailClient.prepareAndSend(email, subject ,title, location, feature, id);
 		
    }
}
