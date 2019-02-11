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

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("Hello " + req.getParameter("username"));
		
		if (validateCredentials(username, password)) {
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("Hello " + username);
		
		if (validateCredentials(username, password)) {
			resp.setStatus(HttpServletResponse.SC_OK);
		} else {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		
	}

	private boolean validateCredentials(String username, String password) {
		
		Connection con;
		try {
			// required for JDK 9
			Class.forName("com.mysql.jdbc.Driver");
			
			// Step 1: Get Database connection:
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawufdb?useSSL=false", "root", "start123");
			
			//Step 2: Create Statement:
			Statement stmt = con.createStatement();
			
			
			// Execute SQL Query:
			String sql = "select * from users where id ='" + username +"' and password ='"+ password +";";
			System.out.println(sql);
			
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()) {
				return true;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
