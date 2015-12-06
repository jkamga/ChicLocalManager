package com.journaldev.spring.dam;

import java.util.ArrayList;
import java.util.List;

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

import com.google.gson.Gson;
import com.journaldev.spring.enums.RestURLManager;
import com.journaldev.spring.manager.EntityManager;
import com.journaldev.spring.manager.IEntityManager;
import com.journaldev.spring.model.Presentation;
import com.journaldev.spring.model.Local;
import com.journaldev.spring.model.Schedule;

public class ScheduleDataAccess implements IScheduleDataAccess {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleDataAccess.class);

	@Autowired
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	IEntityManager<Schedule> localManager = new EntityManager();

	public ScheduleDataAccess(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public ScheduleDataAccess() {
		super();
	}

	public List<Schedule> getSchedule() throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(RestURLManager.GET_SCHEDULE_LIST_URL.getURLValue(), String.class);
		JSONObject schedule = new JSONObject(result);
		JSONArray array = schedule.getJSONArray("horaire");

		return jsonArrayScheduleToArrayList(array);
	}

	/**
	 * @param array
	 * @param list
	 * @throws JSONException
	 */
	private List<Schedule> jsonArrayScheduleToArrayList(JSONArray array) throws JSONException {
		List<Schedule> list = new ArrayList<Schedule>();
		for (int i = 0; i < array.length(); i++) {
			Schedule hor = new Schedule();
			// schedule
			hor.setUuid(array.getJSONObject(i).getString("_id"));
			hor.setDate(array.getJSONObject(i).getString("date"));
			hor.setHeureDebut(array.getJSONObject(i).getString("heureDebut"));
		
			// local
			Local local = new Local();
			JSONArray salle = array.getJSONObject(i).getJSONArray("idSalle");
			local.setUuid(salle.getJSONObject(0).getString("_id"));
			local.setCapacity(salle.getJSONObject(0).getString("capacite"));
			local.setMaterials(salle.getJSONObject(0).getString("equipement"));
			local.setDescription(salle.getJSONObject(0).getString("description"));
			local.setFloor(salle.getJSONObject(0).getString("etage"));
			local.setBuildingId(salle.getJSONObject(0).getString("idBatiment"));
			local.setLocalId(salle.getJSONObject(0).getString("numero"));
			local.setStatus(salle.getJSONObject(0).getString("statut"));
			hor.setLocal(local);

			// conference
			JSONArray confs = array.getJSONObject(1).getJSONArray("idPresentation");
			Presentation conf = new Presentation();
			conf.setUuid(confs.getJSONObject(0).getString("_id"));
			conf.setDureeHeure(confs.getJSONObject(0).getString("dureeHeure"));
			conf.setDureeMinute(confs.getJSONObject(0).getString("dureeMinute"));
			conf.setTitre(confs.getJSONObject(0).getString("titre"));
			conf.setNombreParticipants(confs.getJSONObject(0).getString("nombreParticipants"));
			conf.setPresentateur(confs.getJSONObject(0).getString("presentateur"));
			conf.setEquipement(confs.getJSONObject(0).getString("equipement"));
			hor.setConference(conf);

			list.add(hor);

		}
		return list;
	}

	public String getScheduleById(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONArray getScheduleList() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteScheduleById(String uuid) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addSchedule(Schedule Schedule)throws JSONException {
		
		Gson parser = new Gson();
		String sched = parser.toJson(Schedule);
		JSONObject sch = new JSONObject(sched);
		
		if(sch != null){
			sch.remove("conference");
			sch.remove("local");	
		}
		
		
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

			HttpEntity<String> entity = new HttpEntity<String>("{ \"horaire\" : ["+sch.toString()+"]}", headers);
			ansswer = restTemplate.postForObject(RestURLManager.ADD_SCHEDULE.getURLValue(), entity, String.class);
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

	public boolean updateScheduleById(String uuid) {
		// TODO Auto-generated method stub
		return false;
	}

}
