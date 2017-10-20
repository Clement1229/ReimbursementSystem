package com.revature.domain;

public class ResolvedHistory {

	private String empf;
	private String empl;
	private String type;
	private double amount;
	private String decp;
	private String status;
	//private String manager;
	private String timestamp;
	
	private String mngf;
	private String mngl;

	
	
	
	public ResolvedHistory(String empf, String empl, String type, double amount,String decp, String status, String timestamp, String mngf, String mngl) {
		super();
		this.empf = empf;
		this.empl = empl;
		this.type = type;
		this.amount = amount;
		this.decp = decp;
		this.status = status;
		this.timestamp = timestamp;
		this.mngf = mngf;
		this.mngl = mngl;
	}
//	public ResolvedHistory(String type, double amount, String status, String manager, String timestamp) {
//		super();
//		this.type = type;
//		this.amount = amount;
//		this.status = status;
//		this.manager = manager;
//		this.timestamp = timestamp;
//	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public String getManager() {
//		return manager;
//	}
//	public void setManager(String manager) {
//		this.manager = manager;
//	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getMngf() {
		return mngf;
	}
	public void setMngf(String mngf) {
		this.mngf = mngf;
	}
	public String getMngl() {
		return mngl;
	}
	public void setMngl(String mngl) {
		this.mngl = mngl;
	}
	@Override
	public String toString() {
		return   empf +" "+ empl + "=> Type: " + type + "\t-- Amount: $" + amount +" || " + decp + " || " 
				+ "\t ==" + status + "== " +  " Solved By Manager: " + mngf +" "+ mngl ;
	}
	
	
	
}
