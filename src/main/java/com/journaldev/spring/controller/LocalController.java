package com.journaldev.spring.controller;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.binding.BuildingBinding;
import com.journaldev.spring.binding.IBinding;
import com.journaldev.spring.binding.LocalBinding;
import com.journaldev.spring.binding.ScheduleBinding;
import com.journaldev.spring.dam.ILocalDataAccess;
import com.journaldev.spring.dam.LocalDataAccess;
import com.journaldev.spring.model.Batiment;
import com.journaldev.spring.model.Salle;
import com.journaldev.spring.model.Schedule;

@Controller
public class LocalController {

	@RequestMapping(value = "/createBuilding**", method = RequestMethod.POST)
	public ModelAndView adminPageAddBuilding(@ModelAttribute("batimentForm") Batiment local) throws Exception {

		ModelAndView model = new ModelAndView();
		
		IBinding<Schedule> binderl = new ScheduleBinding();
		List<Schedule> schdle = binderl.bindBeanToDam();
		model.addObject("scheduleList", schdle);
		model.setViewName("admin");
		
		IBinding<Batiment> binder = new BuildingBinding();
		boolean result = binder.bindToDam(local);
		if(!result){
			model.addObject("Error", "Failled, Please Retry!");
		}else{
			model.addObject("Success", "Building Added!");	
		}
		
		return model;

	}
	
	@RequestMapping(value = "/createLocal**", method = RequestMethod.POST)
	public ModelAndView adminPage(@ModelAttribute("localForm") Salle local) throws Exception {

		ModelAndView model = new ModelAndView();
		IBinding<Schedule> binderl = new ScheduleBinding();
		List<Schedule> schdle = binderl.bindBeanToDam();
		model.addObject("scheduleList", schdle);
		IBinding<Salle> binder = new LocalBinding();
		model.setViewName("admin");
		
		boolean result = binder.bindToDam(local);
		if(!result){
			model.addObject("Error", "Failled, Please Retry!");
		}else{
			model.addObject("Success", "Local Added!");	
		}
		
		return model;

	}
	
	@RequestMapping(value = "/getLocals**", method = RequestMethod.GET)
	public ModelAndView getLocals() throws JSONException {
		ModelAndView model = new ModelAndView();
		IBinding<Schedule> binderl = new ScheduleBinding();
		List<Schedule> schdle = binderl.bindBeanToDam();
		model.addObject("scheduleList", schdle);
		model.setViewName("admin");
	    ILocalDataAccess damSalle = new LocalDataAccess();
	    model.addObject("locals", damSalle.getLocalsList());
	    
		return model;
	}
	
	@RequestMapping(value = "/updateLocal**", method = RequestMethod.POST)
	public ModelAndView adminUpdateLocalPage(@ModelAttribute("localForm") Salle local) throws Exception {
 
		ILocalDataAccess localAcces = new LocalDataAccess();
		
		boolean result = localAcces.updateLocal(local);
		
		ModelAndView model = new ModelAndView();
		IBinding<Schedule> binderl = new ScheduleBinding();
		List<Schedule> schdle = binderl.bindBeanToDam();
		model.addObject("scheduleList", schdle);
		
		model.setViewName("admin");	
		
		if(!result){
			model.addObject("Error", "Failled, Please Retry!");
		}else{
			model.addObject("Success", "Local Updated!");	
		}
		
		return model;

	}
}
