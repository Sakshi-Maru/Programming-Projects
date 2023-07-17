package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
//all spring beans are taken as final class (strategyDP Rule#3)
public final class Vehicle {
	@Autowired //for filled level dependency injection
	@Qualifier("diesel")
	private Engine engg;//has-a property (composition:strategyDP rule#1)
	//has a property type interface rule#2
	//all dependent classes are implementing common interface rule#2
	
	public Vehicle() {
		System.out.println("Vehicle::0-param constructor");
	}
	
	//b.logic using dependent
	public void journey(String startPlace,String destPlace) {
		engg.start();
		System.out.println("Vehicle::journey started at::"+startPlace);
		System.out.println("journey is going on....");
		engg.stop();
		System.out.println("Vehicle::journey stopped at::"+destPlace);
		
	}
}
