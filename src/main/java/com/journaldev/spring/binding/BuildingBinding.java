package com.journaldev.spring.binding;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.journaldev.spring.dam.BuildingDataAccess;
import com.journaldev.spring.dam.IBuildingDataAccess;
import com.journaldev.spring.model.Batiment;

public class BuildingBinding implements IBinding<Batiment> {

	private static final Logger logger = LoggerFactory.getLogger(BuildingBinding.class);

	@Override
	public List<Batiment> bindBeanToDam() throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bindDamToBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Batiment bindDamToBean(Batiment t) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bindToDam(Batiment batiment) throws JSONException {
		Gson parser = new Gson();
		String loacalObject = parser.toJson(batiment);
		IBuildingDataAccess dambat = new BuildingDataAccess();
		return dambat.addBuilding(loacalObject);
	}

}
