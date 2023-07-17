package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		//hold spring bean cfgs file name and location
		FileSystemResource res=new FileSystemResource("src/main/java/com/nt/cfgs/applicationContext.xml");
		//create IOC container(BeanFactory container)
		XmlBeanFactory factory=new XmlBeanFactory(res);
		//get target spring bean class object
		Object obj=factory.getBean("wmg");
		//type casting
		WishMessageGenerator generator=(WishMessageGenerator)obj;
		//invoke the b.method
		String result=generator.generateMessage("raja");
		System.out.println("Wish Message is ::"+result);
		
     }//main
}//class
