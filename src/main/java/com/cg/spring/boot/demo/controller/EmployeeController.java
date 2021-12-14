package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired // Automatically gives object
	private EmployeeService empService;

// ----------------------------------------------------------------------------------------------------

////	http://localhost:8082/getallemp
//	@GetMapping("/getallemp")
//	public List<Employee> getAllEmps() {
//		LOG.info("Controller getAllEmps");
//		return empService.getAllEmployees();
//	}

	@GetMapping("/getallemp")
	public ResponseEntity<List<Employee>> getAllEmps() {
		LOG.info("Controller getAllEmps");
		List<Employee> emp = empService.getAllEmployees(); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All employees details are retrieved.");
		LOG.info(headers.toString());
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

//----------------------------------------------------------------------------------------------------

// // returns only employee object (body)
// // http://localhost:8082/getempbyid/102
//	@GetMapping("/getempbyid/{eid}")
//	public Employee getEmpById(@PathVariable(name = "eid") int id) { 
//		LOG.info("Controller getEmpById");
//		return empService.getEmployeeById(id);
//	}

//  // returns responseentity object including employee object (body + status code)
//	// http://localhost:8082/getempbyid/101
//	@GetMapping("/getempbyid/{eid}")
//	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
//		LOG.info("Controller getEmpById");
//		Employee emp = empService.getEmployeeById(eid);
//		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, HttpStatus.OK);
//		return response;
//	}

//  // returns responseentity object including employee object (body + status code + Headers)
//	// http://localhost:8082/getempbyid/101
//	@GetMapping("/getempbyid/{eid}")
//	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
//		LOG.info("Controller getEmpById");
//		Employee emp = empService.getEmployeeById(eid);
//		HttpHeaders headers = new HttpHeaders();
//		if(emp != null) {
//			headers.add("message", "This employee object is present in database");
//			LOG.info(headers.toString());
//			ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
//			return response;
//		}
//		else {
//			headers.add("message", "This employee object is not present in database");
//			LOG.info(headers.toString());
//			ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.NOT_FOUND);
//			return response;
//		}
//		
//	}

	// returns responseentity object including employee object (body) and (header)
	// http://localhost:8082/getempbyid/101
	@GetMapping("/getempbyid/{eid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(name = "eid") int eid) {
		LOG.info("getEmpById");
		Employee emp = empService.getEmployeeById(eid); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
		return response;
	}

//----------------------------------------------------------------------------------------------------

////	http://localhost:8082/addemp
//	@PostMapping("/addemp")
//	public Employee addEmp(@RequestBody Employee employee) {
//		LOG.info("Controller addEmp");
//		return empService.addEmployee(employee);
//	}

	@PostMapping("/addemp")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee employee) {
		LOG.info("Controller addEmp");
		Employee emp = empService.addEmployee(employee); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is added to the database.");
		LOG.info(headers.toString());
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
		return response;
	}

//----------------------------------------------------------------------------------------------------

////	http://localhost:8082/updateemp
//	@PostMapping("/updateemp")
//	public Employee updateEmployee(@RequestBody Employee employee) {
//		LOG.info("Controller updateEmp");
//		return empService.updateEmployee(employee);
//
//	}

	@PostMapping("/updateemp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		LOG.info("Controller updateEmp");
		Employee emp = empService.updateEmployee(employee); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee details updated in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
		return response;
	}

//----------------------------------------------------------------------------------------------------

////	http://localhost:8082/deleteempbyid/102
//	@DeleteMapping("/deleteempbyid/{eid}")
//	public int deleteEmpById(@PathVariable int eid) {
//		LOG.info("Controller deleteEmpById");
//		return empService.deleteEmployeeById(eid);
//
//	}

	@DeleteMapping("/deleteempbyid/{eid}")
	public ResponseEntity<Employee> deleteEmpById(@PathVariable int eid) {
		LOG.info("Controller deleteEmpById");
		Employee emp = empService.deleteEmployeeById(eid); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee deleted successfully.");
		LOG.info(headers.toString());
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(emp, headers, HttpStatus.OK);
		return response;
	}

//----------------------------------------------------------------------------------------------------
	@GetMapping("/getbyname/{firstName}")
	public ResponseEntity<List<Employee>> getEmpByFirstName(@PathVariable String firstName) {
		LOG.info("Controller getEmpByFirstName");
		List<Employee> emp = empService.getEmployeeByFirstName(firstName); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee with first name " + firstName + " is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

// ----------------------------------------------------------------------------------------------------
	@GetMapping("/getbysalbet/{salary1}/{salary1}")
	public ResponseEntity<List<Employee>> getEmpBySalaryInBetween(double salary1, double salary2) {
		LOG.info("Controller getEmpBySalaryInBetween");
		List<Employee> emp = empService.getEmployeeBySalaryInBetween(salary1, salary2); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message",
				"This employee with salary between " + salary1 + " and " + salary2 + " is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

// ----------------------------------------------------------------------------------------------------
	@GetMapping("/getbysalary/{salary}")
	public ResponseEntity<List<Employee>> getEmpBySalary(@PathVariable double salary) {
		LOG.info("Controller getEmpBySalary");
		List<Employee> emp = empService.getEmployeeBySalary(salary); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The employee with salary " + salary + " is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

// ----------------------------------------------------------------------------------------------------

	@GetMapping("/getbysalarygreaterthan/{salary}")
	public ResponseEntity<List<Employee>> getEmpBySalaryGreaterThan(@PathVariable double salary) {
		LOG.info("Controller getEmpBySalaryGreaterThan");
		List<Employee> emp = empService.getEmployeeBySalaryGreaterThan(salary); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The employee with salary greater than " + salary + " is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

// ----------------------------------------------------------------------------------------------------
	@GetMapping("/getbysalarylessthan/{salary}")
	public ResponseEntity<List<Employee>> getEmpBySalaryLessThan(@PathVariable double salary) {
		LOG.info("Controller getEmpBySalaryLessThan");
		List<Employee> emp = empService.getEmployeeBySalaryLessThan(salary); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The employee with salary less than " + salary + " is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

// ----------------------------------------------------------------------------------------------------
	@GetMapping("/getbyfirstnamestartswith/{firstName}")
	public ResponseEntity<List<Employee>> getEmpByFirstNameStartsWith(@PathVariable String firstName) {
		LOG.info("Controller getEmpByFirstNameStartsWith");
		List<Employee> emp = empService.getEmployeeByFirstNameStartsWith(firstName); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The employee name starting with " + firstName + " is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(emp, headers, HttpStatus.OK);
		return response;
	}

// ----------------------------------------------------------------------------------------------------
	
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