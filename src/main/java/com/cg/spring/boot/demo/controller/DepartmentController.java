package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.Department;
import com.cg.spring.boot.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private DepartmentService depService;

	@GetMapping("/getalldep")
	public ResponseEntity<List<Department>> getAllDeps() {
		LOG.info("Controller getAllDeps");
		List<Department> dep = depService.getAllDepartments();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All department details are retrieved.");
		LOG.info(headers.toString());
		ResponseEntity<List<Department>> response = new ResponseEntity<>(dep, headers, HttpStatus.OK);
		return response;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	@GetMapping("/getdepbyid/{did}")
	public ResponseEntity<Department> getDepById(@PathVariable(name = "did") int did) {
		LOG.info("getDepById");
		Department dep = depService.getDepartmentById(did); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This department is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Department> response = new ResponseEntity<>(dep, headers, HttpStatus.OK);
		return response;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	@PostMapping("/adddep")
	public ResponseEntity<Department> addDep(@RequestBody Department department) {
		LOG.info("Controller addDep");
		Department dep = depService.addDepartment(department); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This department is added to the database.");
		LOG.info(headers.toString());
		ResponseEntity<Department> response = new ResponseEntity<>(dep, headers, HttpStatus.OK);
		return response;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	@PostMapping("/updatedep")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		LOG.info("Controller updateDepartment");
		Department dep = depService.updateDepartment(department); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This department details updated in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Department> response = new ResponseEntity<>(dep, headers, HttpStatus.OK);
		return response;
	}
	
	//---------------------------------------------------------------------------------------------------

	@DeleteMapping("/deletedepbyid/{did}")
	public ResponseEntity<Department> deleteDepById(@PathVariable int did) {
		LOG.info("Controller deleteDepById");
		Department dep = depService.deleteDepartmentById(did); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This department deleted successfully.");
		LOG.info(headers.toString());
		ResponseEntity<Department> response = new ResponseEntity<>(dep, headers, HttpStatus.OK);
		return response;
	}
}
