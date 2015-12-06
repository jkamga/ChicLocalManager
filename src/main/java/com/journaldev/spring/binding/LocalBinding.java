package com.journaldev.spring.binding;

import java.util.List;

import org.codehaus.jettison.json.JSONException;

import com.google.gson.Gson;
import com.journaldev.spring.dam.ILocalDataAccess;
import com.journaldev.spring.dam.LocalDataAccess;
import com.journaldev.spring.model.Salle;

public class LocalBinding implements IBinding<Salle> {

	@Override
	public List<Salle> bindBeanToDam() throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bindDamToBean() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean bindLocalToDam(Salle Salle) throws JSONException {
		Gson parser = new Gson();
		String loacalObject = parser.toJson(Salle);
		ILocalDataAccess damSalle = new LocalDataAccess();
		return damSalle.addLocal(loacalObject);
	}

	
	@Override
	public Salle bindDamToBean(Salle t) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bindToDam(Salle salle) throws JSONException {
		Gson parser = new Gson();
		String loacalObject = parser.toJson(salle);
		ILocalDataAccess damSalle = new LocalDataAccess();
		return damSalle.addLocal(loacalObject);
	}

}
