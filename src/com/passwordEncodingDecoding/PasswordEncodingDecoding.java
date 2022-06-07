package com.passwordEncodingDecoding;

import java.util.Base64;

public class PasswordEncodingDecoding {
	String e=null;
	String d=null;
    public String encoding(String pass)
    {
        String sample = pass; 
//        System.out.println("Sample String:\n"+ sample);

        String BasicBase64format = Base64.getEncoder().encodeToString(sample.getBytes());
		e = pass;
//        System.out.println("Encoded String:\n"+ BasicBase64format);
		return BasicBase64format;
    }
	
	public String decoding(String pass)
    {
        String encoded = pass;
//        System.out.println("Encoded String:\n"+ encoded);

        byte[] actualByte = Base64.getDecoder().decode(encoded);
 
        String actualString = new String(actualByte);
		d = actualString;
//        System.out.println("actual String:\n"+ actualString);
		return actualString;
    }
}
