package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.DepartmentAlreadyExistsException;
import com.cg.spring.boot.demo.exception.DepartmentNotFoundException;
import com.cg.spring.boot.demo.model.Department;
import com.cg.spring.boot.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartments() {
		LOG.info("Service getAllDepartments");
		List<Department> depOpt = departmentRepository.findAll();
		if (!depOpt.isEmpty()) {
			return depOpt;
		} else {
			throw new DepartmentNotFoundException("No department found");
		}
	}
	
	//------------------------------------------------------------------------------------------------
	
	public Department getDepartmentById(int did) {
		LOG.info("Service getDepartmentById");
		Optional<Department> depOpt = departmentRepository.findById(did);
		if (!depOpt.isEmpty())
			return depOpt.get();
		else
			throw new DepartmentNotFoundException(did + " this department is not found.");
	}
	
	//------------------------------------------------------------------------------------------------

	public Department addDepartment(Department department) {
		LOG.info("Service addDepartment");
		boolean depOpt = departmentRepository.existsById(department.getDid());
		if (!depOpt) {
			return departmentRepository.save(department);
		} else {
			throw new DepartmentAlreadyExistsException(department + " is already exists.");
		}
	}
	
	//------------------------------------------------------------------------------------------------

	public Department updateDepartment(Department department) {
		LOG.info("Service updateDepartment");
		Optional<Department> depOpt = departmentRepository.findById(department.getDid());
		if (depOpt.isPresent())
			return departmentRepository.save(department);
		else
			throw new DepartmentNotFoundException(department + " this department is not found.");

	}
	
	//------------------------------------------------------------------------------------------------

	public Department deleteDepartmentById(int did) {
		LOG.info("Service deleteDepartmentById");
		Optional<Department> depOpt = departmentRepository.findById(did);
		if (depOpt.isPresent()) {
			departmentRepository.deleteById(did);
			return depOpt.get();
		} else {
			throw new DepartmentNotFoundException(did + " this department is not found.");
		}

	}
}

