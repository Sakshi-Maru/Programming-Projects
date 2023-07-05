package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet{ 
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		 System.out.println("LoginServlet.doGet(_,_)");
		 System.out.println("req obj type::"+req.getClass()+" "+res.getClass());
		 
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 
		  String mail=req.getParameter("email");
		  String pwd=req.getParameter("pwd");
		  System.out.println(mail+" "+pwd);
		  if(mail.equalsIgnoreCase("raja@gmail.com")&& pwd.equalsIgnoreCase("rani")) {
			  pw.println("<h1 style='color:green;text-align:center'> Valid Credentials </h1>");
		  }
		  else {
			  pw.println("<h1 style='color:red;text-align:center'> Invalid Credentials </h1>");
			  }
		  
		  pw.println("<br><a href='login.html'>home</a>");
		  pw.close();
	}
	 @Override
	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		 System.out.println("LoginServlet.doPost(_,_)");
	 }
		
}


