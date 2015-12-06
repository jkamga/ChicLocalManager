package com.journaldev.spring.access;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class RestLogin {
	
	final String authUser = "user";
	final String authPassword = "password";
	
	public boolean connected(){
	
		try{
			Authenticator.setDefault(
					   new Authenticator() {
					      public PasswordAuthentication getPasswordAuthentication() {
					         return new PasswordAuthentication(
					               authUser, authPassword.toCharArray());
					      }
					   }
			);
					
			System.setProperty("http.proxyUser", authUser);
			System.setProperty("http.proxyPassword", authPassword);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
	return false;
	}

}
