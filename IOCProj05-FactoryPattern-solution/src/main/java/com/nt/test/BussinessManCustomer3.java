package com.nt.test;

import com.nt.comp.BudgetCar;
import com.nt.comp.Car;
import com.nt.comp.LuxuryCar;
import com.nt.comp.SportsCar;
import com.nt.factory.CarFactory;

public class BussinessManCustomer3 {
	
		public static void main (String[]args) {
			//get car obj using factory
			Car car=CarFactory.createCar("luxury","TS10 KK 5688");
			car.drive();
			System.out.println("============");
		}

	}


