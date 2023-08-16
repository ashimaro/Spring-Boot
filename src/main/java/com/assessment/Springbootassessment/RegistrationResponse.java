package com.assessment.Springbootassessment;

public class RegistrationResponse {
	private String displayusername;
    private String userid;
    
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
	public RegistrationResponse(String displayusername, String userid) {
//		super();
		this.displayusername = displayusername;
		this.userid = userid;
	}
	public RegistrationResponse() {
		super();
	}
    
}

