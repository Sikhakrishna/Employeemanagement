package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDTO;
import com.employee.exception.EmployeeException;

public interface EmployeeService {

	
	public Integer addEmployee(EmployeeDTO employeeDTO) throws EmployeeException;
	public EmployeeDTO getEmployee(Integer empid) throws EmployeeException;
	public void updateEmployee(Integer empid, String emailid)throws EmployeeException;
	public void deleteEmployee(Integer empid)throws EmployeeException;
	public List<EmployeeDTO> getAllEmployee() throws EmployeeException;


}
