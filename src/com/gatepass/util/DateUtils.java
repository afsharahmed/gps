package com.gatepass.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Afshar Ahmed
 *
 */
public class DateUtils 
{
	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	
	
	/**
	 * Get current date and time in given date-format
	 * @param dateFormat
	 * @return
	 */
	public static String getCurrentDateTime(String dateFormat)
	{
		String currentDateTime = null;
		
		try 
		{
			SimpleDateFormat formater = new SimpleDateFormat(dateFormat);
			currentDateTime = formater.format(new Date());
			
		} catch (Exception e) {
			logger.info( e.getMessage() );
			e.printStackTrace();
		}
		
		return currentDateTime;
	}


}
