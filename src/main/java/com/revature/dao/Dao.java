package com.revature.dao;

import java.util.List;

import com.revature.domain.Employee;
import com.revature.domain.PendingHistory;
import com.revature.domain.Reimbursement;
import com.revature.domain.ReimbursementType;
import com.revature.domain.ResolvedHistory;
import com.revature.domain.User;

public interface Dao {
	//public void login();
	
	public int getRtidByUsernamePassword(String username, String password);
	public User getUserByUsernamePassword(String username, String password);
	public void submitReimbursement(User user, Reimbursement reim);
	public List<PendingHistory> viewPendingHistory(int ersid);
	public List<ResolvedHistory> viewResolvedHistory(int ersid);
	public List<Employee> viewEmployeeList();
	
}
