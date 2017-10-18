package com.revature.domain;

public class ResolvedHistory {
	private String type;
	private double amount;
	private String status;
	private String manager;
	private String timestamp;
	
	
	
	
	public ResolvedHistory(String type, double amount, String status, String manager, String timestamp) {
		super();
		this.type = type;
		this.amount = amount;
		this.status = status;
		this.manager = manager;
		this.timestamp = timestamp;
	}
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
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Type: " + type + "\n amount: " + amount + "\n status: " + status + "\n manager: " + manager
				+ "\n timestamp: " + timestamp;
	}
	
	
}
