package com.springboot.workers.crudapi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.workers.crudapi.model.Bonus;

public class BonusMapper implements RowMapper<Bonus> {
	   public Bonus mapRow(ResultSet result, int rowNum) throws SQLException {
	        return new Bonus(result.getInt("worker_ref_id"),result.getInt("bonus_amount"), result.getDate("bonus_date")
	            );
	    }
}
