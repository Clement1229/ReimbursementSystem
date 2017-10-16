package com.revature.dao;

import com.revature.domain.ReimbursementType;

public interface Dao {
	//public void login();
	
	public int getRtidByUsernamePassword(String username, String password);
	public void submitReimbursement(ReimbursementType type, double amount);
}
