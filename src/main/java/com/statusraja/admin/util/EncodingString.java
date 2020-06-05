package com.statusraja.admin.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingString {

	public static void main(String[] args) {
		String encoded=new BCryptPasswordEncoder().encode("12345");
		System.out.println(encoded);
	}

}
