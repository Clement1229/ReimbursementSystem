package com.revature.domain;

import java.sql.Blob;

public class Reimbursement {
	/*R_ID
	ERS_ID
	ST_ID
	R_AMOUNT
	R_RECEIPT
	MANAGER_ID
	R_TIMESTAMP
	R_DESCRIPTION
	RBT_ID*/
	int rId;
	int ersID;
	int stID;
	double amount;
	Blob receipt;
	int managerID;
	String timestamp;
	String description;
	int rbt_id;
	
	public Reimbursement() {
		super();
	}
	
	
	
	public Reimbursement(int ersID, int stID, double amount, String description, int rbt_id) {
		super();
		this.ersID = ersID;
		this.stID = stID;
		this.amount = amount;
		this.description = description;
		this.rbt_id = rbt_id;
	}

	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getErsID() {
		return ersID;
	}
	public void setErsID(int ersID) {
		this.ersID = ersID;
	}
	public int getStID() {
		return stID;
	}
	public void setStID(int stID) {
		this.stID = stID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
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
	public int getRbt_id() {
		return rbt_id;
	}
	public void setRbt_id(int rbt_id) {
		this.rbt_id = rbt_id;
	}
	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", ersID=" + ersID + ", stID=" + stID + ", amount=" + amount + ", receipt="
				+ receipt + ", managerID=" + managerID + ", timestamp=" + timestamp + ", description=" + description
				+ ", rbt_id=" + rbt_id + "]";
	}
	
}
