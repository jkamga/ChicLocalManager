package com.journaldev.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.journaldev.spring.binding.ConferenceBinding;
import com.journaldev.spring.binding.IBinding;
import com.journaldev.spring.binding.ScheduleBinding;
import com.journaldev.spring.dam.ConferenceDataAccess;
import com.journaldev.spring.dam.IConferenceDataAccess;
import com.journaldev.spring.dam.ILocalDataAccess;
import com.journaldev.spring.dam.LocalDataAccess;
import com.journaldev.spring.model.Presentation;
import com.journaldev.spring.model.Schedule;

/**
 * Handles requests for the Schedule service.
 */
@Controller
public class ScheduleController {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);

	@RequestMapping(value = SpringURIConstants.GET_SCHEDULE, method = RequestMethod.GET)
	public ModelAndView getDummySchedule(HttpSession sessionObj)
			throws JSONException, JsonParseException, JsonMappingException, IOException {
		logger.info(SpringURIConstants.GET_SCHEDULE);
		ModelAndView mv = new ModelAndView("manage_schedules");

		ILocalDataAccess loaclDam = new LocalDataAccess();
	    JSONArray locals = loaclDam.getLocalsList();
	    mv.addObject("locals", locals.toString());
		sessionObj.setAttribute("locals", locals);
		
		IConferenceDataAccess damConf = new ConferenceDataAccess();
		JSONArray conferences = damConf.getConferenceList();
		mv.addObject("conferences", conferences);
		sessionObj.setAttribute("conferences", conferences);
		 
		IBinding binder = new ScheduleBinding();
		List<Schedule> schdle = binder.bindBeanToDam();

		sessionObj.setAttribute("scheduleList", schdle);

		mv.addObject("scheduleList", schdle);
		mv.addObject("admin", null);
		return mv;
	}

	@RequestMapping(value = SpringURIConstants.GET_SCHEDULE_BY_ID, method = RequestMethod.GET)
	public @ResponseBody Schedule getSchedule(@PathVariable("id") int empId) {
		logger.info("Start getSchedule. ID=" + empId);
		// TODO
		return null;
	}

	@RequestMapping(value = SpringURIConstants.GET_ALL_SCHEDULE, method = RequestMethod.GET)
	public @ResponseBody List<Schedule> getAllSchedules() {
		logger.info("Start getAllSchedules.");
		List<Schedule> emps = new ArrayList<Schedule>();
		// TODO
		return emps;
	}

	@RequestMapping(value = SpringURIConstants.CREATE_SCHEDULE, method = RequestMethod.POST)
	public ModelAndView createSchedule(@ModelAttribute("scheduleForm") Schedule schedule,HttpSession sessionObj) throws JSONException {
		logger.info("Start createSchedule.");
		
		ModelAndView model = new ModelAndView();
		
		
		
		
		IBinding<Schedule> binderl = new ScheduleBinding();
		List<Schedule> schdle = binderl.bindBeanToDam();
		model.addObject("scheduleList", schdle);
		model.setViewName("admin");
		
		boolean result = binderl.bindToDam(schedule);
		
		ILocalDataAccess loaclDam = new LocalDataAccess();
	    JSONArray locals = loaclDam.getLocalsList();
	    model.addObject("locals", locals.toString());
		sessionObj.setAttribute("locals", locals);
		
		IConferenceDataAccess damConf = new ConferenceDataAccess();
		JSONArray conferences = damConf.getConferenceList();
		model.addObject("conferences", conferences);
		sessionObj.setAttribute("conferences", conferences);
		
		if (!result) {
			model.addObject("Error", "Failled, Please Retry!");
		} else {
			model.addObject("Success", "Scedule Added!");
		}

		return model;
	}

	@RequestMapping(value = SpringURIConstants.DELETE_SCHEDULE_BY_ID, method = RequestMethod.PUT)
	public @ResponseBody Schedule deleteSchedule(@PathVariable("id") int empId) {
		logger.info("Start deleteSchedule.");
		// TODO
		return null;
	}

	@RequestMapping(value = SpringURIConstants.CREATE_CONFERENCE, method = RequestMethod.POST)
	public ModelAndView createConference(@ModelAttribute("conferenceForm") Presentation presentation,HttpSession sessionObj)
			throws JSONException {
		logger.info("Start conference");
		ModelAndView model = new ModelAndView();

		ILocalDataAccess loaclDam = new LocalDataAccess();
	    JSONArray locals = loaclDam.getLocalsList();
	    model.addObject("locals", locals.toString());
		sessionObj.setAttribute("locals", locals);
		
		IConferenceDataAccess damConf = new ConferenceDataAccess();
		JSONArray conferences = damConf.getConferenceList();
		model.addObject("conferences", conferences);
		sessionObj.setAttribute("conferences", conferences);
		
		IBinding<Schedule> binderl = new ScheduleBinding();
		List<Schedule> schdle = binderl.bindBeanToDam();
		model.addObject("scheduleList", schdle);
		model.setViewName("admin");

		IBinding<Presentation> binder = new ConferenceBinding();
		boolean result = binder.bindToDam(presentation);
		if (!result) {
			model.addObject("Error", "Failled, Please Retry!");
		} else {
			model.addObject("Success", "Conference Added!");
		}

		return model;
	}

}
