package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Title;
import com.springboot.workers.crudapi.model.Worker;

public interface TitleDAO {
public List<Title> findTitleById(int workerId)
        throws SQLException;
public List<Title> showWorkerTitleInDept(String department)
        throws SQLException;
public int updateTitleById(int workerId,String workerTitle)
        throws SQLException;
public int deleteTitleById(int workerId)
        throws SQLException;

}
