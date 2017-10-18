package com.revature.service;

import java.util.List;

import com.revature.dao.Dao;
import com.revature.dao.DaoImpl;
import com.revature.domain.PendingHistory;
import com.revature.domain.Reimbursement;
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
	public void submitReimbursement(User user, Reimbursement reim) {
		 dao.submitReimbursement(user, reim);
	}
	public int getRbtId(String type) {
		switch(type) {
			case "travel": return 1;
			case "business": return 2;
			case "incidential": return 3;
		}
		return 0;
	}
	public List<PendingHistory> viewPendingHistory(int ersid){
		return dao.viewPendingHistory(ersid);
	}
	
}
