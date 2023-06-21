package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest7 {
	public static void main(String[] args) {
		System.out.println("SelectTest3()");
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
			
			if (con!=null)
				st=con.createStatement();
				
			String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP)";
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

