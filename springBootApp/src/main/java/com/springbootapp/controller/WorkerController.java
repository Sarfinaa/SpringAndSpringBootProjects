package com.springbootapp.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.model.Worker;
@RestController
@RequestMapping("/worker")
public class WorkerController {
	 Worker emp = new Worker(9, "Karan", "Seth", 50000, new Date(), "new",
             "k.seth1r@my_org.in");
	 Worker emp1 = new Worker(10, "Karan", "Seth", 50000, new Date(), "new",
             "k.seth1r@my_org.in");
	 Worker emp2 = new Worker(11, "Karan", "Seth", 50000, new Date(), "new",
             "k.seth1r@my_org.in");
	 
	@GetMapping("/showWorker")
	public Worker task() {
		
		return emp;
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showHobbies() {
		return List.of(emp,emp1,emp2);
	}
}
