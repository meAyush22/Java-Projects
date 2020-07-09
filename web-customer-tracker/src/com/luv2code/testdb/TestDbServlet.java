package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variables
		String user = "a1";
		String pass = "a1";
		String jdbcurl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimerzone=UTC";
		
		String Driver = "com.mysql.cj.jdbc.Driver";
		//get connection to database
		
		try {
			PrintWriter out = response.getWriter();
			
			Class.forName(Driver);
			out.println("connection to data base");
			Connection mycon = DriverManager.getConnection(jdbcurl,user,pass);
			
			out.println("DONE SUCCESS");
			
		}
		catch(Exception exe){
			exe.printStackTrace();
		}
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
