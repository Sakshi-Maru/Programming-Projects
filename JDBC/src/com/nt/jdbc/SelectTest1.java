package com.nt.jdbc;

import java.sql.*;
import java.util.*;

public class SelectTest1 {
	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter start range of employee Salary::");
		float startSalary=sc.nextFloat();
		System.out.println("Enter start range of employee Salary::");
		float endSalary=sc.nextFloat();
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
		Statement st=con.createStatement();
		String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL>="+startSalary+"AND SAL<="+endSalary;
		System.out.println(query);
		
		ResultSet rs=st.executeQuery(query);
		System.out.println("Emp details having salary range"+startSalary+"...."+endSalary);
		while(rs.next()!=false) {
			System.out.println(rs.getInt("EMPNO")+"  "+rs.getString("ENAME")+"  "+rs.getString("JOB")+"  "+rs.getFloat("SALARY"));
		}
			rs.close();
			st.close();
			con.close();
		
		
	}
	

}
