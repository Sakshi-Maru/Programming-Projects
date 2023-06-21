package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelServlet extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{ 
		//set response content type
		res.setContentType("application/vnd.ms-excel");
		//get print writer stream
		PrintWriter pw=res.getWriter();
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><th>Actor Name </th> <th>Actress Name</th> <th>Movie</th></tr>");
		pw.println("<tr><th>Sharuk Khan</th> <th>Priyanka Chopra</th> <th>Don</th></tr>");
		pw.println("<tr><th>Salman Khan</th> <th>Katrina Kaif</th> <th>Bharat</th></tr>");
		pw.println("<tr><th>Amir Khan</th> <th>Anushka Sharma</th> <th>PK</th></tr>");
		pw.println("<tr><th>Hritik Roshan</th> <th>Aishwarya Rai</th> <th>Jodha Akbar</th></tr>");
		pw.println("<tr><th>Shahid Kapoor</th> <th>Deepika Padukone</th> <th>Padmavat</th></tr>");
		pw.println("</table>");
		//close stream
		pw.close();
	}//service(_,_)
}//class

