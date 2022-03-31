package com.springbootapp.controller;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
@GetMapping("/")
public String home() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	return   "Hello visitor!\nVisiting time:"+timestamp;
}

}
