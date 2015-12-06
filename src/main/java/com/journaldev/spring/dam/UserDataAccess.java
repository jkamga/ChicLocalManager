package com.journaldev.spring.dam;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.journaldev.spring.enums.RestURLManager;
import com.journaldev.spring.model.User;

public class UserDataAccess implements IUserDataAccess {

	@Autowired
	RestTemplate restTemplate = new RestTemplate();

	private static final Logger logger = LoggerFactory.getLogger(UserDataAccess.class);

	public UserDataAccess() {
		super();
	}

	public UserDataAccess(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public ArrayList<User> getUserList() throws JSONException {

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(RestURLManager.GET_USER_LIST_URL.getURLValue(), String.class);

		return null;
	}

	@Override
	public User addUser(User user) {

		String ansswer = null;
		/**
		 *
		 * Doing the REST call and then displaying the data/user object
		 *
		 */
		try {
			/*
			 * This is code to post and return a user object
			 */
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String>(user.toString(), headers);
			ansswer = restTemplate.postForObject(RestURLManager.POST_USER_URL.getURLValue(), entity, String.class);
			if (ansswer != null) {
				user.setUserid(user.getEmail());
			}
		} catch (HttpClientErrorException e) {
			/**
			 *
			 * If we get a HTTP Exception display the error message
			 */
			logger.error("error:  " + e.getResponseBodyAsString());

			logger.error("error:  " + e.getMessage());
		} catch (Exception e) {
			logger.error("error:  " + e.getMessage());
		}

		return user;
	}

	@Override
	public User getUserById(String id) throws JSONException {
		String ansswer = null;
		User user = null;
		/**
		 *
		 * Doing the REST call and then displaying the data/user object
		 *
		 */
		try {
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			ansswer = restTemplate.getForObject(RestURLManager.GET_USERBY_ID_URL.getURLValue() + id, String.class);
			if (ansswer != null) {
				user = new User();
			}
		} catch (HttpClientErrorException e) {
			/**
			 *
			 * If we get a HTTP Exception display the error message
			 */
			logger.error("error:  " + e.getResponseBodyAsString());

			logger.error("error:  " + e.getMessage());
		} catch (Exception e) {
			logger.error("error:  " + e.getMessage());
		}

		return user;

	}

	@Override
	public void addUser(String user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserById(String email, String password) {
		String ansswer = null;
		User user = null;
		/**
		 *
		 * Doing the REST call and then displaying the data/user object
		 *
		 */
		try {
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			ansswer = restTemplate.getForObject(RestURLManager.GET_USERBY_ID_URL.getURLValue() + email + "/" + password,
					String.class);
			JSONObject userResult = new JSONObject(ansswer);
			JSONArray array = userResult.getJSONArray("user");

			if (ansswer != null && array != null) {
				user = new User();
				user.setEmail(array.getJSONObject(0).getString("email"));
				user.setFirstName(array.getJSONObject(0).getString("firstName"));
				user.setLastName(array.getJSONObject(0).getString("lastName"));
				user.setUserRole(array.getJSONObject(0).getString("userRole"));
				user.setUserid(array.getJSONObject(0).getString("userid"));
				user.setPassword(array.getJSONObject(0).getString("password"));
			}
		} catch (HttpClientErrorException e) {
			/**
			 *
			 * If we get a HTTP Exception display the error message
			 */
			logger.error("error:  " + e.getResponseBodyAsString());

			logger.error("error:  " + e.getMessage());
		} catch (Exception e) {
			logger.error("error:  " + e.getMessage());
		}

		return user;

	}

}
