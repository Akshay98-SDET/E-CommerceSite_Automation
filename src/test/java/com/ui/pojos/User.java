package com.ui.pojos;

public class User {
	private String emailAdrress;
	private String Password;

	public User(String emailAdrress, String password) {
		super();
		this.emailAdrress = emailAdrress;
		Password = password;
	}

	public String getEmailAdrress() {
		return emailAdrress;
	}

	public void setEmailAdrress(String emailAdrress) {
		this.emailAdrress = emailAdrress;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "User [emailAdrress=" + emailAdrress + ", Password=" + Password + "]";
	}

}
