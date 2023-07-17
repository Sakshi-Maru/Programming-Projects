package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empDAO")
public class EmployeeDAO {
	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	
	@Autowired
	private DataSource ds;//HAS-A property
	
	//method with persistence logic
	public int getEmpsCount() throws Exception{
		//get pool id jdbc con object
		Connection con=ds.getConnection();
		//create prepared statement object having SQL query
		PreparedStatement ps=con.prepareStatement(GET_EMPS_COUNT);
		//execute the query
		ResultSet rs=ps.executeQuery();
		//process the result
		rs.next();
		int count=rs.getInt(1);
		//close jdbc object
		rs.close();
		ps.close();
		con.close();
		return count;
		
	}//method
	
}//class
