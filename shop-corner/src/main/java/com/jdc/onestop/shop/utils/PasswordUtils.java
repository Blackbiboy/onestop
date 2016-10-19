package com.jdc.onestop.shop.utils;

import java.security.MessageDigest;
import java.util.Base64;

public class PasswordUtils {

	public static String encript(String password) {
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte [] data = digest.digest(password.getBytes());
			return Base64.getEncoder().encodeToString(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
