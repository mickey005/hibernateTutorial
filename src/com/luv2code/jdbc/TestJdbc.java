package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl ="jdbc:mysql://localhost:3306/hb_student_tracker?useSSl=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		
		try {
			System.out.println("jdbc connection url=="+jdbcUrl);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("success full");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
