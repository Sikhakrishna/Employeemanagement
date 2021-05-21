package com.employee.dto;


public class EmployeeDTO {
private Integer empid;
private String empname;
private String designation;
private String emailid;

public Integer getEmpid() {
	return empid;
}
public void setEmpid(Integer empid) {
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