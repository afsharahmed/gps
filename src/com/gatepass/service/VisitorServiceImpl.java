package com.gatepass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gatepass.model.Visitor;
import com.gatepass.repository.VisitorRepository;

@Service
public class VisitorServiceImpl implements VisitorService {
	
	private VisitorRepository visitorRepository;

	@Autowired
	public void setVisitorRepository(VisitorRepository visitorRepository)
	{
		this.visitorRepository = visitorRepository;
	}
	
	@Transactional
	@Override
	public Visitor getVisitorById(Integer visitorNumber) 
	{
		return visitorRepository.getVisitorById(visitorNumber);
	}


	@Transactional
	@Override
	public List<Visitor> getAllVisitors()
	{
		return visitorRepository.getAllVisitors();
		
	}
	@Transactional
	@Override
	public void addVisitor(Visitor newVisitor)
	{
		visitorRepository.addVisitor(newVisitor);	
	}
	
	@Transactional
	@Override
	public void updateVisitor(Visitor visitor) 
	{
		visitorRepository.updateVisitor(visitor);
	}

	@Transactional
	@Override
	public void deleteVisitor(Integer visitorNumber)
	{
		visitorRepository.deleteVisitor(visitorNumber);
		
	}

}
