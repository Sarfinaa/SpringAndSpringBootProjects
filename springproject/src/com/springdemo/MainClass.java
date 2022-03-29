package com.springdemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
public static void main(String[] args) {
	AbstractApplicationContext context  = new ClassPathXmlApplicationContext("Beans.xml");
	context.start();
    Bar bar =  context.getBean("bar",Bar.class);
    bar.processFooName();
    System.out.println(bar);
    context.registerShutdownHook();
}
}
