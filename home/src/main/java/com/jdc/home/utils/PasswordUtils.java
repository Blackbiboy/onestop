package com.jdc.home.utils;

import java.security.MessageDigest;
import java.util.Base64;

public class PasswordUtils {

	public static String encrpit(String pass) {
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte [] data = digest.digest(pass.getBytes());
			return Base64.getEncoder().encodeToString(data);
			
		} catch (Exception e) {
			throw new HomeApplicationException();
		}
		
	}
}
