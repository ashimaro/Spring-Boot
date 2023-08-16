package com.assessment.Springbootassessment;

public class getProfileResponse {
	private String username;
	private String displayusername;
	private String userid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDisplayusername() {
		return displayusername;
	}
	public void setDisplayusername(String displayusername) {
		this.displayusername = displayusername;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public getProfileResponse(String username, String displayusername, String userid) {
		super();
		this.username = username;
		this.displayusername = displayusername;
		this.userid = userid;
	}
	public getProfileResponse() {
		super();
	}
	
	
	
	
}
