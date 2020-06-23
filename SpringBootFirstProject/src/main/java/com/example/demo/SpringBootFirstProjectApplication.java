package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootFirstProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(SpringBootFirstProjectApplication.class, args);
		System.out.println("Hi");
		
		Alien a = context.getBean(Alien.class);
		a.show();
	}

}
