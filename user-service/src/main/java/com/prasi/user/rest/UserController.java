package com.prasi.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prasi.user.dto.UserResponseDTO;
import com.prasi.user.entity.User;
import com.prasi.user.services.UserServices;

@RestController("user/")
@RequestMapping
public class UserController {
	
	@Autowired
	UserServices services;
	
	@PostMapping("/")
	public String save(@RequestBody User user) {
		return services.save(user);
	}
	@GetMapping("/{id}")
	public UserResponseDTO getUser(@PathVariable("id") long id) {
		return services.getUser(id);
	}

}
