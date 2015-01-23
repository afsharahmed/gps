package com.gatepass.util;

import org.apache.commons.lang.RandomStringUtils;

/**
 * A utility class that is used to generate random alphanumeric Strings, which are
 * used by the application as uniques tokens.
 * 
 * @author Afshar Ahmed
 */
public final class TokenGenerator 
{
	public static final int MAX_TOKEN_STRING_LENGTH = 20;
	
	/**
	 * Generates a unique and random token-string.
	 * @return String  	- A random alphanumeric string value.
	 */
	public static String createTokenString()
	{
		return RandomStringUtils.randomAlphanumeric(MAX_TOKEN_STRING_LENGTH);
	}
}
