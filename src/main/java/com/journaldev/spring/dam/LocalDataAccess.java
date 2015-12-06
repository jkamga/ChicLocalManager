package com.journaldev.spring.dam;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.journaldev.spring.enums.RestURLManager;
import com.journaldev.spring.model.Salle;

public class LocalDataAccess implements ILocalDataAccess {

	private static final Logger logger = LoggerFactory.getLogger(LocalDataAccess.class);

	@Override
	public boolean addLocal(String local) {
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

			HttpEntity<String> entity = new HttpEntity<String>("{ \"salle\" : ["+local+"]}", headers);
			ansswer = restTemplate.postForObject(RestURLManager.ADD_LOCAL.getURLValue(), entity, String.class);
			if (ansswer != null) {
				return true;
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

		return false;
	}
	
	@Override
	public JSONArray getLocalsList() throws JSONException{
		
		 RestTemplate restTemplate = new RestTemplate();
		 String result = restTemplate.getForObject(RestURLManager.GET_LOCAL_LIST.getURLValue(), String.class);
		 JSONObject schedule = new JSONObject(result);
		 JSONArray array = schedule.getJSONArray("salle");
		
		 return array;
	
	}

	@Override
	public boolean updateLocal(Salle loacalObject) {
		Gson parser = new Gson();
		String local = parser.toJson(loacalObject);
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

			HttpEntity<String> entity = new HttpEntity<String>("{ \"salle\" : ["+local+"]}", headers);
			ansswer = restTemplate.postForObject(RestURLManager.UPDATE_LOCAL.getURLValue(), entity, String.class);
			if (ansswer != null) {
				return true;
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

		return false;
	}

}
