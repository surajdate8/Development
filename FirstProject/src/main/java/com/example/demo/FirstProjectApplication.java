package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		System.out.println("Hi");
		
		ConfigurableApplicationContext context=SpringApplication.run(FirstProjectApplication.class, args);
		
		Alien A=context.getBean(Alien.class);
		A.show();
		
	}

}
