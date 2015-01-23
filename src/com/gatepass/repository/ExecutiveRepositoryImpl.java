package com.gatepass.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gatepass.model.Executive;

@Repository
public class ExecutiveRepositoryImpl implements ExecutiveRepository 
{
	private Logger logger = LoggerFactory.getLogger(ExecutiveRepositoryImpl.class);
/**
 * 1. User --> Mahindra official						(Can Add/Update/Delete  supervisors, guards & visitors)
 * 2. Supervisor --> Security Agency Supervisor/Chief 	(Can Add/Update/Delete  guards & visitors)
 * 3. Security Guard --> Security Agency official		(Can Add/Update/Delete  only visitors)
 * 4. Visitor	--> Resident/Mahindra employee/Worker/Other
 */
	@PersistenceContext
	private EntityManager entityManager;


	@Transactional
	@Override
	public Executive getExecutiveById(Integer executiveId)
	{
		Executive c = (Executive) entityManager.getReference(Executive.class, executiveId);
		/*Session session = sessionFactory.getCurrentSession();
		Executive c = (Executive) session.get(Executive.class, executiveId);  // session.load()
		*/
		logger.info(c.toString());
		
		return c;		
	}


	@Override
	public Executive getExecutiveByUsername( String username, String password) 
	{
		Executive clerk = null;
		Query query = entityManager.createNamedQuery("getUserByUsername");
		query.setParameter("uname", username);
		query.setParameter("pwd", password);
		
		try {
			clerk = (Executive) query.getSingleResult();//uniqueResult(); // query.list() --> For Select all,   query.executeUpdate() --> For Insert/Update/Delete
		} catch (NoResultException e) {
			logger.warn("No user found by username={}", username);
		}

		return clerk;
	}

	@Transactional
	@Override
	public List<Executive> getAllExecutives() {
		Query query = entityManager.createNamedQuery("getAllExecutives");
		List<Executive> executives = query.getResultList(); //.list();
		if(executives == null) executives = new ArrayList<>();
		
		logger.info("Total executives found: "+executives);
		return executives;
		
	}
	
	@Override
	public void addExecutiveUser(Executive newExecutive) {
		try {
			entityManager.persist(newExecutive);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateExecutive(Executive executive)
	{
		entityManager.merge(executive);
	}

	@Override	
	public void deleteExecutive(Integer executiveId)
	{
//		Executive executive = new Executive();
//		executive.setExecutiveId(executiveId); // Has to be the primary key column
//		entityManager.remove(executive);
		
		/* First EntityManager.merge() method is invoked to merge 'state' of Entity into 'current' persistence context. 
		 * merge() returns the managed entity instance. Then EntityManager.remove() is called, passing in the managed contact entity instance. 
		 * The remove operation deletes the Entity record, together with all its associated information, 
		 * if we define cascade=CascadeType.ALL in the mapping. 
		 */
//		Executive mergedEntity = entityManager.merge(executive);
//		entityManager.remove(mergedEntity);
		
		Query query = entityManager.createNamedQuery("removeExecutive");
		query.setParameter("exId", executiveId);
		query.executeUpdate();
		logger.info("Executive with id: " + executiveId + " deleted successfully");
	}

}
