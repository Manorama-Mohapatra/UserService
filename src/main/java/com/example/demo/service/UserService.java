package com.example.demo.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(String id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(String id, User updatedUser) {
		User existingUser = getUserById(id);
		existingUser.setName(updatedUser.getName());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setAge(updatedUser.getAge());
		return userRepository.save(existingUser);
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}
