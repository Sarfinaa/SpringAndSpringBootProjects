package com.springboot.workers.crudapi.dao;
import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Worker;


public interface WorkerDAO {
        public int insertWorker(Worker worker)
                        throws SQLException;

        public int deleteWorkerById(int workerId)
                        throws SQLException;

        public Worker findWorkerById(int workerId)
                        throws SQLException;

        public List<Worker> findAllWorkers()
                        throws SQLException;

        public int updateEmailById(int wrokerId,String email)
                        throws SQLException;
    

}
