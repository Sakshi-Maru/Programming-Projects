package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest2 {
	public static void main(String[] args) {
		Scanner sc=null;
		String desg1=null,desg2=null,desg3=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			sc=new Scanner(System.in);
			if (sc!=null) {
				System.out.println("enter desg1:::");
				desg1=sc.next().toUpperCase();
				System.out.println("enter desg2:::");
				desg2=sc.next().toUpperCase();
				System.out.println("enter desg3:::");
				desg3=sc.next().toUpperCase();
			}
			desg1="'"+desg1+"'";
			desg2="'"+desg2+"'";
			desg3="'"+desg3+"'";
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
			
			if (con!=null)
				st=con.createStatement();
				
			String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN("+desg1+","+desg2+","+desg3+")ORDER BY JOB";
			System.out.println(query);
			
			if(st!=null)
				rs=st.executeQuery(query);
			
			if(rs!=null) {
				System.out.println("The Employee details are");
			while(rs.next()!=false) {
				System.out.println(rs.getInt("EMPNO")+" "+rs.getString("ENAME")+" "+rs.getString("JOB")+" "+rs.getFloat("SAL")+" "+rs.getInt("DEPTNO"));
			}
		}
	}
	catch(SQLException se) {
		System.out.println(se.toString());
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
				
			
		
	


