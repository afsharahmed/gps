package com.gatepass.constants;

/**
 * The purpose of this class is to maintain constants used in the project.
 * By Convention, All constant names should be all caps with underscore between words.
 * Mostly, all constants will be 'public static final'
 * 
 * @author Afshar Ahmed
 * @since  11-06-2012 
 */
public class GeneralConstants 
{
	// Status Codes
	public static final Integer	STATUS_CODE_SUCCESS					= 0;
	public static final Integer	STATUS_CODE_BAD_REQUEST				= 11;
	public static final Integer	STATUS_CODE_INTERNAL_SERVER_ERROR	= 21;
	public static final Integer	STATUS_CODE_DATABASE_ERROR			= 22;
	public static final Integer	STATUS_CODE_THIRD_PARTY_ERROR		= 51;
	
	// Session Attributes constants

	// Request Attributes constants
	public static final String VCARE_SERVER_IP						= "10.9.18.11";
	//public static final String VCARE_SERVER_IP					= "10.155.13.240";
	
	//public static final String VCARE_SERVER_IP					= "182.23.143.42:8080"; // Amruta's server public IP
	//public static final String VCARE_SERVER_IP					= "10.9.22.135:8080"; // Amruta's server private IP
	
	// Cache Constants
	public static final String CACHE_DEFAULT						= "DefaultCache";
	public static final String CACHE_VCARE_USERS					= "VCareUsersCache";
	public static final String CACHE_CLIENT_CONFIGURATION			= "ClientConfigurationCache";

	// Illegal Arguments Message Constants
	public static final String MESSAGE_INVALID_ARG_TOKEN			= "Token is not present or not valid.";
	public static final String MESSAGE_INVALID_ARG_UID				= "UID is not present or invalid.";
	public static final String MESSAGE_INVALID_ARG_RESOLUTION		= "Resolution is not present or invalid.";
	public static final String MESSAGE_INVALID_ARG_CLIENT_VARIANT	= "ClientVariant is not present or invalid.";
	public static final String MESSAGE_INVALID_ARG_FOLDER_ID		= "FolderId is not present or not valid.";
	public static final String MESSAGE_INVALID_ARG_FOLDER_VERSION	= "Folder Version is not present or not valid.";
	public static final String MESSAGE_INVALID_ARG_CSS_VERSION		= "Css Version is not present or not valid.";
	public static final String MESSAGE_INVALID_ARG_USERNAME			= "Username is not present or not valid.";
	public static final String MESSAGE_INVALID_ARG_PASSWORD			= "Password is not present or not valid.";
	public static final String MESSAGE_INVALID_ARG_PASSWORD2		= "Password2 is not present or does not matches Password1.";
	public static final String MESSAGE_INVALID_ARG_MSISDN			= "MSISDN is not present or not valid.";	
	public static final String MESSAGE_INVALID_ARG_SECRET_ANS		= "Secret answer is not present or not valid.";
	public static final String MESSAGE_INVALID_ARG_SECRET_QN		= "Secret question is not present or not valid."; 
	public static final String MESSAGE_INVALID_ARG_FORM_ID			= "Form Id is not present or not valid.";	
		
	// Max lengths
	public static final Integer MAX_LENGTH_FOR_UID					= 32;
	public static final Integer MAX_LENGTH_FOR_CLIENT_VARIANT		= 25; // Assumed max length
	public static final Integer MAX_LENGTH_FOR_FOLDER_ID			= 6;  // DB id length
	public static final Integer MAX_LENGTH_FOR_VERSION				= 16; // yyyyMMddHHmm length
	public static final Integer MAX_LENGTH_FOR_USERNAME				= 100;
	public static final Integer MAX_LENGTH_FOR_PASSWORD				= 20;
	public static final Integer MIN_LENGTH_FOR_USERNAME				= 6;
	public static final Integer MIN_LENGTH_FOR_PASSWORD				= 6;
	public static final Integer MAX_LENGTH_FOR_MSISDN				= 12;
	public static final Integer MAX_LENGTH_FOR_SECRET_QN			= 200;
	public static final Integer MAX_LENGTH_FOR_SECRET_ANS			= 100;
	public static final Integer MAX_LENGTH_FOR_FORM_ID 				= 100;
	
	// General Constants
	
	/**
	 * createUserProfile :::::http://localhost:9393/MCareInterface/RequestHandler?action=2&userId=12&accountPassword=abc&secretQuestion=what is your first school name&secretAnswer=gsa&msisdn=9090909090&vfnvfflag=false
Sent at 9:49 PM on Monday
OM_Ajeeta: authenticateUser&FetchProfile ==>
http://localhost:9393/MCareInterface/RequestHandler?action=2&userId=12&accountPassword=abc&secretQuestion=what is your first school name&secretAnswer=gsa&msisdn=9090909090&vfnvfflag=false
	 */
}
