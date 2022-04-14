package com.springboot.workers.crudapi.model;

import java.util.Date;

public class Title {
private int workerId;
private String workerTitle;
private Date affectedFrom;
public Title(int workerId, String workerTitle, Date affectedFrom) {
	super();
	this.workerId = workerId;
	this.workerTitle = workerTitle;
	this.affectedFrom = affectedFrom;
}
public int getWorkerId() {
	return workerId;
}
public void setWorkerId(int workerId) {
	this.workerId = workerId;
}
public String getWorkerTitle() {
	return workerTitle;
}
public void setWorkerTitle(String workerTitle) {
	this.workerTitle = workerTitle;
}
public Date getAffectedFrom() {
	return affectedFrom;
}
public void setAffectedFrom(Date affectedFrom) {
	this.affectedFrom = affectedFrom;
}

}
