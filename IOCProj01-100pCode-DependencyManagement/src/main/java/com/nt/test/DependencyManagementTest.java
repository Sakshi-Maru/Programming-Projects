package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;


public class DependencyManagementTest {
	
	public static void main(String[] args) {
    //create IOC container 
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
     //get target class object
	WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
	//invoke the b.logic
	String result=generator.generateMessage("sakshi");
	System.out.println("output::"+result);
	
	//close IOC container
	ctx.close();
	
  }//main

}//class
