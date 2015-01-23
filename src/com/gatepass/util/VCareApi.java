package com.gatepass.util;

import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gatepass.constants.GeneralConstants;
import com.ibm.json.java.OrderedJSONObject;


/**
 * @author afshar.ahmed
 *
 */
public class VCareApi 
{
	private static final String UTF_8 = "UTF-8";
	private static Logger logger = LoggerFactory.getLogger(VCareApi.class);
	
	public static String fetchUserProfileBasedOnMSISDN(final String msisdn)
	{
		String data = null;
		//fetchUserProfileBasedOnMSISDN::::http://localhost:9393/MCareInterface/RequestHandler?action=1&msisdn=9090909090
		try
		{
			String url = "http://" + GeneralConstants.VCARE_SERVER_IP + "/MCareInterface/RequestHandler?action=1&";
			String charset = UTF_8;
			String paramString = String.format("msisdn=%s", URLEncoder.encode(msisdn, charset));

			logger.info("fetchUserProfileBasedOnMSISDN() - URL to connect: "+ url + paramString);
			data = VCareHttpConnection.send(url, paramString);
			logger.info("fetchUserProfileBasedOnMSISDN() - Data Received: "+data);
			
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
			
		return data;
	}
	
	/**
	 * First time when login fails
	 * @param msisdn
	 * @return
	 */
	public static String createUserProfile(final String userId, final String accountPassword, 
											final String secretQuestion, final String secretAnswer, 
											final String msisdn, final Object userProfileObject)
	{
		String data = null;
		logger.info("createUserProfile() - userProfileObject:"+ userProfileObject);
		try
		{
//			String url = "http://" + GeneralConstants.VCARE_SERVER_IP + "/MCareInterface/RequestHandler?action=2&userId=" + userId 
//						+"&accountPassword="+accountPassword + "&secretQuestion="+secretQuestion + "&secretAnswer="+secretAnswer
//						+"&msisdn="+msisdn+"&userProfileObject="+userProfileObject;
			
			String url = "http://" + GeneralConstants.VCARE_SERVER_IP + "/MCareInterface/RequestHandler?action=2";
			String charset = UTF_8;
			String paramString = String.format("userId=%s&accountPassword=%s&secretQuestion=%s&secretAnswer=%s&msisdn=%s&userProfileObject=%s",
								URLEncoder.encode(userId, charset), 
								URLEncoder.encode(accountPassword, charset),
								URLEncoder.encode(secretQuestion, charset),
								URLEncoder.encode(secretAnswer, charset),
								URLEncoder.encode(msisdn, charset),
								URLEncoder.encode(userProfileObject.toString(), charset));

			logger.info("createUserProfile() - URL to connect:"+ url +paramString);
			data = VCareHttpConnection.send(url, paramString);
			logger.info("createUserProfile() - Data Received:"+ data);
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
			
		return data;
	}
	
	public static String authenticateUser(final String userName, final String password)
	{
		String data = null;
		//http://localhost:9393/MCareInterface/RequestHandler?action=3&userName=om&password=om
		try
		{
			String url = "http://" + GeneralConstants.VCARE_SERVER_IP + "/MCareInterface/RequestHandler?action=3";
			String charset = UTF_8;
			String paramString = String.format("userName=%s&password=%s",
								URLEncoder.encode(userName, charset), 
								URLEncoder.encode(password, charset));
			
			logger.info("authenticateUser() - URL to connect:"+ url+paramString);
	//		data = VCareHttpConnection.getDataOverHttpConnection(url);
			data = VCareHttpConnection.send(url, paramString);
			logger.info("authenticateUser() - Data Received:"+ data);
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
			
		return data;
	}
	
	//http://localhost:9393/MCareInterface/RequestHandler?action=4&userProfileObject=userProfileObject
	public static String getVFDataPlans(final Object userProfileObject)
	{
		String data = null;
		try
		{
			if(userProfileObject != null)
			{
				String url = "http://" + GeneralConstants.VCARE_SERVER_IP + "/MCareInterface/RequestHandler?action=4";
				String charset = UTF_8;
				String paramString = String.format("userProfileObject=%s",
									URLEncoder.encode(userProfileObject.toString(), charset));

				logger.info("getVFDataPlans() - URL to connect:"+ url + paramString);
//				data = VCareHttpConnection.getDataOverHttpConnection(url);
				data = VCareHttpConnection.send(url, paramString);
				logger.info("getVFDataPlans() - Data Received:"+ data);
			}
			else
			{
				logger.info("Cannot get VF data plans: userProfileObject is null");
			}
			
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
			
		return data;
	}
	
	public static void main(String[] args) 
	{
		try 
		{
			OrderedJSONObject userProfile = (OrderedJSONObject) OrderedJSONObject.parse("{\"userId\":\"1\",\"title\":\"Mr.\",\"firstName\":\"Paul\",\"lastName\":\"Adams\",\"gender\":\"M\",\"dateOfBirth\":\"15-05-86\",\"accountPassword\":\"asdff\",\"secretQuestion\":\"what is your first school name?\",\"secretAnswer\":\"mount caramel\",\"msisdn\":\"9090912345\",\"emailId\":\"paul.adams@hotmail.com\",\"vfnvfFlag\":\"vf postpaid\",\"errorCode\":\"1\",\"errorDescription\":\"The user is already registered with this MSISDN\"}");
			OrderedJSONObject userProfile2 = (OrderedJSONObject) OrderedJSONObject.parse("{\"userId\":\"101\",\"title\":\"Mr.\",\"firstName\":\"Paul\",\"lastName\":\"Adams\",\"gender\":\"M\",\"dateOfBirth\":\"15-05-86\",\"accountPassword\":\"abc\",\"secretQuestion\":\"What is your first school name?\",\"secretAnswer\":\"mount caramel\",\"msisdn\":\"9090912345\",\"emailId\":\"paul.adams@hotmail.com\",\"vfnvfFlag\":\"vf postpaid\",\"customerId\":\"21\",\"contractId\":\"2134\",\"circleId\":\"13\",\"partyId\":\"14\",\"accountId\":\"15\",\"serviceFlag\":\"false\",\"errorCode\":\"0\",\"errorDescription\":\"success\"}");

			VCareApi.fetchUserProfileBasedOnMSISDN("9890901010");
			//{"grid":{"userProfile":{"userId":"1","title":"Mr.","firstName":"Paul","lastName":"Adams","gender":"M","dateOfBirth":"15-05-86","accountPassword":"asdff","secretQuestion":"what is your first school name?","secretAnswer":"mount caramel","msisdn":"9090912345","emailId":"paul.adams@hotmail.com","vfnvfFlag":"vf postpaid","errorCode":"1","errorDescription":"The user is already registered with this MSISDN"}}}
			//earlier {"grid":{"userProfile":{"errorCode":"1","errorDescription":"User profile not found"}}}
			
			//VCareApi.createUserProfile("afshar", "aaa", "wqerwqer?", "ewrq", "9890000005", userProfile);
			//{"grid":{"userProfile":{"status":"0","errorCode":"0","errorDescription":"profile created succesfully"}}}
			
			
			//VCareApi.authenticateUser("aaa", "aaa");
			//{"grid":{"userProfile":{"userId":"101","title":"Mr.","firstName":"Paul","lastName":"Adams","gender":"M","dateOfBirth":"15-05-86","accountPassword":"abc","secretQuestion":"What is your first school name?","secretAnswer":"mount caramel","msisdn":"9090912345","emailId":"paul.adams@hotmail.com","vfnvfFlag":"vf postpaid","customerId":"21","contractId":"2134","circleId":"13","partyId":"14","accountId":"15","serviceFlag":"false","errorCode":"0","errorDescription":"success"}}}
			
			//VCareApi.getVFDataPlans(userProfile2);
			//{"grid":{"dataPlans":[{"planType":"Mobile Broadband","dataPackId":"VA101","dataPackName":"VA101","activationStartTime":"16-12-2011 01:09:11 PM","nextPeriodicActivity":"13-02-2012 11:59:59 PM","dataAllowance":0},{"planType":"Mobile Broadband","dataPackId":"VA201","dataPackName":"VA201","activationStartTime":"12-10-2011 01:09:11 PM","nextPeriodicActivity":"14-12-2012 11:59:59 PM","dataAllowance":0}]}}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
