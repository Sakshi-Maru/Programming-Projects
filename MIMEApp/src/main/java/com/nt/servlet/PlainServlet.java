//PlainServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PlainServlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//set response content type
		res.setContentType("text/plain");
		//get PrintWriter Stream
		PrintWriter pw=res.getWriter();
		pw.println("<table border='1'align='centre'>");
    pw.println("<tr><th>Player name</th> <th>Medal</th> <th>Category</th> </tr>");
	  pw.println("<tr><th>Neeraj Chopra</th> <th>Gold</th> <th>Javeline</th> </tr>");
      pw.println("<tr><th>Meera Bai Chanu</th> <th>Silver</th> <th>Weight Lifting</th> </tr>");
      pw.println("<tr><th>RaviKumar Dhahiya</th> <th>Silver</th> <th>Wrestling</th> </tr>");
      pw.println("<tr><th>P.V.Sindhu</th> <th>Bronze</th> <th>Batminton</th> </tr>");
      pw.println("<tr><th>Lovlina</th> <th>Bronze</th> <th>Boxing</th> </tr>");
      pw.println("<tr><th>Bajranj</th> <th>Bronze</th> <th>Wrestling</th> </tr>");
      pw.println("</table>");
	 //close stream
	  pw.close();

	}//service(-,-)
}//class