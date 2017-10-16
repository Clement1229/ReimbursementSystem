package com.revature.domain;

public class ReimbursementType {
	private int RbtID;
	private String RbtName;
	
	public ReimbursementType() {
		
	}
	
	
	public ReimbursementType(int rbtID, String rbtName) {
		super();
		RbtID = rbtID;
		RbtName = rbtName;
	}
	public int getRbtID() {
		return RbtID;
	}
	public void setRbtID(int rbtID) {
		RbtID = rbtID;
	}
	public String getRbtName() {
		return RbtName;
	}
	public void setRbtName(String rbtName) {
		RbtName = rbtName;
	}


	@Override
	public String toString() {
		return "reimbursementType [RbtID=" + RbtID + ", RbtName=" + RbtName + "]";
	}
	
	
	
	
}
