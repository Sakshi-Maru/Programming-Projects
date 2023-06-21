package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select_NonSelectTest {
	public static void main(String[] args) {
		
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//read input
			sc=new Scanner(System.in);
			int no=0;
			String query=null;
			if(sc!=null){
				System.out.println("Enter SQLNquery(select or non-select)::");
				query=sc.nextLine();
			}
			
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
			
			if (con!=null)
				st=con.createStatement();
				
			
			if(st!=null) {
			
				boolean flag=st.execute(query);
				System.out.println(flag);
				
				if(flag==true) {
				System.out.println("SELECT SQL Query executed");
				rs=st.getResultSet();
				if(rs!=null) {
					while(rs.next()) {
						System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
						
					}
				}
				}
				else {
					System.out.println("Non-SELECT SQL Query executed");
					int count=st.getUpdateCount();
					System.out.println("no.of records that are effected::"+count);
				}
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


