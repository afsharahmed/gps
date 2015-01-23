package com.gatepass.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author afshar.ahmed
 *
 */
public class VCareHttpConnection 
{
	private static Logger logger = LoggerFactory.getLogger(VCareHttpConnection.class);

	public static String send(final String targetUrl, String paramString)
	{
		String charset = "UTF-8";
		StringBuffer sb = new StringBuffer();
		try 
		{
			URLConnection connection = new URL(targetUrl).openConnection();
			connection.setDoOutput(true); // Triggers POST.
			connection.setRequestProperty("Accept-Charset", charset);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
			
			OutputStream output = null;
			try 
			{
			     output = connection.getOutputStream();
			     output.write(paramString.getBytes(charset));
			     logger.info("Data sent.");
			} 
			finally {
			     if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
			}
			
			InputStream response = connection.getInputStream();
			BufferedReader in = new BufferedReader( new InputStreamReader(response));

			String inputLine = null;
			

			while ((inputLine = in.readLine()) != null) 
			{
				sb.append(inputLine);
			}

			in.close();
		} 
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String getDataOverHttpConnection(final String targetUrl)
	{
		InputStream is = null;
		StringBuffer inputBuffer = new StringBuffer();
		try
		{
			URL urlObject = new URL(targetUrl); // pointer to a resource in the internet
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlObject.openConnection();
			
			// Specifying that we intend to use this connection for output
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setConnectTimeout(50000);
			httpURLConnection.setRequestMethod("GET");

			// Prepare a reader to read the response from the URLConnection throws IOException
			is = httpURLConnection.getInputStream();
			BufferedReader in = new BufferedReader( new InputStreamReader(is));

			String inputLine = null;
			while ((inputLine = in.readLine()) != null) inputBuffer.append(inputLine);

			in.close();
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
				
		return inputBuffer.toString();
	}
	
	
	
}
