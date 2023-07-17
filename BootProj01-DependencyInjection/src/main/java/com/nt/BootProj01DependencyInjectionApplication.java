package com.nt;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {
	
	@Bean(name="cal")
	public Calendar createCalendar() {
		return Calendar.getInstance();//return Gregorian calendar class
		}

	public static void main(String[] args) {
		//Bootstrap /boot spring boot app and get IOC container ref
		ConfigurableApplicationContext ctx=SpringApplication.run(BootProj01DependencyInjectionApplication.class,args);
		//get target class
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke b.logic
		String result=generator.generateWishMessage("sakshi");
		System.out.println("Wish Message is::"+result);
		
		//close container
		((ConfigurableApplicationContext)ctx).close();
	}

}
