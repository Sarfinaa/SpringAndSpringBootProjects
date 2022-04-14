package com.springboot.workers.crudapi.model;

import java.util.Date;

public class Bonus {
private int workerId;
private int bonusAmount;
private Date bonusDate;
public Bonus(int workerId, int bonusAmount, Date bonusDate) {
	super();
	this.workerId = workerId;
	this.bonusAmount = bonusAmount;
	this.bonusDate = bonusDate;
}
public int getWorkerId() {
	return workerId;
}
public void setWorkerId(int workerId) {
	this.workerId = workerId;
}
public int getBonusAmount() {
	return bonusAmount;
}
public void setBonusAmount(int bonusAmount) {
	this.bonusAmount = bonusAmount;
}
public Date getBonusDate() {
	return bonusDate;
}
public void setBonusDate(Date bonusDate) {
	this.bonusDate = bonusDate;
}



}
