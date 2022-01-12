package com.intern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFunction{
		public static void main(String[] args) {
			String dbURL = "jdbc:mysql://localhost:3306/STUDENT";
			String username ="root";
			String password ="0000";
			
			try {
				
				Connection conn = DriverManager.getConnection(dbURL, username, password);
				String sql = "Delete From STUDENTS were STUD_NO=?";
						// EXECUTE THE QUERY
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, "101");
				 
				int rowsDeleted = statement.executeUpdate();
				if (rowsDeleted > 0) {
				    System.out.println("A Student is deleted successfully!");
				}
				// close connection
				conn.close();
				
			}catch (SQLException ex) {
					ex.printStackTrace();
			}
			
	}
	
}