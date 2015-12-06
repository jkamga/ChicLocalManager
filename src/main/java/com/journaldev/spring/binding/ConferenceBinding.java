package com.journaldev.spring.binding;

import java.util.List;

import org.codehaus.jettison.json.JSONException;

import com.google.gson.Gson;
import com.journaldev.spring.dam.ConferenceDataAccess;
import com.journaldev.spring.dam.IConferenceDataAccess;
import com.journaldev.spring.model.Presentation;

public class ConferenceBinding implements IBinding<Presentation> {

	@Override
	public List<Presentation> bindBeanToDam() throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bindDamToBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Presentation bindDamToBean(Presentation t) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bindToDam(Presentation t) throws JSONException {
		Gson parser = new Gson();
		String loacalObject = parser.toJson(t);
		IConferenceDataAccess damSalle = new ConferenceDataAccess();
		return damSalle.addConfenece(loacalObject);
	}

}
