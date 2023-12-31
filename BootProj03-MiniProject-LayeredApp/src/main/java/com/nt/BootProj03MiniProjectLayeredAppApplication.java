package com.nt;

import java.io.Closeable;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollSystemController;
import com.nt.model.Employee;

	


@SpringBootApplication
public class BootProj03MiniProjectLayeredAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj03MiniProjectLayeredAppApplication.class, args);
		//get IOC container
		PayrollSystemController controller=ctx.getBean("controller",PayrollSystemController.class);
		//gather inputs from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("enter desg1");
		String desg1=sc.next().toUpperCase();
		System.out.println("enter desg2");
		String desg2=sc.next().toUpperCase();
		System.out.println("enter desg3");
		String desg3=sc.next().toUpperCase();
		//invoke method
	    try {
	    	List<Employee> listEmps=controller.showsEmpsDetailsByDesg( desg1, desg2, desg3);
	    	listEmps.forEach(System.out::println);
				
			}
	    catch(SQLException se) {
	    	se.printStackTrace();
	    	System.out.println("Internal DB Problem");
	    }
	    	
			catch(Exception e) {
				e.printStackTrace();
		    	System.out.println("Internal unknown Problem");	
			}
			
			//close container
			((ConfigurableApplicationContext)ctx).close();
			
		}//main

	}//class