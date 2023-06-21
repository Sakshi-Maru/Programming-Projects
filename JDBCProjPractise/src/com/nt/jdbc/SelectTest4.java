package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest4 {
	public static void main(String[] args) {
		
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//read input
			sc=new Scanner(System.in);
			int dno=0;
			if(sc!=null){
				System.out.println("Enter dept no::");
				dno=sc.nextInt();
			}
		
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
			
			if (con!=null)
				st=con.createStatement();
				
			String query="SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE DEPTNO="+dno;
			
			System.out.println(query);
			
			if(st!=null)
				rs=st.executeQuery(query);
			
			if(rs!=null) {
				if(rs.next())
				System.out.println(rs.getInt("DEPTNO")+" "+rs.getString("DNAME")+" "+rs.getString("LOC"));
				
				else
				System.out.println("No records found");
				
				
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



