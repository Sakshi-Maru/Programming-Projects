package com.nt.test;

import com.nt.comp.Flipkart;
import com.nt.factory.FlipkartFactory;


public class StrategyDPTest {
	
	public static void main(String[] args) {
		try {
			//get target class object form factory
			Flipkart fpkt=FlipkartFactory.createFlipkart("bDart");
			//involve the b.logic
			String result=fpkt.shopping(new String[] {"shirt", "trouser","mobile"},
		                                  new float[] {3400.0f, 5600.0f, 60000.0f});
			System.out.println(result);
			
		}//try
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}//main

}//classS
