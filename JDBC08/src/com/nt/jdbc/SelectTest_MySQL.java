package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest_MySQL {
	public static void main (String [] args)throws Exception{
		//load JDBC driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/ntaz14db","root","root");
		
		//create statement object
		Statement st=con.createStatement();
		
		//send and executeSQL SELECT  query and get ResultSet Object
		ResultSet rs=st.executeQuery("SELECT * FROM STUDENT1");
		
		
		//process the ResultSet object
		while(rs.next()!=false) {
			System.out.println(rs.getInt("SNO")+" "+rs.getString("SNAME")+" "+rs.getString("SADD")+" "+rs.getFloat("AVG"));
		}
		
		rs.close();
		st.close();
		con.close();
	}
}


