package com.springboot.workers.crudapi.service;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;
@Service
public class WorkerService {
		@Autowired
		@Resource(name="workerRepo")
		private WorkerRepository workerRepository;
		
		public Worker getWorker(int id) {
			try {
			return workerRepository.findWorkerById(id);
			}catch(SQLException e) {
				System.out.println(e);
				return null;
			}
		}

		public List<Worker> showAllWorker()  {
			try {
			return workerRepository.findAllWorkers();
			}catch(SQLException e) {
				System.out.println(e);
				return null;
			}

		}

		public Boolean createWorker( Worker worker) {
			try {
			int rowsAffected = workerRepository.insertWorker(worker);
			return rowsAffected>0?true:false;
			}catch(SQLException e) {
				System.out.println(e);
				return false;
			}
		}

		public Boolean updateEmail(int id,String email)  {
			try {
			int res = this.workerRepository.updateEmailById(id,email);
			return res>0?true:false;
			}catch(SQLException e) {
				System.out.println(e);
				return false;
			}
		}

		public Boolean deleteWorker(int id) {
			try {
			int res=workerRepository.deleteWorkerById(id);
			return res>0?true:false;
			}catch(SQLException e) {
				System.out.println(e);
				return false;
			}
		}
}
