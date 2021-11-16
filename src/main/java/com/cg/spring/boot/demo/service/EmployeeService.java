package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.EmployeeAlreadyPresentException;
import com.cg.spring.boot.demo.exception.EmployeeNotFoundException;
import com.cg.spring.boot.demo.exception.NoEmployeesFoundException;
import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;



@Service
public class EmployeeService {
	
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	//------------------------------------------------------------------------------------

//	public List<Employee> getAllEmployees() {
//		LOG.info("Service getAllEmployees");
//		return employeeRepository.findAll();
//	}
	
	public List<Employee> getAllEmployees() {
		LOG.info("Service getAllEmployees");
		List<Employee> empOpt = employeeRepository.findAll();
		if(!empOpt.isEmpty()) {
			return empOpt;
		}
		else {
			throw new NoEmployeesFoundException("No employees found");
		}
		
	}

	//------------------------------------------------------------------------------------

	public Employee getEmployeeById(int eid) {
		LOG.info("Service getEmployeeById");
		Optional<Employee> empOpt = employeeRepository.findById(eid);
		if(!empOpt.isEmpty())
			return empOpt.get();
		else
			throw new EmployeeNotFoundException(eid + " this employee is not found.");
	}

	//------------------------------------------------------------------------------------

//	public Employee addEmployee(Employee employee) {
//		LOG.info("Service addEmployee");
//		if(!employeeRepository.existsById(employee.getEid()))
//			return employeeRepository.save(employee);
//		System.out.println(employee.getEid()+" already exists.");
//		return null;
//	}
	
	public Employee addEmployee(Employee employee) {
		LOG.info("Service addEmployee");
		boolean empOpt = employeeRepository.existsById(employee.getEid());
		if(!empOpt) {
			return employeeRepository.save(employee);
		}
		else {
			throw new EmployeeAlreadyPresentException(employee + " is already exists.");
		}
		
	}
	
	//------------------------------------------------------------------------------------
	
//	public Employee updateEmployee(Employee employee) {
//		LOG.info("Service updateEmployee");
//		if(employeeRepository.existsById(employee.getEid()))
//			return employeeRepository.save(employee);
//		System.out.println(employee.getEid()+" does not exists.");
//		return null;
//	}
	
	public Employee updateEmployee(Employee employee) {
		LOG.info("Service updateEmployee");
		Optional<Employee> empOpt = employeeRepository.findById(employee.getEid());
		if(empOpt.isPresent())
			return employeeRepository.save(employee);
		else
			throw new EmployeeNotFoundException(employee + " this employee is not found.");
		
	}
	
	
	//------------------------------------------------------------------------------------

//	public int deleteEmployeeById(int eid) {
//		LOG.info("Service deleteEmployeeById");
//		if(employeeRepository.existsById(eid)) {
//			employeeRepository.deleteById(eid);
//			return eid;
//		}
//		System.out.println(eid+" does not exists.");
//		return 0;
//	}
	
	public Employee deleteEmployeeById(int eid) {
		LOG.info("Service deleteEmployeeById");
		Optional<Employee> empOpt = employeeRepository.findById(eid);
		if(empOpt.isPresent()) {
			employeeRepository.deleteById(eid);
			return empOpt.get();
		}
		else {
			throw new EmployeeNotFoundException(eid + " this employee is not found.");
		}

	}

}








////@Component
//
//@Service
//public class EmployeeService {
//
//	private List<Employee> empList = new ArrayList<>();
//
//	// Non static block ---> Execute for each new object
//	{
//		empList.add(new Employee(101, "Sonu", 20.6));
//		empList.add(new Employee(102, "Monu", 12.6));
//		empList.add(new Employee(103, "Tonu", 17.8));
//	}
//	
//	//------------------------------------------------------------------------------------
//
//	public List<Employee> getAllEmployees() {
//		System.out.println("Service getAllEmployees");
//		return empList;
//	}
//
//	//------------------------------------------------------------------------------------
//
//	public Employee getEmployeeById(int eid) {
//
//		return empList.stream().filter(e -> e.getEid() == eid).findAny().orElse(null);
//
////		int index = -1;
////		for(int i=0;i<empList.size();i++) {
////			if(empList.get(i).getEid()==eid) {
////				index = i;
////				break;
////			}
////		}
////		return empList.get(index);
//
//	}
//
//	//------------------------------------------------------------------------------------
//
//	public Employee addEmployee(Employee employee) {
//		empList.add(employee);
//		return employee;
//	}
//
//}
