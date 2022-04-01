package com.springboot.workers.crudapi.repository;


import java.sql.SQLException;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.mapper.WorkerMapper;
import com.springboot.workers.crudapi.model.Worker;
@Repository("workerRepo")
public class WorkerRepository implements WorkerDAO {
	@Autowired
	 JdbcTemplate jdbcTemplateObject;
    public int add(Worker worker) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String joiningDate = sdf.format(worker.getJoiningDate());
        String query = "INSERT INTO worker VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplateObject.update(query, worker.getWorkerId(), worker.getFirstName(), worker.getLastName(),
                worker.getSalary(), joiningDate, worker.getDepartment(), worker.getEmail());

    }

    public int delete(int workerId) throws SQLException {
        String query = "DELETE FROM Worker WHERE WORKER_ID = ?";
        int res=jdbcTemplateObject.update(query, workerId);
return res;
}

	@SuppressWarnings("deprecation")
	public Worker getWorker(int workerId) throws SQLException {
        String query = "SELECT * FROM worker WHERE worker_id=?";
        return jdbcTemplateObject.queryForObject(
                query,
                new Object[] { workerId },
                new WorkerMapper());

    }

    public List<Worker> getWorkers() throws SQLException {
        String query = "SELECT * FROM worker";
        return jdbcTemplateObject.query(
                query,
                new WorkerMapper());
    }

    public int update(int workerId,String email) throws SQLException {
        String query = "UPDATE worker SET email = ? WHERE worker_id = ? ";
       int res= jdbcTemplateObject.update(query, email,workerId);
return res;
    }
  
}