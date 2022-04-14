package com.springboot.workers.crudapi.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.BonusDAO;
import com.springboot.workers.crudapi.mapper.BonusMapper;
import com.springboot.workers.crudapi.mapper.WorkerMapper;
import com.springboot.workers.crudapi.model.Bonus;

@Repository("bonusRepo")
public class BonusRepository implements BonusDAO {
	@Autowired
	 JdbcTemplate jdbcTemplateObject;
	@SuppressWarnings("deprecation")
	public List<Bonus> findBonusById(int workerId)
	        throws SQLException{
		String query="select * from bonus where worker_ref_id=?";
		 return jdbcTemplateObject.query(
	                query,
	                new Object[] { workerId },
	                new BonusMapper());
	}
	@SuppressWarnings("deprecation")
	public List<Bonus> allBonusByDept(String department)
	        throws SQLException{
		String query="select b.worker_ref_id,b.bonus_amount,b.bonus_date from bonus b inner join worker w on b.worker_ref_id=w.worker_id where department=?";

		return jdbcTemplateObject.query(
                query,
                new Object[] { department },
                new BonusMapper());
}
	

	public int insertBonus(int workerId,int bonusAmount)
	        throws SQLException{
		String query="insert into bonus values (?,?,now());";
		return jdbcTemplateObject.update(query,workerId,bonusAmount);
	}

	public int deleteLatestBonusById(int workerId)
	        throws SQLException{
		String query="""
				delete from bonus where worker_ref_id=? 
				and bonus_date=(  select * from(select max(bonus_date) 
				from bonus where worker_ref_id=? order by bonus_date) d);
				""";
		return jdbcTemplateObject.update(query,workerId,workerId);
	}
}
