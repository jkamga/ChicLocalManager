package com.journaldev.spring.dam;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONException;

import com.journaldev.spring.model.User;

public interface IUserDataAccess {
	
	/*
	 * 
	 */
	ArrayList<User> getUserList() throws JSONException;
	
	void addUser(String user);
	
	User getUserById(String id) throws JSONException;

	User addUser(User user);

	User getUserById(String email, String password);

}
