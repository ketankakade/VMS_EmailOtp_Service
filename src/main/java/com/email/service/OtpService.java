package com.email.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.LoadingCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

@Service
public class OtpService {

	 private static final Integer EXPIRE_MINS = 5;
	 
	 private LoadingCache<String, Integer> otpCache;
	 
	 public OtpService(){
		 super();
		 otpCache = CacheBuilder.newBuilder().
			     expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
				      public Integer load(String key) {
				             return 0;
				       }
				   });
	 }
	 
	//This method is used to push the opt number against Key. Rewrite the OTP if it exists
	 //Using user id  as key
	 public Integer generateOTP(){
		 
		 Integer otp   =(int) (Math.random()*9000)+1000;	         
	     return otp; //returning value of otp 
	 }	 
	 
		 
	//This method is used to clear the OTP catched already
	public void clearOTP(String key){		 
		 otpCache.invalidate(key);
	 }
}
