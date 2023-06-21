package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {

  @Override
  public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  //get PrintWriter
	  PrintWriter pw=res.getWriter();
	  //set response content type
	  res.setContentType("text/html");
	  //write b.logic to generate the Wish Message
	  LocalDateTime ldt=LocalDateTime.now();//give current date and time
	  int hour=ldt.getHour();//gives current hour of the day
	  pw.println("<h1 style='color:pink;text-align:centre'>"+ldt.toString()+"</h1>");
	 if(hour<12)
		 pw.println("<h1 style='color:orange;text-align:centre'>Good Morning</h1>");	 
	 else if(hour<16)
		 pw.println("<h1 style='color:green;text-align:centre'>Good Afternoon</h1>");
	 else if(hour<20)
		 pw.println("<h1 style='color:blue;text-align:centre'>Good Evening</h1>");
	 else
		 pw.println("<h1 style='color:red;text-align:centre'>Good Night</h1>");
	 
	 //add home hyperlink
	 pw.println("<br> <a href='http://localhost:8080/WishApp/page.html'home</a>");
	 //close stream
	 pw.close();
  }
 }
