package com.revature.domain;

public class PendingHistory {
	private String type;
    private double amount;
    private String description;
    private String status;
    private String timestamp;
	public PendingHistory(String type, double amount, String description, String status, String timestamp) {
		super();
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.status = status;
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
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Type: " + type + "\t amount: " + amount + "\t ||" + description+ "||\t status: " + status + "\t timestamp: " + timestamp;
	}
    
    
    
}
