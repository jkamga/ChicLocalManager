package com.journaldev.spring.binding;

import java.util.List;

import org.codehaus.jettison.json.JSONException;

import com.journaldev.spring.dam.IUserDataAccess;
import com.journaldev.spring.dam.UserDataAccess;
import com.journaldev.spring.model.User;

public class UserBinding implements IBinding<User> {

	@Override
	public List<User> bindBeanToDam() throws JSONException {
		IUserDataAccess userlist = new UserDataAccess();

		return userlist.getUserList();
	}

	@Override
	public User bindDamToBean(User user) throws JSONException {
		IUserDataAccess userBind = new UserDataAccess();
		return userBind.addUser(user);
	}

	@Override
	public String bindDamToBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bindToDam(User t) throws JSONException {
		// TODO Auto-generated method stub
		return false;
	}

}
