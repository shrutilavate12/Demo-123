package com.intern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateFunction {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/STUDENT";
		String username ="root";
		String password ="0000";
		
//		String STUD_NO="102";
//		String STUD_NAME = "juhi";
//		String STUD_DOB =" 1998-05-12";
//		String STUD_DOJ = "2021-12-05";
		
		try {
			//create the connection object
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		
		String sql = "UPDATE STUDENTS SET STUD_NO=?, STUD_NAME=?, STUD_DOB=? WERE STUD_DOJ=?";
		 //execute the query
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "STUD_NO");
		statement.setString(2, "STUD_NAME");
		statement.setString(3, "STUD_DOB");
		statement.setString(4, "STUD_DOJ");
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new student is updated successfully!");
		}
		conn.close();
		

	} catch (SQLException ex) {
		ex.printStackTrace();
	}
  }
}
	

