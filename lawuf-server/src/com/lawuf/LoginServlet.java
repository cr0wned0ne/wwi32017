package com.lawuf;

import java.io.IOException;
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
		Map<String, String> users = new HashMap<String, String>();
		users.put("admin", "admin");
		users.put("test", "test");
		if (users.get(username) != null && users.get(username).equals(password)) {
			return true;
		}
		
		return false;
	}

}
