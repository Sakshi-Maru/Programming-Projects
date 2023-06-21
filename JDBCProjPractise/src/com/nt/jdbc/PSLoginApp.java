package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PSLoginApp {
	public static final String LOGIN_QUERY="SELECT COUNT(*) FROM IRC_TAB WHERE UNAME=? AND PWD=?";
	public static void main(String [] args) {
	Scanner sc=null;
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	try {
			sc=new Scanner(System.in);
					String user=null,pass=null;
					if(sc!=null) {
						System.out.println("Enter Login Username ::");
						user=sc.nextLine();
						System.out.println("Enter Login Password ::");
				        pass=sc.nextLine();
					}
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","lion");
					
					if(con!=null)
						ps=con.prepareStatement(LOGIN_QUERY);
					
					if(ps!=null) {
						ps.setString(1, user);
					    ps.setString(2, pass);
		
		}
			        if(ps!=null)
						rs=ps.executeQuery();
					
					if(rs!=null) {
						rs.next();
						int count=rs.getInt(1);
						if(count==0)
	                     System.out.println("INVALID CREDENTIAL");
					    else
						System.out.println("VALID CREDENTIAL");
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
					if(ps!=null)
						ps.close();
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

		
		