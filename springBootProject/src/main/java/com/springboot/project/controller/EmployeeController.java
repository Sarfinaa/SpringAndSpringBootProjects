package com.springboot.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.model.Customer;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@GetMapping("/customer/all")
	public String showCustomers() {
		return "Show Customers";
	}
	@PatchMapping("/customer/update/{id}")
	public boolean updateCustomer(@PathVariable int id) {
		return true;
	}
	@PostMapping("/customer/create")
	public boolean createCustomer(@RequestBody Customer customer) {
		return true;
	}
	@DeleteMapping("/customer/delete/{id}")
	public boolean deleteCustomer(@PathVariable int id) {
		return true;
	}
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable int id){
		return new Customer();
	}
	@GetMapping("/customer/{id}/showAllTransactions")
	public List<Integer> showCustomerTransactions(@PathVariable int id){
		return new ArrayList<>();
		
	}
}
