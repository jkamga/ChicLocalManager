package com.journaldev.spring.dam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.journaldev.spring.enums.RestURLManager;

public class BuildingDataAccess implements IBuildingDataAccess {

	private static final Logger logger = LoggerFactory.getLogger(BuildingDataAccess.class);

	@Override
	public boolean addBuilding(String building) {
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

			HttpEntity<String> entity = new HttpEntity<String>("{ \"batiment\" : [" + building + "]}", headers);
			ansswer = restTemplate.postForObject(RestURLManager.ADD_BUILDING.getURLValue(), entity, String.class);
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
