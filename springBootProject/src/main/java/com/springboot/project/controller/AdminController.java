package com.springboot.project.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.model.Employee;

@RestController
@RequestMapping("/admin/employee")
public class AdminController {
@GetMapping("/{id}")
public String getEmployee(@PathVariable int id) {
	return "Employee Details";
}
@GetMapping("/all")
public String getAllEmployees() {
	return "Print all employee details";
}
@DeleteMapping("/delete/{id}")
public boolean deleteEmployeeById(@PathVariable int id) {
	return true;
}
@PatchMapping("/update")
public boolean updateEmployeeById(@RequestBody int id) {
	return true;
}
@PostMapping("/add")
public boolean addEmployee(@RequestBody Employee employee) {
	return true;
}

}
