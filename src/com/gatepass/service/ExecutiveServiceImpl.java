package com.gatepass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gatepass.model.Executive;
import com.gatepass.repository.ExecutiveRepository;

@Service
public class ExecutiveServiceImpl implements ExecutiveService
{
	private ExecutiveRepository executiveRepository;

	@Autowired
	public void setExecutiveRepository(ExecutiveRepository executiveRepository) {
		this.executiveRepository = executiveRepository;
	}
	
	@Transactional
	@Override
	public List<Executive> getAllExecutives() {
		return executiveRepository.getAllExecutives();
	}
	
	@Transactional
	@Override
	public boolean isValidUser (String username, String password)
	{
		Executive executive = executiveRepository.getExecutiveByUsername(username, password);
		
		boolean userExists = executive != null;
		
		return userExists;
	}

	@Transactional
	@Override
	public Executive getExecutiveById(Integer executiveId) 
	{
		return executiveRepository.getExecutiveById(executiveId);
	}

	@Transactional
	@Override
	public void addExecutiveUser(Executive newExecutive)
	{
		executiveRepository.addExecutiveUser(newExecutive);
	}
	
	@Transactional
	@Override
	public void updateExecutive(Executive clerk) 
	{
		executiveRepository.updateExecutive(clerk);
	}
	
	@Transactional
	@Override
	public void deleteExecutive(Integer executiveId)
	{
		executiveRepository.deleteExecutive(executiveId);		
	}

}
