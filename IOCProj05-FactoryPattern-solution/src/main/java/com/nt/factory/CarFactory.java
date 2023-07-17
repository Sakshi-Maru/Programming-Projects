package com.nt.factory;

import com.nt.comp.BudgetCar;
import com.nt.comp.Car;
import com.nt.comp.LuxuryCar;
import com.nt.comp.SportsCar;


public class CarFactory {
       //Factory having factory pattern logic (Logic to create and return one of several related classes obj)
	public static Car createCar(String type,String regNo) {
		if(type.equalsIgnoreCase("sports"))
			return new SportsCar(regNo);
		else if(type.equalsIgnoreCase("budget"))
		    return new BudgetCar(regNo);
		else if(type.equalsIgnoreCase("luxury"))
		    return new LuxuryCar(regNo);
		else
			throw new IllegalArgumentException("Invalid car Type");
	}
	
	
}
