package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
    //HAS-A property(supporting composition)
	private Date date;
	
	//for constructor injection
	public WishMessageGenerator(Date date) {
		System.out.println("WishMessageGenerator::1-param constructor");
	    this.date=date;
	}

	
	//B.method
	public String generateMessage(String user) {
		System.out.println("WishMessageGenerator.generateMessage()");
		//get current hour of the day
		int hour=date.getHours();//24 hours format
		//generate wish message
		if(hour<12)
			return"Good Morning::"+user;
		else if(hour<16)
			return"Good Afternoon::"+user;
		else if(hour<20)
			return"Good Evening::"+user;
		else
			return"Good Night::"+user;
	}//method
}//class	
	


	


