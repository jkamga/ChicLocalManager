package com.journaldev.spring.binding;

import java.util.List;

import org.codehaus.jettison.json.JSONException;

import com.journaldev.spring.model.Schedule;
import com.journaldev.spring.model.User;

public interface  IBinding<T>{

	 List<T>  bindBeanToDam() throws JSONException;
	 
	 String bindDamToBean();
	 
	 T bindDamToBean(T t) throws JSONException;
	 
	 boolean bindToDam(T t) throws JSONException;
}
