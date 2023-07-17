package com.nt.test;

import com.nt.comp.BudgetCar;
import com.nt.comp.Car;
import com.nt.factory.CarFactory;



public class ProffesionalCustomer1 {
	public static void main (String[]args) {
		//get car obj using factory
		Car car=CarFactory.createCar("budget","TS09 EN 5688");
		car.drive();
		System.out.println("============");
	}

}

	

