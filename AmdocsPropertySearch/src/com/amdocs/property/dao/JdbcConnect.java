package com.amdocs.property.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnect {
	public static Connection getConnection() {
		Connection con=null;
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","SYSTEM","Amdocs123"); //connection
		 }catch(Exception e) {
			 System.out.println("Error in connection");
		 }
		 return con;
	 }

}
