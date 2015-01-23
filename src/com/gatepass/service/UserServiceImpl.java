package com.gatepass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gatepass.model.Executive;
import com.gatepass.model.User;
import com.gatepass.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{
	private UserRepository userRepository;
	private ExecutiveService executiveService;

	@Autowired
	public void setExecutiveService(ExecutiveService executiveService) {
		this.executiveService = executiveService;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	@Override
	public boolean isValidUser(String username, String password) 
	{
		User user = userRepository.getUserByUsername(username, password);
		
		boolean userExists = user != null;
		
		return userExists;
	}

	@Override
	public void addUser(User user, Executive newExecutive) {
		userRepository.addUser(user);
		newExecutive.setUserId(user.getId());
		executiveService.addExecutiveUser(newExecutive);
	}

	@Override
	public void updateUser() {
		
	}

	@Override
	public void deleteUser() {
		
	}

}
