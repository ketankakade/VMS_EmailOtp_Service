package com.email.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.dto.OtpDTO;
import com.email.service.EmailService;
import com.email.service.OtpService;


@RestController
@RequestMapping("/otp")
public class OtpController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public OtpService otpService;
	
	@Autowired
	public EmailService myEmailService;

	@PostMapping("/generateotp")
	public OtpDTO generateOtp(@RequestBody OtpDTO otpDto){
				
		Integer otp = otpService.generateOTP();			
		 
//		otpDto.setOtpGeneratedTimestamp(OtpGeneratedTimestamp); todo current fetch timestamp
		otpDto.setOTPNumber(otp);
		otpDto.setEmail(otpDto.getEmail());
		 
		logger.info("OTP : "+otp);
		
		myEmailService.sendOtpMessage(otpDto.getEmail(), "OTP - SpringBoot", String.valueOf(otp));		
		return otpDto;
	}
	
	
}
