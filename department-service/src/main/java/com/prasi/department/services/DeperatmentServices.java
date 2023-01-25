package com.prasi.department.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasi.department.entity.Department;
import com.prasi.department.repo.DepartmentRepository;

@Service
public class DeperatmentServices {
	
	private static final Logger LOG=LoggerFactory.getLogger(DeperatmentServices.class);
	
	@Autowired
	DepartmentRepository repo;
	
	public String save(Department dept) {
		LOG.info("saving department");
		Department savedDept = repo.save(dept);
		if(savedDept!=null) {
			return savedDept.getdName()+" is saved with id "+savedDept.getdId();
		}
		return "error while saving";
	}
	
	public Department getDepartment(long id) {
		LOG.info("getting department for id "+id);
		return repo.findById(id).get();
		
	}

}
