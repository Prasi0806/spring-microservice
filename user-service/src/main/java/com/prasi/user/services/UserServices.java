package com.prasi.user.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prasi.user.dto.Department;
import com.prasi.user.dto.UserResponseDTO;
import com.prasi.user.entity.User;
import com.prasi.user.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServices {
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final Logger LOG=LoggerFactory.getLogger(UserServices.class);
	
	public String save(User user) {
		User save = repo.save(user);
		if(save!=null) {
			return save.getId()+" saved ";
		}
		return "error while saving";
	}
	
	public UserResponseDTO getUser(long id) {
		LOG.info("getting user info");
		UserResponseDTO u=new UserResponseDTO();
		Optional<User> findById = repo.findById(id);
		if(findById.isPresent()) {
			User user = findById.get();
			u.setUser(user);
			ResponseEntity<Department> forEntity = restTemplate.getForEntity("http://localhost:9001/department/"+user.getDid(), Department.class);
			u.setDepartment(forEntity.getBody());
		}
		return u;
	}

}
