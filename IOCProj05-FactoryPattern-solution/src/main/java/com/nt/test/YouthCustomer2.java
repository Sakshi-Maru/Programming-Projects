package com.nt.test;

import com.nt.comp.Car;
import com.nt.comp.BudgetCar;
import com.nt.comp.SportsCar;
import com.nt.factory.CarFactory;

public class YouthCustomer2 {
	public static void main (String[]args) {
		//get car obj using factory
		Car car=CarFactory.createCar("sports","TS10 KK 5656");
		car.drive();
		System.out.println("============");
	}

}
