package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest3 {
	public static void main(String[] args) {
		System.out.println("SelectTest3()");
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//read input
			sc=new Scanner(System.in);
			String initChars=null;
			if(sc!=null){
				System.out.println("Enter initial character of employee name::");
				initChars=sc.next();
			}
			
			//convert input values as required for the SQL query
			initChars="'"+initChars+"%";
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
			
			if (con!=null)
				st=con.createStatement();
				
			String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE="+initChars;
			
			System.out.println(query);
			
			if(st!=null)
				rs=st.executeQuery(query);
			
			if(rs!=null) {
				boolean flag=false;
				while(rs.next()) {
					flag=true;
				System.out.println(rs.getInt("EMPNO")+" "+rs.getString("ENAME")+" "+rs.getString("JOB")+" "+rs.getFloat("SAL")+" "+rs.getInt("DEPTNO"));
				}
			if(flag==false) {
				System.out.println("No records found");
				
				
			}
		}
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
				




