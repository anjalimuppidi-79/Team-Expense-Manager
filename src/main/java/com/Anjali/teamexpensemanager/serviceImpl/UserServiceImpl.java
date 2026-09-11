package com.Anjali.teamexpensemanager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Anjali.teamexpensemanager.dto.UserRequest;
import com.Anjali.teamexpensemanager.entity.User;
import com.Anjali.teamexpensemanager.exceptions.BadRequestException;
import com.Anjali.teamexpensemanager.exceptions.ResourceNotFoundException;
import com.Anjali.teamexpensemanager.repository.UserRepository;
import com.Anjali.teamexpensemanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(UserRequest request) {
		if (userRepository.findByEmail(request.email()).isPresent()) {

			throw new BadRequestException("Email already exists: " + request.email());
		}

		User user = new User();

		user.setName(request.name());
		user.setEmail(request.email());

		return userRepository.save(user);

	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {

		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));

	}

	@Override
	public void deleteUser(Long id) {

		User user = getUserById(id);

		userRepository.delete(user);

	}

}
