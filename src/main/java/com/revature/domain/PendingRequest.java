package com.revature.domain;

public class PendingRequest {
	private int rid;
	private int ersin;
	private String fn;
	private String ls;
	private String type;
	private double amount;
	private String text; // description
	private String status;
	private String time;

	public PendingRequest(int rid, int ersin, String fn, String ls, String type, double amount, String text,
			String status, String time) {
		super();
		this.rid = rid;
		this.ersin = ersin;
		this.fn = fn;
		this.ls = ls;
		this.type = type;
		this.amount = amount;
		this.text = text;
		this.status = status;
		this.time = time;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getErsin() {
		return ersin;
	}

	public void setErsin(int ersin) {
		this.ersin = ersin;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLs() {
		return ls;
	}

	public void setLs(String ls) {
		this.ls = ls;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "rid: " + rid + "\t ersid: " + ersin +"\t" +fn +"\t"+ ls  + "\t"+type
				+ "\t" + amount + "\t ||" + text + "||  \t" + status + "\t" + time;
	}
	
	
	
}
