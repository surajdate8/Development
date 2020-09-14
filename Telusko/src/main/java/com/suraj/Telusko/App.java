package com.suraj.Telusko;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	static ApplicationContext context;
	public static void main( String[] args )
	{
		context=new ClassPathXmlApplicationContext("Spring.xml");        	


		Vehicle obj = (Car)context.getBean("car"); 
		obj.drive();


		//getting instance from Spring.xml
//		Tyre t=(Tyre)context.getBean("tyre");
//		System.out.println(t);


	}
}
