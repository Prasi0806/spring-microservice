package com.prasi.department.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prasi.department.entity.Department;
import com.prasi.department.services.DeperatmentServices;

@RestController
@RequestMapping("department")
public class DepartmentController {
	
	@Autowired
	DeperatmentServices deperatmentServices;
	
	@PostMapping("/")
	public String save(@RequestBody Department dept) {
		return deperatmentServices.save(dept);
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") long id) {
		return deperatmentServices.getDepartment(id);
	}
	
	

}
