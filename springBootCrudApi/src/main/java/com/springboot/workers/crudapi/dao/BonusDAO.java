package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Bonus;

public interface BonusDAO {
public List<Bonus> findBonusById(int workerId)
        throws SQLException;
public List<Bonus> allBonusByDept(String department)
        throws SQLException;

public int insertBonus(int workerId,int bonusAmount)
        throws SQLException;

public int deleteLatestBonusById(int workerId)
        throws SQLException;


}
