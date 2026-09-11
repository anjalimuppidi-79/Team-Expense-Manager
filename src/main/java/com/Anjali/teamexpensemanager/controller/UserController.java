package com.Anjali.teamexpensemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Anjali.teamexpensemanager.dto.UserRequest;
import com.Anjali.teamexpensemanager.entity.User;
import com.Anjali.teamexpensemanager.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest request) {

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
	}

	@GetMapping("/getUsersList")
	public ResponseEntity<List<User>> getAllUsers() {

		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {

		return ResponseEntity.ok(userService.getUserById(id));
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

		userService.deleteUser(id);

		return ResponseEntity.noContent().build();
	}
}
