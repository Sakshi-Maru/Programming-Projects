package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodEatingTime extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content Type
		res.setContentType("text/html");
		//write b.logic to generateFoodTimeMessage
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		pw.print("<h1 style='color:red;text-align:center'>"+ldt.toString()+"</h1>");
		if(hour<10)
			 pw.println("<h1 style='color:blue;text-align:centre'>BreakFast Time</h1>");	 
		 else if(hour<16)
			 pw.println("<h1 style='color:yellow;text-align:centre'>Lunch Time</h1>");
		 else if(hour<19)
			 pw.println("<h1 style='color:orange;text-align:centre'>Snacks Time</h1>");
		 else
			 pw.println("<h1 style='color:black;text-align:center'>Dinner Time</h1>");
		
		//add home hyperlink
		pw.println("<br> <a href='http://localhost:8080/HtmlToServletByHyperlink1/page.html'>home</a>");
		//close stream
		pw.close();
	}
}
	


