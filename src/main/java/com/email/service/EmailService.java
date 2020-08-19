package com.email.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendOtpMessage(String to, String subject, String message) {
		try {

			String body = "";
			body = "Your One-Time Password request\r\n" + "\r\n" + "Dear Client,\r\n" + "\r\n"
					+ "Your One-Time Password (OTP) is " + message + " \r\n" + "\r\n" + "This OTP is requested on "
					+ new Date(System.currentTimeMillis())
					+ "  IST and it is valid till " + new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5)) + " IST.";
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);

			logger.info(subject);
			logger.info(to);
			logger.info(message);

			javaMailSender.send(simpleMailMessage);
			logger.info("Email sent success to email id  "+to);

			
		} catch (Exception ex) {
			logger.info("Some error occured while sending an email "+ ex);
		}
	}
}
