package com.gatepass.repository;

import java.util.List;

import com.gatepass.model.Executive;

public interface ExecutiveRepository
{
	public Executive getExecutiveByUsername( String username, String password);

	public List<Executive> getAllExecutives();
	
	public Executive getExecutiveById(Integer executiveId);

	public void addExecutiveUser(Executive newExecutive);
	
	public void updateExecutive(Executive clerk);

	public void deleteExecutive(Integer executiveId);
}
