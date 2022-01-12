package com.intern;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewList {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/STUDENT";
		String username ="root";
		String password ="0000";
		try {
			//create the connection object
			Connection conn = DriverManager.getConnection(dbURL, username, password);
		
		String sql = "SELECT * FROM STUDENTS";
		
		java.sql.Statement statement = conn.createStatement(); 
				
		ResultSet result = statement.executeQuery(sql); 
		int count = 0;
		
		while(result.next()) {
			String STUD_NO= result.getString(1);
			String STUD_NAME = result.getString(2);
			String STUD_DOB =result.getString(3);
			String STUD_DOJ = result.getString(4);
			
			String output = "student #%d: %s - %s - %s - %s";
			System.out.println(String.format(output, ++count, STUD_NO, STUD_NAME, STUD_DOB, STUD_DOJ));
		}
				conn.close();
	}catch (SQLException ex) {
		ex.printStackTrace();
	}

}
}