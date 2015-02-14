package com.gatepass.service;

import jaas.DbConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import util.LoggerInit;

 /**
 * It can call methods on other Manager classes and its own DAO class only. However, it shouldn't 
 * call DAO classes of other Managers directly.
 * 
 * The instances of other Managers and its own DAO can be obtained by Spring's Auto-wiring feature.
 * 
 * Any business specific exception should be explicitly handled here and corresponding
 * error message/code should be logged.
 *  
 * @author Afshar Ahmed
 */
@Transactional
public class AppManagerImpl implements AppManager 
{
	private Logger	logger	= LoggerFactory.getLogger( AppManagerImpl.class );


//	@Value("${kickon.cache_update_frequency}")
//	private Integer cacheUpdateFrequency;

	/*
	The order of invocation for Spring beans: 
		1. Constructor (default)  
		2. All Setters (Only of specified properties)  
		3. init-method attribute value (a method)
	*/
	public void init()
	{
		try
		{
			logger.info( "----------- Initializing AppManagerImpl -------------" );
			//DbConfiguration.init();
			//LoggerInit.init();
		}
		catch ( Exception e )
		{
			logger.error( e.getMessage() );
			e.printStackTrace();
		}
	}		

}
