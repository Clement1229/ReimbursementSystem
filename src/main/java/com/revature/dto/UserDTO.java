package com.revature.dto;

import com.revature.domain.User;

public class UserDTO extends User{
	String type;
	double amount;
	String time;
	String mngf; //manager firstname
	String mngl; //manager lastname
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public UserDTO(String fn, String ln, String type, double amount, String time, String mngf, String mngl) {
		super(fn, ln);
		this.type = type;
		this.amount = amount;
		this.time = time;
		this.mngf = mngf;
		this.mngl = mngl;
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



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
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
		return "UserDTO [type=" + type + ", amount=" + amount + ", time=" + time + ", mngf=" + mngf + ", mngl=" + mngl
				+ "]";
	}

    
}

