package com.assessment.Springbootassessment;

import java.util.Date;

public class UserModel {

		private String username;
		private String password;
		private String displayusername;
		private String userid;
		private Date timestamp;
		
		public UserModel(String userid,String username, String password, String displayusername, Date timestamp) {
			this.userid = userid;
			this.username = username;
			this.password = password;
			this.displayusername = displayusername;
			this.timestamp= timestamp;
		}
		
		public UserModel() {
			//purposely leave blank
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
			return "UserModel [username=" + username + ", password=" + password + ", displayusername=" + displayusername
					+ ", userid=" + userid + ", timestamp=" + timestamp + "]";
		}
		
		
	}

