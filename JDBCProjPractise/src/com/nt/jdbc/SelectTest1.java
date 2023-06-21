package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java .util.Scanner;

public class SelectTest1 {
	public static void main (String [] args)throws Exception{
		//read input
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter start range of employee Salary::");
		float startSalary=sc.nextFloat();
		System.out.println("Enter end range of employee Salary::");
		float endSalary=sc.nextFloat();
		
	
		//register JDBC driver s/w
		Class.forName("oracle.jdbc.OracleDriver");
		
		//establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
		
		//create statement object
		Statement st=con.createStatement();
		String query="SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>="+startSalary+" AND SAL<="+endSalary;
		System.out.println(query);
		
		//send and executeSQL SELECT  query and get ResultSet Object
		ResultSet rs=st.executeQuery(query);
		System.out.println("Emp details having salary range" +startSalary+"..."+endSalary);
		while(rs.next()!=false) {
			System.out.println(rs.getInt("EMPNO")+" "+rs.getString("ENAME")+" "+rs.getString("JOB")+" "+rs.getFloat("SAL"));
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
		
	


