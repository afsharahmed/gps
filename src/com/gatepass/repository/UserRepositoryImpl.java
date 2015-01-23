package com.gatepass.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gatepass.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository 
{
	private Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUserByUsername(String username, String password) 
	{
		User user = null;
		Query query = entityManager.createNamedQuery("getUserByUsername");
		query.setParameter("uname", username);
		query.setParameter("pwd", password);
		
		try {
			user = (User) query.getSingleResult();// uniqueResult(); // query.list() --> For Select all,   query.executeUpdate() --> For Insert/Update/Delete
		} catch (NoResultException e) {
			logger.info("No user found by username={}", username);
		}
		
		return user;
	}
	
	@Override
	public void addUser(User newUser) {
		entityManager.persist(newUser);
	}
	
	@Override
	public void updateUser(User user)
	{
		entityManager.merge(user);
	}

	@Override	
	public void deleteUser(Integer userId)
	{
//		User executive = new User();
//		executive.setUserId(executiveId); // Has to be the primary key column
//		entityManager.remove(executive);
		
		/* First EntityManager.merge() method is invoked to merge 'state' of Entity into 'current' persistence context. 
		 * merge() returns the managed entity instance. Then EntityManager.remove() is called, passing in the managed contact entity instance. 
		 * The remove operation deletes the Entity record, together with all its associated information, 
		 * if we define cascade=CascadeType.ALL in the mapping. 
		 */
//		User mergedEntity = entityManager.merge(executive);
//		entityManager.remove(mergedEntity);
		
		Query query = entityManager.createNamedQuery("removeUser");
		query.setParameter("userId", userId);
		query.executeUpdate();
		logger.info("User with id: " + userId + " deleted successfully");
	}

}
