package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineEligibilityCheckServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String addrs=req.getParameter("paddrs");
		//write b.logic(request processing logic)
		if (age<18)
			pw.println("<h1 style='color:red;text-align:center'> Mr/Miss."+name+" You are not eligible for Corona Vaccine </h1>");
		else
			pw.println("<h1 style='color: green;text-align:center'>Mr/Miss."+name+" You are eligible for Corona Vaccine </h1>");
		
		//add home hyperlink 
		pw.println("<a href='http://localhost:8080/CoronaVaccineApp1/corona_vaccine.html'><img src='images/home1.png'></a>");
		//close stream
		pw.close();
	}
}


