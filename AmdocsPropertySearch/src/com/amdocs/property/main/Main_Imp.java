package com.amdocs.property.main;
import java.sql.SQLException;
import java.util.*;
import com.amdocs.property.model.*;
import com.amdocs.property.dao.*;
import com.amdocs.property.exception.InvalidPhoneNumberException;
import com.amdocs.property.exception.PropertyNotFoundException;

public class Main_Imp{
	static List<Property> propertylist=new ArrayList<Property>();
//	public static void justThrowException() throws InvalidPhoneNumberException{
//		throw new InvalidPhoneNumberException("Invalid Phone number");
//	}
	protected static Property createProperty() {
		Scanner sc=new Scanner(System.in);
		Property obj = new Property();
		try {
			System.out.println("Enter propertyId: ");
			int id = sc.nextInt();
			obj.setPropertyId(id);
			id=obj.getPropertyId();
		
			sc.nextLine();
			System.out.println("Enter no of Rooms: ");
			String noRooms = sc.nextLine();
			obj.setNoOfRooms(noRooms);
			noRooms=obj.getNoOfRooms();
			
			System.out.println("Enter no of Area in Sqft: ");
//			double areaSqft = Double.parseDouble(scanner.nextLine());
			double areaSqft = sc.nextDouble();
			obj.setAreaInSqft(areaSqft);
			areaSqft=obj.getAreaInSqft();
			
			System.out.println("Enter the floor number: ");
			int floorNo = sc.nextInt();
			obj.setFloorNo(floorNo);
			floorNo=obj.getFloorNo();
			
			System.out.println("Enter your city: ");
			sc.nextLine();
			String city = sc.next().toLowerCase();
			obj.setCity(city);
			city=obj.getCity();
			
			System.out.println("Enter your State: ");
			String state = sc.next().toUpperCase();
			obj.setState(state);
			state=obj.getState();
			
			System.out.println("Enter the price: ");
//			double areaSqft = Double.parseDouble(scanner.nextLine());
			double cost = sc.nextDouble();
			obj.setCost(cost);
			cost=obj.getCost();
			
			System.out.println("Enter your name: ");
			sc.nextLine();
			String oname = sc.nextLine();
			obj.setOwnerName(oname);
			oname=obj.getOwnerName();
			
			do {
			System.out.println("Enter your contact no: ");
			String ocontact = sc.nextLine();
			obj.setOwnerContactNo(ocontact);
			ocontact=obj.getOwnerContactNo();
			try {
				if(ocontact.length()!=10)
					throw new InvalidPhoneNumberException("Invalid Phone number, pls enter a valid number!!");
			}
			catch(InvalidPhoneNumberException e){
	            // Prints the stack trace of the exception to the console.
//	            e.printStackTrace();/
				System.out.println(e);
			}
		}while(obj.getOwnerContactNo().length()!=10);} 
			catch (NumberFormatException e) {
			System.out.println("Please Provide a number value\n " + e.getMessage());
		}

		return obj;
	}



	protected static PropertyDao dao = new PropertyDao();
	

	protected static void addProperty() {
		Property createProperty;
			createProperty = createProperty();
			int id= dao.addProperty(createProperty);
			System.out.println("The property details are updated successfully");
		
	}
	
	protected static void deleteProperty() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the property you wanna delete: ");
		int id=sc.nextInt();
		int del=dao.deleteProperty(id);	
//		System.out.println(del);
		try {
			if(del==0)
//				System.out.println(del);
				throw new PropertyNotFoundException("Property Not Found");
			else
				System.out.println("Your property is deleted:");
		}
		catch(PropertyNotFoundException e) {
			System.out.println(e);
		}
//		System.out.println("The property details with ID: "+ del + " is deleted");
	}
	
	protected static void updatePropertyCost() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id number you want to update: ");
		int id=sc.nextInt();
		System.out.println("Enter the new cost: ");
		Double cost=sc.nextDouble();
		boolean upd=dao.updatePropertyCost(id,cost);
		try {
			if(upd==false)
				throw new PropertyNotFoundException("Property Not Found");
			else
				System.out.println("Your property cost updated to :"+cost);
		}
		catch(PropertyNotFoundException e) {
			System.out.println(e);
		}
	}
	
	protected static void searchByCity() throws PropertyNotFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the city name you wanna search: ");
		String city=sc.next().toLowerCase();
		List<Property> allProperty=dao.ByCity(city);
		try {
			if (allProperty.size()==0)
				throw new PropertyNotFoundException("No property found!!");
			else
				for (Property property : allProperty) {
					System.out.println(property);
			}
				
				
		}
		catch(PropertyNotFoundException e){
			System.out.println(e);
		}
		
	}
	protected static void showAllProperty() {
		PropertyDao dao=new PropertyDao();
		List<Property> allProperty = dao.showAllProperties();
//		
			try {
				if (allProperty.size()==0)
					throw new PropertyNotFoundException("No property found!!");
				else{
					for (Property property : allProperty) {
							System.out.println(property);
					}
				}
			}
			catch(PropertyNotFoundException e){
				System.out.println(e);
			}
		}
	
	protected static void searchByCost() {
		PropertyDao dao=new PropertyDao();
		System.out.println("Minimum price: ");
		Scanner sc=new Scanner(System.in);
		Double min=sc.nextDouble();
		System.out.println("Maximum price: ");
		Double max=sc.nextDouble();
		List<Property> allProperty = dao.searchByCost(min, max);
		
		try {
			if (allProperty.size()==0)
				throw new PropertyNotFoundException("No property found!!");
			else{
				for (Property property : allProperty) {
						System.out.println(property);
				}
			}
		}
		catch(PropertyNotFoundException e){
			System.out.println(e);
		}
//
//		for (Property property : allProperty) {
//			if (property != null)
//				System.out.println(property);
		}
	
	protected static void searchByNoOfRoomsAndCity() {
		PropertyDao dao=new PropertyDao();
		System.out.println("Enter the city name: ");
		Scanner sc=new Scanner(System.in);
		String room=sc.nextLine();
		System.out.println("Enter the no of rooms: ");
		String city=sc.next().toLowerCase();
		List<Property> allProperty = dao.searchByNoOfRoomsAndCity(room,city);
//		for (Property property : allProperty) {
//			if (property != null)
//				System.out.println(property);
//		}
		try {
			if (allProperty.size()==0)
				throw new PropertyNotFoundException("No property found!!");
			else{
				for (Property property : allProperty) {
						System.out.println(property);
				}
			}
		}
		catch(PropertyNotFoundException e){
			System.out.println(e);
		}
	}
	
	
}

