package com.assessment.Springbootassessment;

import java.time.LocalDateTime;

public class CarSearchRequest {
	 private String carname;
	    private int pageindex;
	    private int pagesize;
	    private LocalDateTime timestamp;
		public CarSearchRequest(String carname, int pageindex, int pagesize, LocalDateTime timestamp) {
			super();
			this.carname = carname;
			this.pageindex = pageindex;
			this.pagesize = pagesize;
			this.timestamp = timestamp;
		}
		public String getCarname() {
			return carname;
		}
		public void setCarname(String carname) {
			this.carname = carname;
		}
		public int getPageindex() {
			return pageindex;
		}
		public void setPageindex(int pageindex) {
			this.pageindex = pageindex;
		}
		public int getPagesize() {
			return pagesize;
		}
		public void setPagesize(int pagesize) {
			this.pagesize = pagesize;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
	}

