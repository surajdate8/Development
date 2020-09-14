package com.suraj.SpringAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
	static ApplicationContext factory;
	
    public static void main( String[] args )
    {
        factory=new AnnotationConfigApplicationContext(AppConfig.class);
       
        
        Samsung s7=factory.getBean(Samsung.class);
        s7.config();
    }
}
