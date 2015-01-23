package com.gatepass.service;

import com.gatepass.model.Executive;
import com.gatepass.model.User;

public interface UserService {
	
	// Check User credentials
	public boolean isValidUser(String username, String password);
	
	public void addUser(User user, Executive executive);
	
	public void updateUser();
	
	public void deleteUser();
}
