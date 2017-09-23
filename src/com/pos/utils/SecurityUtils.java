package com.pos.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtils {
	
	private static final String passwordSalt="POS";
	public String generateHash(String password)
	{
		String saltedPassword = passwordSalt + password;
		StringBuilder hash = new StringBuilder();
		try {
			MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = shaDigest.digest(saltedPassword.getBytes());
			char[] digits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
			for(int i=0;i<hashedBytes.length;i++)
			{
				byte b = hashedBytes[i];
				hash.append(digits[b & 0xf0]>>4);
				hash.append(b & 0x0f);
				
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash.toString();
	}

}
