package com.lawuf;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		System.out.println("Hello " + req.getParameter("username"));
		
		if (saveCredentials(username, password, email)) {
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
	

	private boolean saveCredentials(String username, String password, String email) {
		
		Connection con;
		try {
			// required for JDK 9
			Class.forName("com.mysql.jdbc.Driver");
			
			// Step 1: Get Database connection:
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawufdb?useSSL=false", "root", "start123");
			
			//Step 2: Create Statement:
			Statement stmt = con.createStatement();
			
			
			// Execute SQL Query:
			String sql = "insert into users values ('" + username +"' , '"+ password +"', '"+ email+"');";
			System.out.println(sql);
			
			int result = stmt.executeUpdate(sql);
			if(result > 0) {
				return true;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
