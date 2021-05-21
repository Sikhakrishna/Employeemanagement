package com.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int empid;
private String empname;
private String designation;
private String emailid;
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
@Override
public String toString() {
	return "EmployeeDTO [empid=" + empid + ", empname=" + empname + ", designation=" + designation +", emailid=" +emailid+ "]";
}
}
