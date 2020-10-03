package com.employee.detail.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.detail.dao.EmpRepository;
import com.employee.detail.entity.Employee;

@RestController
@RequestMapping(path = "/rest")
public class EmpController {

	@Autowired
	EmpRepository repository;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		List<Employee> emp1 = new ArrayList<Employee>();
		repository.findAll().forEach(emp -> emp1.add(emp));
		return emp1;
	}

	@GetMapping("/getEmployeesById/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable(value = "empId") int empId) {
		return repository.findById(empId);
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return repository.save(emp);
	}

//	@PutMapping("updateEmployee/{empId}")
//	public Employee updateEmployee(@PathVariable(value="empId") Integer empId, @RequestBody Employee employee){
//		Optional<Employee> emp = repository.findById(employee.getEmpId());
//		
//		if(emp.isPresent())
//		{
//			Employee newEmployee = emp.get();
//			newEmployee.setFirstName(employee.getFirstName());
//			newEmployee.setLastName(employee.getLastName());
//			newEmployee.setEmailId(employee.getEmailId());
//			newEmployee = repository.save(employee);
//			return newEmployee;
//		}else {
//			employee = repository.save(employee);
//			return employee;
//		}		
//	}

	@DeleteMapping("/deleteEmployeeById/{empId}")
	public void deleteEmployeeById(@PathVariable(value = "empId") Integer empId) {
		Optional<Employee> emp = repository.findById(empId);
		if (emp.isPresent()) {
			repository.deleteById(empId);
		} else {
			System.out.println("No matches found");
		}
	}

}
