package com.simplilearn.helloworld.services;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class CRefreshEventHandler implements ApplicationListener<ContextRefreshedEvent>{
   public void onApplicationEvent(ContextRefreshedEvent e) {
	   Date date=new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	   System.out.println("Refreshed at:"+formatter.format(date)); 
	   }
}
