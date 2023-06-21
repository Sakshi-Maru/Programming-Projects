package com.nt.jdbc;

import java.sql.*;

public class JdbcConn {
	public static void main (String [] args)throws Exception{
		//register JDBC driver s/w
		Class.forName("oracle.jdbc.OracleDriver");
		
		//establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
		
		if(con==null)
			System.out.println("Connection is not established");
		else
			System.out.println("Connection is established");
	}
}
					
		
		
	


