package com.cg.spring.boot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Employee;
import com.cg.spring.boot.demo.repository.EmployeeRepository;



@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		System.out.println("Service getAllEmployees");
		return employeeRepository.findAll();
	}

	//------------------------------------------------------------------------------------

	public Employee getEmployeeById(int eid) {
		System.out.println("Service getEmployeeById");
		return employeeRepository.findById(eid).get();
	}

	//------------------------------------------------------------------------------------

	public Employee addEmployee(Employee employee) {
		System.out.println("Service addEmployee");
		if(!employeeRepository.existsById(employee.getEid()))
			return employeeRepository.save(employee);
		System.out.println(employee.getEid()+" already exists.");
		return null;
	}
	
	//------------------------------------------------------------------------------------
	
	public Employee updateEmployee(Employee employee) {
		System.out.println("Service updateEmployee");
		if(employeeRepository.existsById(employee.getEid()))
			return employeeRepository.save(employee);
		System.out.println(employee.getEid()+" does not exists.");
		return null;
	}
	
	//------------------------------------------------------------------------------------

	public int deleteEmployeeById(int eid) {
		System.out.println("Service deleteEmployeeById");
		if(employeeRepository.existsById(eid)) {
			employeeRepository.deleteById(eid);
			return eid;
		}
		System.out.println(eid+" does not exists.");
		return 0;
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
