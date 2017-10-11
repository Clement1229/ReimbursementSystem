package com.revature.service;

import com.revature.dao.Dao;
import com.revature.dao.DaoImpl;

public class Service {
	Dao dao = new DaoImpl();
	public int getRtidByUsernamePassword(String username, String password) {
		return dao.getRtidByUsernamePassword(username, password);
	}
//	public String getSmile() {
//		return "I'm smiling";
//	}
}
