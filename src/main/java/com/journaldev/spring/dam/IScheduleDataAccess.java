package com.journaldev.spring.dam;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.journaldev.spring.model.Schedule;

public interface IScheduleDataAccess {
	
	/**
	 * 
	 * @return
	 * @throws JSONException 
	 */
	List<Schedule> getSchedule() throws JSONException ;
	
	/**
	 * 
	 * @param uuid
	 * @return
	 */
	String getScheduleById(String uuid);
	
	/**
	 * 
	 * @return
	 */
	JSONArray getScheduleList();
	
	/**
	 * 
	 * @return
	 */
	boolean deleteScheduleById(String uuid);
	
	/**
	 * 
	 * @param Schedule
	 * @return
	 * @throws JSONException 
	 */
	boolean addSchedule(Schedule Schedule) throws JSONException;
	
	/**
	 * 
	 * @param uuid
	 * @return
	 */
	boolean updateScheduleById(String uuid);
}
