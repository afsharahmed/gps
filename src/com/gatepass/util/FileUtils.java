package com.gatepass.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author afshar.ahmed
 *
 */
public class FileUtils 
{
	
	// 
	public static String getLocalResourceAsStream(final String resourcePath)
	{
		String data = null;
		StringBuilder sb;

		try 
		{
			// Retrieving input-stream of file (resource) pointed using a path, relative to FolderManagerImpl. 
			InputStream inputStream = FileUtils.class.getResourceAsStream(resourcePath);
			
			// Read it with BufferedReader
			BufferedReader br = new BufferedReader( new InputStreamReader(inputStream) );
			sb = new StringBuilder();
 
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			} 
			
			// Closing BufferedReader
			br.close();
			
			data = sb.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
  		
		return data;
	}
	
}
