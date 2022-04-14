package com.springboot.workers.crudapi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.workers.crudapi.model.Title;

public class TitleMapper implements RowMapper<Title>{
	   public Title mapRow(ResultSet result, int rowNum) throws SQLException {
	        return new Title(result.getInt("worker_ref_id"), result.getString("worker_title"), result.getDate("affected_from"));
	    }
}
