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

import com.journaldev.spring.enums.RestURLManager;

public class ConferenceDataAccess implements IConferenceDataAccess {
	
	private static final Logger logger = LoggerFactory.getLogger(BuildingDataAccess.class);

	@Override
	public boolean addConfenece(String presentation) {
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

			HttpEntity<String> entity = new HttpEntity<String>("{ \"presentation\" : ["+presentation+"]}", headers);
			ansswer = restTemplate.postForObject(RestURLManager.ADD_PRESENTATION.getURLValue(), entity, String.class);
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
	public JSONArray getConferenceList() throws JSONException {
		 RestTemplate restTemplate = new RestTemplate();
		 String result = restTemplate.getForObject(RestURLManager.GET_PRESENTATION_LIST.getURLValue(), String.class);
		 JSONObject schedule = new JSONObject(result);
		 JSONArray array = schedule.getJSONArray("presentation");
		
		 return array;
	}

}
