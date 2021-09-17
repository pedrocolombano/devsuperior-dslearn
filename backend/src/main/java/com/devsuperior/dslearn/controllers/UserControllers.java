package com.devsuperior.dslearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearn.dto.UserDTO;
import com.devsuperior.dslearn.services.UserService;

@RestController
@RequestMapping("/users")
public class UserControllers {

	private UserService userService;

	@Autowired
	public UserControllers(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable final Long id) {
		UserDTO user = this.userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
}
