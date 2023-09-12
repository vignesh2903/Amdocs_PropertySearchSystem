package com.amdocs.property.main;
import java.util.*;
public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\n     Welcome to Amdocs Property Search Application ");
			while (true) {
				try {
				
				System.out.println("\n1. Add a new property");
				System.out.println("2. Update your Property details");
				System.out.println("3. Delete a Property ");
				System.out.println("4. Seach by city");
				System.out.println("5. View all properties");
				System.out.println("6. Search by cost.");
				System.out.println("7. Seach by no.of rooms and city");
				System.out.println("8. Exit");
				System.out.println("\n Enter your choice");
				int ch = Integer.parseInt(sc.nextLine());
				switch (ch) {
				case 1:
					Main_Imp.addProperty();
					break;
				case 2:
					Main_Imp.updatePropertyCost();
					break;
				case 3:
					Main_Imp.deleteProperty();
					break;
				case 4:
					Main_Imp.searchByCity();
					break;
				case 5:
					Main_Imp.showAllProperty();
					break;
				case 6:
					Main_Imp.searchByCost();
					break;
				case 7:
					Main_Imp.searchByNoOfRoomsAndCity();
					break;
				case 8:
					System.out.println("Thankyou for using our Application!! Please visit again");
					System.exit(0);
				default:
					System.out.println("Wrong choice!! Pls try again");
					break;
				}
			}
		 catch (NumberFormatException e) {
			System.out.println("Number Format error (Enter an integer): " + e.getMessage());
		} catch (Exception e) {

			System.out.println("Data Type error : " + e.getMessage());
		}
			}
	}
}
	
