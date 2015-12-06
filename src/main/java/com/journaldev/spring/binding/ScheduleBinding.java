package com.journaldev.spring.binding;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.journaldev.spring.dam.IScheduleDataAccess;
import com.journaldev.spring.dam.ScheduleDataAccess;
import com.journaldev.spring.model.Schedule;
import com.journaldev.spring.model.User;

public class ScheduleBinding implements IBinding<Schedule> {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleBinding.class);
	
	public List<Schedule> bindBeanToDam() throws JSONException{
		IScheduleDataAccess lacalAccess = new ScheduleDataAccess();
		return lacalAccess.getSchedule();
	}


	public String bindDamToBean(){
		IScheduleDataAccess lacalAccess = new ScheduleDataAccess();
		return null;
	}



	@Override
	public Schedule bindDamToBean(Schedule t) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean bindToDam(Schedule schedule) throws JSONException {
		IScheduleDataAccess damSchedule = new ScheduleDataAccess();
		return damSchedule.addSchedule(schedule);	
	}

}
