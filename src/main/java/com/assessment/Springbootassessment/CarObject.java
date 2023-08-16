package com.assessment.Springbootassessment;
import java.util.List;
public class CarObject {
	 private int id;
	    private String carname;
	    private String brand;
	    private String description;
	    private List<VarianceObject> variance;
	    
	    
		public CarObject(int id, String carname, String brand, String description, List<VarianceObject> variance) {
			super();
			this.id = id;
			this.carname = carname;
			this.brand = brand;
			this.description = description;
			this.variance = variance;
		}
		public CarObject() {
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCarname() {
			return carname;
		}
		public void setCarname(String carname) {
			this.carname = carname;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public List<VarianceObject> getVariance() {
			return variance;
		}
		public void setVariance(List<VarianceObject> variance) {
			this.variance = variance;
		}

	    
	}