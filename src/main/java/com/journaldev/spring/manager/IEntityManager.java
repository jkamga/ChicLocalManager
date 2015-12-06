package com.journaldev.spring.manager;

import org.codehaus.jettison.json.JSONObject;



public interface IEntityManager<T> {

	JSONObject getgetOjectFromRestService(String Url, T object);
	
}
