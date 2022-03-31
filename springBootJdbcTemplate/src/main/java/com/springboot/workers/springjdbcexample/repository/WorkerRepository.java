package com.springboot.workers.springjdbcexample.repository;


import java.sql.SQLException;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.mapper.WorkerMapper;
import com.springboot.workers.springjdbcexample.model.Worker;
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

    public void delete(int workerId) throws SQLException {
        String query = "DELETE FROM Worker WHERE WORKER_ID = ?";
        int res=jdbcTemplateObject.update(query, workerId);
        System.out.println(res+" row deleted!!!");
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

    public int update(Worker emp) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String joiningDate = sdf.format(emp.getJoiningDate());
        String query = "UPDATE worker SET worker_id =?,first_name =?, last_name =?,  salary =?,joining_date = ?,  department = ?,email = ? WHERE worker_id = ? ";
       int res= jdbcTemplateObject.update(query, emp.getWorkerId(), emp.getFirstName(), emp.getLastName(),
                emp.getSalary(), joiningDate, emp.getDepartment(), emp.getEmail(),emp.getWorkerId());
return res;
    }
  
}