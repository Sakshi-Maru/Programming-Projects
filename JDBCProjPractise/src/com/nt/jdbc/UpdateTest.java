package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {
	public static void main (String [] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		try {
			sc=new Scanner(System.in);
					String newCity=null,newName=null;
					float newAvg=0.0f;
					int no=0;
					if(sc!=null) {
						System.out.println("Enter new name for student ::");
						newName=sc.nextLine();
						System.out.println("Enter new address for student ::");
						newCity=sc.nextLine();
						System.out.println("Enter new avg for student ::");
						newAvg=sc.nextFloat();
						System.out.println("Enter sno for student ::");
						no=sc.nextInt();
					
					}
					newName="'"+newName+"'";
					newCity="'"+newCity+"'";
					
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
					
					if(con!=null)
						st=con.createStatement();
					String query ="UPDATE STUDENT SET sname"
							+ "="+newName+" ,sadd="+newCity+" ,avg="+newAvg+" where sno="+no;
					
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
			else if(se.getErrorCode()==12899)
				System.out.println("Do not insert more than col size data to sname, sadd cols");
			
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



