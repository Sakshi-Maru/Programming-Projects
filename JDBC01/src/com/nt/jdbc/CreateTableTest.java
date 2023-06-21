package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableTest {
	public static void main (String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
	
	if (con!=null)
		st=con.createStatement();
		
	String query="CREATE TABLE EMP1(ENO NUMBER(5) PRIMARY KEY, ENAME VARCHAR(15), EADD VARCHAR(15))";
	
	System.out.println(query);
	int count=0;
	
	if(st!=null)
		count=st.executeUpdate(query);
	System.out.println("count::"+count);
		if(count==0)
		System.out.println("DB table is created");
		
		
		else
		System.out.println("DB tabe is not created");

}
     catch(SQLException se) {
     se.printStackTrace();
     if(se.getErrorCode()==955)
	 System.out.println("DB table is already created");
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
   }
 }
}


