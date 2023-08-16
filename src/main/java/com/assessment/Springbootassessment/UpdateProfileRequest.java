package com.assessment.Springbootassessment;

import java.util.Date;

public class UpdateProfileRequest {
private String displayusername;
private Date timestamp;

public String getDisplayusername() {
	return displayusername;
}
public void setDisplayusername(String displayusername) {
	this.displayusername = displayusername;
}
public Date getTimestamp() {
	return timestamp;
}
public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
public UpdateProfileRequest(String displayusername, Date timestamp) {
	super();
	this.displayusername = displayusername;
	this.timestamp = timestamp;
}
public UpdateProfileRequest() {
	super();
}


}
