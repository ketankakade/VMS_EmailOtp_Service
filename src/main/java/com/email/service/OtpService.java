package com.email.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class OtpService {

	private static final Integer EXPIRE_MINS = 5;

	private LoadingCache<String, Integer> otpCache;

	public OtpService() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}

	// This method is used to push the otp number
	public Integer generateOTP() {

		Integer otp = (int) (Math.random() * 9000) + 1000;
		return otp; // returning value of otp
	}
}
