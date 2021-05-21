package com.employee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDTO;
import com.employee.exception.EmployeeException;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/")

public class EmployeeAPI {
	
@Autowired
private EmployeeService employeeService;
		
@Autowired
private Environment environment;

@GetMapping(value="/employee")
public ResponseEntity<List<EmployeeDTO>> getAllEmployee() throws EmployeeException{
List<EmployeeDTO> employeeDTOs = employeeService.getAllEmployee();
return new ResponseEntity<>(employeeDTOs,HttpStatus.OK);
}

@GetMapping(value="/employee/{empid}")
public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer empid) throws EmployeeException{
EmployeeDTO employeeDTO = employeeService.getEmployee(empid);
return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
}

@PostMapping(value="/employee")
public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) throws EmployeeException {
Integer empid = employeeService.addEmployee(employeeDTO);
String successMessage = environment.getProperty("API.INSERT_SUCCESS") + empid;
return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
}

@PutMapping(value="/employee/{empid}")
public ResponseEntity<String> updateEmployee(@PathVariable Integer empid,
		@RequestBody EmployeeDTO employee)throws EmployeeException {
employeeService.updateEmployee(empid, employee.getEmailid());
String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
return new ResponseEntity<>(successMessage , HttpStatus.OK);
}

@DeleteMapping(value="/employee/{empid}")
public ResponseEntity<String> deleteEmployee(@PathVariable Integer empid) throws EmployeeException{
employeeService.deleteEmployee(empid);
String successMessage = environment.getProperty("API.DELETE_SUCCESS");
return new ResponseEntity<>(successMessage , HttpStatus.OK);
}
}
