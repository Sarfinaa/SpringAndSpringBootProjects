package com.springboot.workers.jdbcexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.jdbcexample.util.DateTimeUtilities;

@RestController
public class HomeController {
@GetMapping("/")
public String displayMessage() {
	return "Hello visitor!\nVisiting time:"+DateTimeUtilities.getTimeStamp();
}
}
