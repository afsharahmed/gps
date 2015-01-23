package com.gatepass.service;

import java.util.List;

import com.gatepass.model.Executive;

public interface ExecutiveService 
{
	
		public void addExecutiveUser(Executive newExecutive);

		boolean isValidUser(String username, String password);

		public List<Executive> getAllExecutives();

		public Executive getExecutiveById(Integer executiveId); 	
		
		public void updateExecutive(Executive clerk);
	
		public void deleteExecutive(Integer executiveId);

}
