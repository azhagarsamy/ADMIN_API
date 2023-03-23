package com.azhagar.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	private JavaMailSender mailSender;

	public boolean sendMail(String to, String subject, String body) {

		boolean sentFlag = false;

		MimeMessage minMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(minMessage);
		try {
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			mailSender.send(minMessage);
			sentFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sentFlag;

	}
}
