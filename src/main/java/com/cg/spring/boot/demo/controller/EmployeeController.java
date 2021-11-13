package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired   //Automatically gives object
	private EmployeeService empService;
	
//	http://localhost:8082/getallemp
	@GetMapping("/getallemp")
	public List<Employee> getAllEmps(){
		LOG.info("Controller getAllEmps");
		return empService.getAllEmployees();
	}
	
//	http://localhost:8082/getempbyid/102
	@GetMapping("/getempbyid/{eid}")
	public Employee getEmpById(@PathVariable(name = "eid") int id) { 
		LOG.info("Controller getEmpById");
		return empService.getEmployeeById(id);
	}
	
//	http://localhost:8082/addemp
	@PostMapping("/addemp")
	public Employee addEmp(@RequestBody Employee employee) {
		LOG.info("Controller addEmp");
		return empService.addEmployee(employee);
	}
	
//	http://localhost:8082/updateemp
	@PostMapping("/updateemp")
	public Employee updateEmployee(@RequestBody Employee employee) {
		LOG.info("Controller updateEmp");
		return empService.updateEmployee(employee);

	}
	
//	http://localhost:8082/deleteempbyid/102
	@DeleteMapping("/deleteempbyid/{eid}")
	public int deleteEmpById(@PathVariable int eid) {
		LOG.info("Controller deleteEmpById");
		return empService.deleteEmployeeById(eid);

	}
	
	
	 
	
	
}



//
//@GetMapping("/getemp")
//public Employee getEmployee() {
//	System.out.println("getEmployee");
//	return new Employee(101, "Akshay", 15.2);
//}
//
//@GetMapping("/getallemp")
//public List<Employee> getAllEmployees(){
//	List<Employee> empList = new ArrayList<>();
//	empList.add(new Employee(102, "Sonu", 14.6));
//	empList.add(new Employee(103, "Tonu", 19.6));
//	empList.add(new Employee(104, "Gonu", 17.8));
//	
//	return empList;
//}