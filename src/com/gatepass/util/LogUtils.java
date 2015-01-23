package com.gatepass.util;


/**
 * @author Afshar Ahmed
 *
 */
public class LogUtils 
{
	public static String constructLog( String apiName, String msisdn, String token, 
										String resolution, String clientVariant, String uid, String folderId, 
										String folderVersion, String menuVersion, String cssVersion )
	{
		StringBuffer b = new StringBuffer();
		b.append(apiName != null ? apiName : " - ");
		b.append(" | ");b.append(msisdn != null ? msisdn : " - ");
		b.append(" | ");b.append(token != null ? token : " - ");
		b.append(" | ");b.append(resolution != null ? resolution : " - ");
		b.append(" | ");b.append(clientVariant != null ? clientVariant : " - ");
		b.append(" | ");b.append(uid != null ? uid : " - ");
		b.append(" | ");b.append(folderId != null ? folderId : " - ");
		b.append(" | ");b.append(folderVersion != null ? folderVersion : " - ");
		b.append(" | ");b.append(menuVersion != null ? menuVersion : " - ");
		b.append(" | ");b.append(cssVersion != null ? cssVersion : " - ");
		b.append(" | ");
		
		return b.toString();
	}

}
