package com.gatepass.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gatepass.model.Visitor;

/**
 * @see http://www.petrikainulainen.net/spring-data-jpa-tutorial/
 * @author Afshar Ahmed
 */
@Repository
public class VisitorRepositoryImpl implements VisitorRepository 
{	
	private Logger logger = LoggerFactory.getLogger(VisitorRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Transactional
	@Override
	public List<Visitor> getAllVisitors()
	{
		Query query = entityManager.createNamedQuery("getAllVisitors");
		List<Visitor> visitors = query.getResultList();
		
		if(visitors == null) visitors = new ArrayList<>();
		
		return visitors;
	}

	@Transactional
	@Override
	public Visitor getVisitorById(Integer visitorNumber)
	{
		Visitor v = (Visitor) entityManager.getReference(Visitor.class, visitorNumber);  // session.load()
		
		logger.info(v.toString());
		
		return v;		
	}

	
	@Override
	public void addVisitor(Visitor newVisitor)
	{
		entityManager.persist(newVisitor);
	}
	
	@Override
	public void updateVisitor(Visitor visitor)
	{
		entityManager.merge(visitor);
	}

	@Override	
	public void deleteVisitor(Integer visitorNumber)
	{
//		Visitor visitor = new Visitor();
//		visitor.setVisitornumber(visitorNumber); // Has to be the primary key column
//		entityManager.remove(visitor);

		Query query = entityManager.createNamedQuery("removeVisitor");
		query.setParameter("visitorNum", visitorNumber);
		query.executeUpdate();
		logger.info("Visitor: " + visitorNumber + " deleted successfully");

	}
		

}
