package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepo;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	////injecting [name of class like to inject ] + [reference variable];
	@Autowired
	EmployeeRepo employeeRepo;

	// get all Employees API
	@GetMapping("/emp")

	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeRepo.findAll();
		return ResponseEntity.ok(employees);
	}
//---------------------------------------------------------------- 17:50
	// Save Employee API //25:00
	@PostMapping("/emp") // saving all methods in database
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		try {
			Employee saveEmployee = employeeRepo.save(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	// get single Employee by ID API
	@GetMapping("/emp/{id}")

	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		return optionalEmployee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

	// update Employee by ID API

	@PutMapping("/emp/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updateEmployee) {
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			employee.setFirstname(updateEmployee.getFirstname());
			employee.setLastname(updateEmployee.getLastname());
			employee.setEmail(updateEmployee.getEmail());
			return ResponseEntity.ok(employeeRepo.save(employee));

		} else {
			return ResponseEntity.notFound().build();
		}

	}
	// delete Employee by ID
	@DeleteMapping("/emp/{id}")
	ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		Optional<Employee> optionalEmp = employeeRepo.findById(id);
		if (optionalEmp.isPresent()) {
			employeeRepo.deleteById(id);
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
