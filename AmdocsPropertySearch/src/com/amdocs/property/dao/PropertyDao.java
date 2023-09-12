package com.amdocs.property.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.property.model.Property;


public class PropertyDao {
	private static final String ID = "select property_id from propertylist where property_id=?";

//	int addProperty(Property property);
	public int addProperty(Property property) {
		int count=0;
		 try {
			 PreparedStatement pst=JdbcConnect.getConnection().prepareStatement("insert into propertylist(property_id,no_rooms,area_in_sqft,floor_no,city,state_name,price,owner_name,owner_number) values(?,?,?,?,?,?,?,?,?)");
			 pst.setInt(1, property.getPropertyId());
			 pst.setString(2, property.getNoOfRooms());
			 pst.setDouble(3, property.getAreaInSqft());
			 pst.setInt(4, property.getFloorNo());
			 pst.setString(5,property.getCity() );
			 pst.setString(6, property.getState());
			 pst.setDouble(7, property.getCost());
			 pst.setString(8, property.getOwnerName());
			 pst.setString(9, property.getOwnerContactNo());
			 count= pst.executeUpdate();
			 		
		 }catch(Exception e) {
			 System.out.println("error");
		 }
		 return count;
	}
	
	
	public int deleteProperty(int id) {
		int count=0;
		try {
		
			PreparedStatement pst=JdbcConnect.getConnection().prepareStatement("delete from propertylist where property_id=?");
			 pst.setInt(1, id);
			 count=pst.executeUpdate();
			
		 }catch(Exception e) {
			 System.out.println("error");
		 }
		return count;
	}
	
	public boolean updatePropertyCost(int id, double cost) {
		int count=0;
		try {
			PreparedStatement pst=JdbcConnect.getConnection().prepareStatement("update propertylist set price=? where property_id=?");
			 pst.setInt(1,(int)cost);
			 pst.setInt(2,id);
			 count= pst.executeUpdate();
			
		 }catch(Exception e) {
			 System.out.println("error");
		 }
		if(count>0)
			return true;
		else
			return false;
	}
	
	
	public List<Property> ByCity(String city) 
	{
		List<Property> list1 = new ArrayList<Property>();
		ResultSet rs;
		try{
			PreparedStatement pst=JdbcConnect.getConnection().prepareStatement("Select * from propertylist where city=?");
		pst.setString(1,city);
		rs=pst.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String room=rs.getString(2);
			double area=rs.getDouble(3);
			int floor=rs.getInt(4);
			String city1=rs.getString(5);
			String state=rs.getString(6);
			double cost=rs.getDouble(7);
			String oname=rs.getString(8);
			String onumber=rs.getString(9);
			Property prop = new Property(id,room,area,floor,city1,state,cost,oname,onumber);
			list1.add(prop);
		}
		}
			catch(Exception e){e.printStackTrace();}
		return list1;
		}

	
	public List<Property> showAllProperties() {
		List<Property> list1 = new ArrayList<Property>();
		ResultSet rs;
		try{
			PreparedStatement pst=JdbcConnect.getConnection().prepareStatement("Select * from propertylist");
		rs=pst.executeQuery();
		while(rs.next()) {
			
			int id=rs.getInt(1);
			String room=rs.getString(2);
			double area=rs.getDouble(3);
			int floor=rs.getInt(4);
			String city1=rs.getString(5);
			String state=rs.getString(6);
			double cost=rs.getDouble(7);
			String oname=rs.getString(8);
			String onumber=rs.getString(9);
			Property prop = new Property(id,room,area,floor,city1,state,cost,oname,onumber);
			list1.add(prop);
			
		}
		}
			catch(Exception e){e.printStackTrace();}
		return list1;
	}
	
	public List<Property> searchByCost(double min, double max) {
		List<Property> list1 = new ArrayList<Property>();
		ResultSet rs;
		try{
			PreparedStatement pst=JdbcConnect.getConnection().prepareStatement("select * from propertylist where price between ? and ?");
		pst.setInt(1,(int)min);
		pst.setInt(2,(int)max);
		rs=pst.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String room=rs.getString(2);
			double area=rs.getDouble(3);
			int floor=rs.getInt(4);
			String city1=rs.getString(5);
			String state=rs.getString(6);
			double cost=rs.getDouble(7);
			String oname=rs.getString(8);
			String onumber=rs.getString(9);
			Property prop = new Property(id,room,area,floor,city1,state,cost,oname,onumber);
			list1.add(prop);
			
		}
		}
			catch(Exception e){e.printStackTrace();}
		return list1;
	}

	
	public List<Property> searchByNoOfRoomsAndCity(String room, String city) {
		List<Property> list1 = new ArrayList<Property>();
		ResultSet rs;
		try{
			PreparedStatement pst=JdbcConnect.getConnection().prepareStatement("select * from propertylist where city=? and no_rooms=?");
		pst.setString(1,room);
		pst.setString(2,city);
		rs=pst.executeQuery();
		while(rs.next()) {
			
			int id=rs.getInt(1);
			String room1=rs.getString(2);
			double area=rs.getDouble(3);
			int floor=rs.getInt(4);
			String city1=rs.getString(5);
			String state=rs.getString(6);
			double cost=rs.getDouble(7);
			String oname=rs.getString(8);
			String onumber=rs.getString(9);
			Property prop = new Property(id,room1,area,floor,city1,state,cost,oname,onumber);
			list1.add(prop);
			
		}
		}
			catch(Exception e){e.printStackTrace();}
		return list1;
	}

}

