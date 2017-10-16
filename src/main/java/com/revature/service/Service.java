package com.revature.service;

import com.revature.dao.Dao;
import com.revature.dao.DaoImpl;
import com.revature.domain.User;

public class Service {
	Dao dao = new DaoImpl();
	public int getRtidByUsernamePassword(String username, String password) {
		return dao.getRtidByUsernamePassword(username, password);
	}
	public User getUserInfo() {
		return new User(); //default
	}
	public User getUserByUsernamePassword(String username, String password) {
		return dao.getUserByUsernamePassword(username, password);
	}
	
	
//	public String getSmile() {
//		return "I'm smiling";
//	}
}
