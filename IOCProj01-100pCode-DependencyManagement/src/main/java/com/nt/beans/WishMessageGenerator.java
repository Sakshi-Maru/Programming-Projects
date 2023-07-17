package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")//spring bean cfg having "wmg" as the bean id
public class WishMessageGenerator {
    //HAS-A property(supporting composition)
	@Autowired //Annotation marking HAS-A property for dependency
	private LocalDateTime ldt;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-param constructor");
	   }

	
	//B.method
	public String generateMessage(String user) {
		System.out.println(ldt);
		//get current hour of the day
		int hour=ldt.getHour();//24 hours format
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

