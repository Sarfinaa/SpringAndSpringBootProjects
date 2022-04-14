package com.springboot.workers.crudapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Bonus;
import com.springboot.workers.crudapi.service.BonusService;

@RestController
public class BonusController {
	@Autowired
	private BonusService bonusService;
	@GetMapping("/worker/bonus/{id}")
	public List<Bonus> showBonus(@PathVariable int id) {
		return bonusService.getBonus(id);
	}
	
	@GetMapping("/dept/{dept}/bonuses")
	public List<Bonus> showAllDeptBonus(@PathVariable String dept) {
		return bonusService.getBonusByDepartment(dept);
	}
	
	@PostMapping("/worker/{id}/bonus/new")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@PathVariable int id,@RequestBody Map<String,Integer> bonus) {
		return bonusService.createBonus(id,bonus.get("bonus"));	
	}
	
	@DeleteMapping("/worker/{id}/bonus/latest")
	public boolean delete(@PathVariable int id) {
		return bonusService.deleteBonus(id);
	}
}
