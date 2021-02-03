package com.reborn.web.service.member;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reborn.web.service.email.EmailUtil;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class CertificationService {
	public String certifiedPhoneNumber(String phone, String page) {
		System.out.println("test" + phone);
		String api_key = "NCSRBJ3JWHVFMGNJ";
		String api_secret = "CA4YBO3JEJPJ4AYR8VPVW8PYJPG14SJS";
		Message coolsms = new Message(api_key, api_secret);

		Random rand = new Random();
		String numStr = "";
		for (int i = 0; i < 6; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}

		System.out.println("수신자 번호 : " + phone);
		System.out.println("인증번호 : " + numStr);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phone); // 수신전화번호
		params.put("from", "01049339287"); // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
		params.put("type", "SMS");
		params.put("text", "[" + numStr + "]" + "   ReBorn의 " + page + " 인증번호 입니다. ");
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		return numStr;

	}

	@Autowired
	private EmailUtil emailUtil;

	public String certifiedEmailNumber(String email, String page) {

		Random rand = new Random();
		String numStr = "";
		for (int i = 0; i < 6; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}
		
		String title ="Reborn의 "+page+"  이메일 인증번호가 도착했습니다.";
		String text = "이메일 인증을 완료하려면 인증번호란에 ["+numStr+"] 를 입력해주세요.";
		
		emailUtil.sendEmail(email, title,text);
		return numStr;

	}
}
