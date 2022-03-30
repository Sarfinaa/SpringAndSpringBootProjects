package com.springbootapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TaskController {
	@GetMapping("/task")
	public String task() {
		return "Task demonstration";
	}
	@GetMapping("/task/showMyInfo")
	public String showInfo() {
		return "Name:Karan Seth, City:Delhi, State:Delhi, Dream_Job:Software Developer";
	}
	
	@GetMapping("/task/showMyHobbies")
	public List<String> showHobbies() {
		return List.of("Gaming","Playing Squash","Gymming");
	}
}
