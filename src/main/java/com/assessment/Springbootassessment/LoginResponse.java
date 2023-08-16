package com.assessment.Springbootassessment;

public class LoginResponse {
	private String token;
	private String displayusername;
    private String userid;
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public LoginResponse(String token, String displayusername, String userid) {
		super();
		this.token = token;
		this.displayusername = displayusername;
		this.userid = userid;
	}
	public LoginResponse() {
		super();
	}
	
    
}

