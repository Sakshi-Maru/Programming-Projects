package com.nt.jdbc;

import java.sql.*;

public class SelectTest {
	public static void main (String [] args)throws Exception{
		//register JDBC driver s/w
		Class.forName("oracle.jdbc.OracleDriver");
		
		//establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
		
		//create statement object
		Statement st=con.createStatement();
		
		//send and executeSQL SELECT  query and get ResultSet Object
		ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");
		
		
		//process the ResultSet object
		while(rs.next()!=false) {
			System.out.println(rs.getInt("SNO")+" "+rs.getString("SNAME")+" "+rs.getString("SADD")+" "+rs.getFloat("AVG"));
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
			
		
