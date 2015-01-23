package com.gatepass.repository;

import java.util.List;

import com.gatepass.model.Visitor;;

public interface VisitorRepository 
{
	public List<Visitor> getAllVisitors();
	
	public Visitor getVisitorById(Integer visitorNumber);
	
	public void addVisitor(Visitor newVisitor);
	
	public void updateVisitor(Visitor visitor);
	
	public void deleteVisitor(Integer visitorNumber);
}
