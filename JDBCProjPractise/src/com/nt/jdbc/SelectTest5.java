package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectTest5 {
public static void main(String[] args) {
		
	
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
			
			if (con!=null)
				st=con.createStatement();
				
			String query="SELECT COUNT(*) FROM EMP";
			                              //FROM STUDENT      
			System.out.println(query);
			
			if(st!=null)
				rs=st.executeQuery(query);
			
			if(rs!=null) {
				rs.next();
				int count=rs.getInt("COUNT(*)");
				System.out.println("Record count in Emp DB table::"+count);
				                                   //Student
			}
}
		catch(SQLException se) {
			se.printStackTrace();
			
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs!=null)
						rs.close();
				}
				catch (SQLException se) {
					se.printStackTrace();
				}
				
				try {
					if(st!=null)
						st.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				
				try {
					if(con!=null)
						con.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			
					
				}
			}
		}
		
		