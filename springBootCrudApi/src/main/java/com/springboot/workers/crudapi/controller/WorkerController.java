package com.springboot.workers.crudapi.controller;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;
@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	@Resource(name="workerRepo")
	private WorkerRepository workerRepository;
	@GetMapping("/showWorker/{id}")
	public Worker showWorker(@PathVariable int id) throws SQLException {
		return workerRepository.getWorker(id);

	}

	@GetMapping("/all/showWorker")
	public List<Worker> showAllWorker() throws SQLException {
		return workerRepository.getWorkers();

	}

	@PostMapping("/create")
	public Boolean createWorker(@RequestBody Worker worker) throws SQLException {
		int rowsAffected = workerRepository.add(worker);
//		return rowsAffected + " rows Affected";
		return rowsAffected>0?true:false;
	}

	@PatchMapping("/update/{id}")
	public Boolean updateEmail(@PathVariable int id,@RequestBody Map<String,String> map) throws SQLException {
		int res = this.workerRepository.update(id,map.get("email"));
		return res>0?true:false;
	}

	@DeleteMapping("/delete/{id}")
	public Boolean deleteWorker(@PathVariable int id) throws SQLException {
		int res=workerRepository.delete(id);
		return res>0?true:false;
	}
}
