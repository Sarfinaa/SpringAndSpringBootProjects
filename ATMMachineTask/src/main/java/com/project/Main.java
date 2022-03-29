package com.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.services.CustomEventPublisher;

public class Main {
	public static void main(String args[]) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		SavingAccount savings=(SavingAccount)factory.getBean("saving");
		System.out.println(savings);
		
		SalaryAccount salary=(SalaryAccount)factory.getBean("salary");
		System.out.println(salary);
		
		CustomEventPublisher custom = (CustomEventPublisher) factory.getBean("customEventPublisher");
		   try {
			   savings.withdraw(1000000);
			   custom.publish(1000000,savings);
		   }catch(IllegalArgumentException e) {
			   System.out.println(e);
		   }
		
		
		try{
			salary.withdraw(100000);
			custom.publish(100000,salary);
		}catch(IllegalArgumentException e) {
                System.out.println(e);	
}
	}
}