package com.assignment.model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
        public String login(String userN, String passw) {
        	Connection con = null;
        	Statement statement = null;
        	ResultSet resultSet = null;
        	
        	String userNameDB = "";
        	String passwordDB = "";
        	
        	try {
        		con = DBConnection.createConnection();
        		statement = con.createStatement();
        		resultSet = statement.executeQuery("select nameUsers,passUser");
        		
        		while(resultSet.next()) {
        			userNameDB = resultSet.getString("nameUsers");
        			passwordDB = resultSet.getString("passUsers");
        			
        			if(userN.contentEquals(userNameDB) && passw.equals(passwordDB)) {
        				return "SUCCESS";
        			}
        		}
        	}
        	catch(SQLException e) {
        		e.printStackTrace();
        	}
        	return "Invalid user credentials...";
        }
        
}
