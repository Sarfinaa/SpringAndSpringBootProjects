package com.springboot.workers.crudapi.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.workers.crudapi.model.Title;
import com.springboot.workers.crudapi.repository.TitleRepository;

@Service
public class TitleService {
	@Autowired
	@Resource(name="titleRepo")
	private TitleRepository titleRepository;
public List<Title> getTitle(int id){
	try {
		return titleRepository.findTitleById(id);
	}catch(SQLException e) {
		System.out.println(e);
		return null;
	}
}
public List<Title> getTitleByDept(String dept){
	try {
		return titleRepository.showWorkerTitleInDept(dept);
	}catch(SQLException e) {
		System.out.println(e);
		return null;
	}
}
public boolean updateTitle(int id,String workerTitle) {
	try {
		return titleRepository.updateTitleById(id,workerTitle)>0?true:false;
	}catch(SQLException e) {
		System.out.println(e);
		return false;
	}
}
public boolean deleteTitle(int id) {
	try {
		return titleRepository.deleteTitleById(id)>0?true:false;
	}catch(SQLException e) {
		System.out.println(e);
		return false;
	}
}
}
