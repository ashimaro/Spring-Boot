package com.assessment.Springbootassessment;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="assessmentuser")
public class UserEntity {
    @Column(name="USERNAME", length=100)
	private String username;
    
    @Column(name="PASSWORD", length=100)
	private String password;
    
	@Column(name="DISPLAYUSERNAME", length=200)
	private String displayusername;
	
	@Column(name="TIMESTAMP")
	private Date timestamp;
	
	@Id
	@Column(name="USERID", length=100)
	private String userid;
	
	public UserEntity(String userid, String username, String password, String displayusername,Date timestamp) {
		this.userid = UUID.randomUUID().toString();
		this.username = username;
		this.password = password;
		this.displayusername = displayusername;
		this.timestamp = timestamp;
		
	}
	
	public UserEntity() {
		
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

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "UserEntity [username=" + username + ", password=" + password + ", displayusername=" + displayusername
				+ ", timestamp=" + timestamp + ", userid=" + userid + "]";
	}

	
}
