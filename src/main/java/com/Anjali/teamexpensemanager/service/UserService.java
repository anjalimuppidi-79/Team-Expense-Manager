package com.Anjali.teamexpensemanager.service;

import java.util.List;

import com.Anjali.teamexpensemanager.dto.UserRequest;
import com.Anjali.teamexpensemanager.entity.User;

public interface UserService {

	User createUser(UserRequest request);

	public List<User> getAllUsers();

	public User getUserById(Long id);

	public void deleteUser(Long id);
}
