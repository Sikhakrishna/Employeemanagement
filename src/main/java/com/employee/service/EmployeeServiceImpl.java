package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeException;
import com.employee.repository.EmployeeRepository;

@Service(value="employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService 
{
@Autowired
private EmployeeRepository employeeRepository;

@Override
public EmployeeDTO getEmployee(Integer empid) throws EmployeeException {
Optional<Employee> optional = employeeRepository.findById(empid);
Employee employee = optional.orElseThrow(() -> new EmployeeException("Service.EMPLOYEE_NOT_FOUND"));

EmployeeDTO employee2 = new EmployeeDTO();
employee2.setEmpid(employee.getEmpid());
employee2.setDesignation(employee.getDesignation());;
employee2.setEmpname(employee.getEmpname());
employee2.setEmailid(employee.getEmailid());
return employee2;
}
		
@Override
public Integer addEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
	Employee employeeEntity = new Employee();
	employeeEntity.setDesignation(employeeDTO.getDesignation());
	employeeEntity.setEmailid(employeeDTO.getEmailid());
	employeeEntity.setEmpid(employeeDTO.getEmpid());
	employeeEntity.setEmpname(employeeDTO.getEmpname());
	Employee employeeEntity2=employeeRepository.save(employeeEntity);
	return employeeEntity2.getEmpid();
	}
		
@Override
public void updateEmployee(Integer empid, String emailid) throws EmployeeException {
Optional<Employee>employee = employeeRepository.findById(empid);
Employee e = employee.orElseThrow(() -> new EmployeeException("Service.EMPLOYEE_NOT_FOUND"));
e.setEmailid(emailid);;
}

@Override
public void deleteEmployee(Integer empid) throws EmployeeException {
Optional<Employee>employee = employeeRepository.findById(empid);
employee.orElseThrow(() -> new EmployeeException("Service.EMPLOYEE_NOT_FOUND"));
employeeRepository.deleteById(empid);
}
		
@Override
public List<EmployeeDTO>getAllEmployee() throws EmployeeException {
Iterable<Employee>employees = employeeRepository.findAll();
List<EmployeeDTO> employeeDTOs = new ArrayList<>();
employees.forEach(employee ->{
	EmployeeDTO emp = new EmployeeDTO();
emp.setDesignation(employee.getDesignation());
emp.setEmailid(employee.getEmailid());
emp.setEmpid(employee.getEmpid());
emp.setEmpname(employee.getEmpname());
employeeDTOs.add(emp);
});
			
if (employeeDTOs.isEmpty())
throw new EmployeeException("Service.EMPLOYEES_NOT_FOUND");
return employeeDTOs;
}
}
