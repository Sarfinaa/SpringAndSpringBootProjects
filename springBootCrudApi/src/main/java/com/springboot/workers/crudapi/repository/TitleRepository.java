package com.springboot.workers.crudapi.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.TitleDAO;
import com.springboot.workers.crudapi.mapper.TitleMapper;
import com.springboot.workers.crudapi.model.Title;
@Repository("titleRepo")
public class TitleRepository implements TitleDAO {
	@Autowired
	 JdbcTemplate jdbcTemplateObject;
	@SuppressWarnings("deprecation")
	public List<Title> findTitleById(int workerId)
	        throws SQLException{
		String query="select * from title where worker_ref_id=?";
		 return jdbcTemplateObject.query(
	                query,
	                new Object[] { workerId },
	                new TitleMapper());
		
	}
	@SuppressWarnings("deprecation")
	public List<Title> showWorkerTitleInDept(String department)
	        throws SQLException{
		String query="select worker_ref_id,worker_title,affected_from from title inner join worker on worker_ref_id=worker_id where department=?";
		 return jdbcTemplateObject.query(
	                query,
	                new Object[] { department },
	                new TitleMapper());
	}
	public int updateTitleById(int workerId,String workerTitle)
	        throws SQLException{
		String query="insert into title values(?,?,now())";
		return jdbcTemplateObject.update(query,workerId,workerTitle);
	}
	public int deleteTitleById(int workerId)
	        throws SQLException{
		String query="""
				delete from title where worker_ref_id=? and  affected_from=(select * from(
				select max(affected_from) from title where worker_ref_id=? order by affected_from) d)
				""" ;
		return jdbcTemplateObject.update(query,workerId);	}
}
