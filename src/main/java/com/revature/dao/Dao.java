package com.revature.dao;

import com.revature.domain.Reimbursement;
import com.revature.domain.ReimbursementType;
import com.revature.domain.User;

public interface Dao {
	//public void login();
	
	public int getRtidByUsernamePassword(String username, String password);
	public User getUserByUsernamePassword(String username, String password);
	public void submitReimbursement(User user, Reimbursement reim);
	
}
