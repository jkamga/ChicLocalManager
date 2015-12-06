package com.journaldev.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.binding.IBinding;
import com.journaldev.spring.binding.ScheduleBinding;
import com.journaldev.spring.binding.UserBinding;
import com.journaldev.spring.dam.ConferenceDataAccess;
import com.journaldev.spring.dam.IConferenceDataAccess;
import com.journaldev.spring.dam.ILocalDataAccess;
import com.journaldev.spring.dam.IUserDataAccess;
import com.journaldev.spring.dam.LocalDataAccess;
import com.journaldev.spring.dam.UserDataAccess;
import com.journaldev.spring.model.Admin;
import com.journaldev.spring.model.Schedule;
import com.journaldev.spring.model.User;

@Controller
public class LoginController {

	 @Autowired 
	 private HttpSession httpSession;
	
	@RequestMapping(value = "/login**", method = RequestMethod.POST)
	public ModelAndView adminPage(@ModelAttribute("adminForm") Admin admin,HttpSession sessionObj) throws JSONException {
		
		ModelAndView model = new ModelAndView();
		
		ILocalDataAccess loaclDam = new LocalDataAccess();
	    JSONArray locals = loaclDam.getLocalsList();
	    model.addObject("locals", locals.toString());
		sessionObj.setAttribute("locals", locals);
		
		IConferenceDataAccess damConf = new ConferenceDataAccess();
		JSONArray conferences = damConf.getConferenceList();
		model.addObject("conferences", conferences);
		sessionObj.setAttribute("conferences", conferences);
		
		IUserDataAccess userBind = new UserDataAccess();

		IBinding<Schedule> binderl = new ScheduleBinding();
		List<Schedule> schdle = binderl.bindBeanToDam();
		model.addObject("scheduleList", schdle);

		User user = userBind.getUserById(admin.getEmail(), admin.getPassword());
		
		sessionObj.setAttribute("admin", user);
		
		if (user != null && user.getUserid() != null) {
			model.setViewName("admin");
			model.addObject("admin", user);
		} else {
			model.setViewName("manage_schedules");
			model.addObject("admin", null);
		}

		return model;

	}

	@RequestMapping(value = "/register**", method = RequestMethod.POST)
	public ModelAndView registerPage(@ModelAttribute("userForm") User user) throws JSONException {

		IBinding<User> binder = new UserBinding();
		User userResult = binder.bindDamToBean(user);
		ModelAndView model = new ModelAndView("manage_schedules");
		IBinding<Schedule> binderl = new ScheduleBinding();
		List<Schedule> schdle = binderl.bindBeanToDam();
		model.addObject("scheduleList", schdle);
		model.addObject("admin", userResult);

		return model;

	}
}
