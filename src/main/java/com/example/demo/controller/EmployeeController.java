package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
	/***
	 * Read - get all employees
	 */
	 @GetMapping("/employees")
	 public Iterable <Employee> getEmployees(){
		 
		 return employeeService.getEmployees();
	 }
	 
	 /**
	  * create new employee
	  */
      @PostMapping
      public Employee createEmployee (@RequestBody Employee employee) {
    	  return employeeService.saveEmployee(employee);
      }
      /**
       * Get one employee
       */
      @GetMapping("/employee/{id}")
      public Employee getEmployee(@PathVariable ("id") final Long id) {
    	  
    	  Optional <Employee>  employee = employeeService.getEmployee(id);
    	  if (employee.isPresent()) {
    		  return employee.get();
    	  }
    	  else {
    		  return  null;
    	  }
      }
      
      /**
       * Update an existing employee
       */
      @PutMapping("/employee/{id}")
  	public Employee updateEmployee( @PathVariable("id") final Long id, @RequestBody Employee employee) {
  		Optional<Employee> e = employeeService.getEmployee(id);
  		if(e.isPresent()) {
  			Employee currentEmployee = e.get();
  			
  			String firstName = employee.getFirstName();
  			if(firstName != null) {
  				currentEmployee.setFirstName(firstName);
  			}
  			String lastName = employee.getLastName();
  			if(lastName != null) {
  				currentEmployee.setLastName(lastName);;
  			}
  			String mail = employee.getMail();
  			if(mail != null) {
  				currentEmployee.setMail(mail);
  			}
  			String password = employee.getPassword();
  			if(password != null) {
  				currentEmployee.setPassword(password);;
  			}
  			employeeService.saveEmployee(currentEmployee);
  			return currentEmployee;
  		} else {
  			return null;
  		}
  	}
      
   /**
    * delete an employee
    */
      @DeleteMapping("/employee/{id}")
      public void deleteEmployee (@PathVariable ("id") final Long id) {
    	  
    	  employeeService.deleteEmployee(id);      
     }
}
