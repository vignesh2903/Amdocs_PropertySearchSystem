package com.amdocs.property.model;

public class Property extends Object{
	//Instance Variables	
	 private int propertyId;
	 private String noOfRooms;
     private double areaInSqft;
     private int floorNo;
     private String city;
   	 private String state;
     private double cost;
     private String ownerName;
     private String ownerContactNo;
     
     public int getPropertyId() {
		return propertyId;
	}


	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}


	public String getNoOfRooms() {
		return noOfRooms;
	}


	public void setNoOfRooms(String noOfRooms) {
		this.noOfRooms = noOfRooms;
	}


	public double getAreaInSqft() {
		return areaInSqft;
	}


	public void setAreaInSqft(double areaInSqft) {
		this.areaInSqft = areaInSqft;
	}


	public int getFloorNo() {
		return floorNo;
	}


	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getOwnerContactNo() {
		return ownerContactNo;
	}


	public void setOwnerContactNo(String ownerContactNo) {
		this.ownerContactNo = ownerContactNo;
	}


	public Property(int propertyId, String noOfRooms, double areaInSqft, int floorNo, String city, String state,
			double cost, String ownerName, String ownerContactNo) {
//		super();
		this.propertyId = propertyId;
		this.noOfRooms = noOfRooms;
		this.areaInSqft = areaInSqft;
		this.floorNo = floorNo;
		this.city = city;
		this.state = state;
		this.cost = cost;
		this.ownerName = ownerName;
		this.ownerContactNo = ownerContactNo;
	}


	public Property() {
	}


	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", noOfRooms=" + noOfRooms + ", areaInSqft=" + areaInSqft
				+ ", floorNo=" + floorNo + ", city=" + city + ", state=" + state + ", cost=" + cost + ", ownerName="
				+ ownerName + ", ownerContactNo=" + ownerContactNo + "]";
	}	

}
