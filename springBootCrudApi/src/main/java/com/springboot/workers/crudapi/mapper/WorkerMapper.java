package com.springboot.workers.crudapi.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.springboot.workers.crudapi.model.Worker;

public class WorkerMapper implements RowMapper<Worker> {
    public Worker mapRow(ResultSet result, int rowNum) throws SQLException {
        return new Worker(result.getInt("worker_id"), result.getString("first_name"),
                result.getString("last_name"), result.getInt("salary"), result.getDate("joining_date"),
                result.getString("department"), result.getString("email"));
    }
}
