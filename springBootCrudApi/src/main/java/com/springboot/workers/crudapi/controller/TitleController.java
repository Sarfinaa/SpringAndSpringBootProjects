package com.springboot.workers.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.springboot.workers.crudapi.model.Title;
import com.springboot.workers.crudapi.service.TitleService;

@RestController
public class TitleController {
	@Autowired
	TitleService titleService;
	
	@GetMapping("/worker/title/{id}")
	public List<Title> showTitle(@PathVariable int id) {
		return titleService.getTitle(id);
	}
	
	
	@GetMapping("dept/{dept}/all")
	public List<Title> showAllDeptTitle(@PathVariable String dept) {
		return titleService.getTitleByDept(dept);
	}
	
	@PostMapping("worker/{id}/promote/{title}")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@PathVariable int id, @PathVariable String title) {
		return titleService.updateTitle(id, title);	
	}
	
	@DeleteMapping("worker/{id}/demote")
	public boolean delete(@PathVariable int id) {
		return titleService.deleteTitle(id);
	}
}
