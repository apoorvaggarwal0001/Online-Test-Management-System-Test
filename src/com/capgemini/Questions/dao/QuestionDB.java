package com.capgemini.Questions.dao;

import java.sql.*;

public class QuestionDB {
	static Connection connection;
	static {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection myconnection() throws SQLException{
		if(connection==null) {
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			System.out.println("\nConnection Established!!");}
		return connection;
		
	}
}
