package com.springboot.workers.crudapi.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.workers.crudapi.model.Bonus;
import com.springboot.workers.crudapi.repository.BonusRepository;

@Service
public class BonusService {
	@Autowired
	@Resource(name="bonusRepo")
	private BonusRepository bonusRepository;
	public List<Bonus> getBonus(int id){
	try {
		return bonusRepository.findBonusById(id);
	}catch(SQLException e) {
		System.out.println(e);
		return null;
	}
	}
	public List<Bonus> getBonusByDepartment(String department){
		try {
			return bonusRepository.allBonusByDept(department);
		}catch(SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	public boolean createBonus(int workerId,int bonusAmount) {
		try {
			return bonusRepository.insertBonus(workerId,bonusAmount)>0?true:false;
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean deleteBonus(int workerId) {
		try {
			return bonusRepository.deleteLatestBonusById(workerId)>0?true:false;
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}
	}
}
