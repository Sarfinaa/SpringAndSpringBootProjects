package com.springboot.workers.crudapi.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.service.WorkerService;
@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerService workerService;
	@GetMapping("/showWorker/{id}")
	public Worker showWorker(@PathVariable int id)  {
		return workerService.getWorker(id);

	}

	@GetMapping("/all/showWorker")
	public List<Worker> showAllWorker() {
		return workerService.showAllWorker();

	}

	@PostMapping("/create")
	public Boolean createWorker(@RequestBody Worker worker)  {
		return workerService.createWorker(worker);
//		
	}

	@PatchMapping("/update/{id}")
	public Boolean updateEmail(@PathVariable int id,@RequestBody Map<String,String> map){
		return workerService.updateEmail(id,map.get("email"));
		
	}

	@DeleteMapping("/delete/{id}")
	public Boolean deleteWorker(@PathVariable int id){
		return workerService.deleteWorker(id);
	}
}
