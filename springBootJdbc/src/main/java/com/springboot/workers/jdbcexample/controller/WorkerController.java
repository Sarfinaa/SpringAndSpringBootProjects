package com.springboot.workers.jdbcexample.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.jdbcexample.model.Worker;
import com.springboot.workers.jdbcexample.repository.WorkerRepository;
@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepository workerRepository;

	@GetMapping("/showWorker")
	public Worker showWorker() throws SQLException {
		return workerRepository.getWorker(1);

	}

	@GetMapping("/all/showWorker")
	public List<Worker> showAllWorker() throws SQLException {
		return workerRepository.getWorkers();

	}

	@GetMapping("/create")
	public String createWorker() throws SQLException {
		int rowsAffected = workerRepository.add(new Worker(9, "karan", "k.seth@my_org.in"));
		return rowsAffected + " rows created";
	}

	@GetMapping("/update")
	public String updateWorker() throws SQLException {
		int rowsAffected = this.workerRepository.update(new Worker(9, "Karan", "Seth", 50000, new Date(), "new",
                "k.seth1r@my_org.in"));
		return rowsAffected + " rows Affected";
	}

	@GetMapping("/delete")
	public String deleteWorker() throws SQLException {
		workerRepository.delete(9);
		return "Record deleted";
	}
}
