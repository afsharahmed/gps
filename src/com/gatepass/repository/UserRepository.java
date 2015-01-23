package com.gatepass.repository;

import com.gatepass.model.User;

public interface UserRepository 
{		
	public User getUserByUsername(String username, String password);
	public void addUser(User newUser);
	public void updateUser(User user);	
	public void deleteUser(Integer userId);
}
