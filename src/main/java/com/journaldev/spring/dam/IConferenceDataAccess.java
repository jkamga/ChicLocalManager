package com.journaldev.spring.dam;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

public interface IConferenceDataAccess {

	boolean addConfenece(String p);
	
	JSONArray getConferenceList() throws JSONException;
}
