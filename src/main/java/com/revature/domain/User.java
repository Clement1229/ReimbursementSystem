package com.revature.domain;

public class User {
	int ersId;
	String firstName;
	String lastName;
	String username;
	String password;
	String email;
	int rtId;

	
	
	public User() {
		super();
	}
    
	

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public User(int ersId, String firstName, String lastName, String username, String password, String email,
			int rtId) {
		super();
		this.ersId = ersId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.rtId = rtId;
	}


	public int getErsId() {
		return ersId;
	}

	public void setErsId(int ersId) {
		this.ersId = ersId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRtId() {
		return rtId;
	}

	public void setRtId(int rtId) {
		this.rtId = rtId;
	}

	@Override
	public String toString() {
		return "Employee [ersId=" + ersId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", rtId=" + rtId + "]";
	}

}
