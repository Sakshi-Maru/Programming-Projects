package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {
	public static void main (String [] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			sc=new Scanner(System.in);
					String city=null;
					if(sc!=null) {
						System.out.println("Enter student address(city name)::");
						city=sc.next();
					}
					city="'"+city+"'";
					
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
					
					if(con!=null)
						st=con.createStatement();
					String query ="DELETE FROM STUDENT WHERE SADD="+city;
					System.out.println(query);
					
					int count=0;
					if(st!=null)
						count=st.executeUpdate(query);
					
					if(count==0)
					 	System.out.println("No Records found to delete");
					else
						System.out.println("Number of records that are effected::"+count);
		}
		catch(SQLException se) {
			if(se.getErrorCode()>=900 && se.getErrorCode()<=999)
			System.out.println("Invalid col names or table names or sql keyword");
			se.printStackTrace();
			
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		finally {
			
				
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
				
				try {
					if(sc!=null)
						sc.close();
				}
				catch(Exception e) {
					e.printStackTrace();
					
				}
			}
	}
}
			
	

		
		
		
		
					
					
			
		
		
	


