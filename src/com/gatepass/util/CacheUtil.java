package com.gatepass.util;

import java.util.List;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.ibm.json.java.OrderedJSONObject;

public class CacheUtil 
{
	private static Logger logger = LoggerFactory.getLogger(CacheUtil.class);	
	private static EhCacheCacheManager cacheManager;
	
	/**
	 * @param cacheManager the cacheManager to set
	 */
	public static void setCacheManager(EhCacheCacheManager cacheManager) {
		CacheUtil.cacheManager = cacheManager;
	}

	public static String populateCache(EhCacheCache ehCacheCache, Object value)
	{
		Ehcache springEhCache =  ehCacheCache.getNativeCache();
		List<Object> keyList =  springEhCache.getKeys();
		String newVersion = null;
		if(keyList != null)
		{
			newVersion = DateUtils.getCurrentDateTime("yyyyMMddHHmm");
			Element element = new Element("0", value);
			Element element2 = new Element(newVersion, value);
			if(keyList.size() == 0)
			{
				logger.info("No Keys available in cache!!");
			}
			else
			{
				logger.info("Keys available in cache!!");
				springEhCache.removeAll();
			}
			springEhCache.put(element);
			springEhCache.put(element2);
			
		}
		
		for (Object object : springEhCache.getKeys()) {
			logger.info("Key:"+springEhCache.get(object).getKey());
		}
		
		return newVersion;
	}
	
	
	public static void storeObjectByKey(final String cacheName, final String key, final Object obj)
	{
		// Store user profile in cache named 'VCareUsersCache'
		EhCacheCache vCareUsersCache = (EhCacheCache) cacheManager.getCache(cacheName);
		Ehcache springEhCache =  vCareUsersCache.getNativeCache();
		
		logger.info("List of existing keys:");
		List<Object> keyList =  springEhCache.getKeys();
		for (Object object : keyList) {
			logger.info("Key:"+springEhCache.get(object).getKey());
		}
		
		Element newObj = new Element(key, obj);
		springEhCache.put(newObj);

	}
	
	public static Object findObjectByKey(final String cacheName, final String key)
	{
		EhCacheCache vCareUsersCache = (EhCacheCache) cacheManager.getCache(cacheName);
		Ehcache springEhCache =  vCareUsersCache.getNativeCache();
		Element elem = springEhCache.get(key);//.getObjectValue();
		Object obj = elem != null ? elem.getObjectValue() : null;
		
		return obj;
	}
	
	public static String[] getUidMsisdnFromCache(String token)
	{
		String[] result = new String[2];
		logger.info("getUidMsisdnFromCache().........\ntoken:{}",token);
		
		try {
			/* Our Spring's EhCacheCacheManager returns object of type '<<interface>> org.springframework.cache.Cache'
			 * And since 'org.springframework.cache.ehcache.EhCacheCache' implements Cache & we know our underlying
			 * caching framework is EHCACHE, we can retrieve it as below. 
			 * @see http://ehcache.org/apidocs/
			 */
			EhCacheCache springEhCache = (EhCacheCache) cacheManager.getCache("VCareUsersCache");
			
			Ehcache ehCache =  springEhCache.getNativeCache();
			logger.info("Adding new token element in Cache named: "+ehCache.getName());
			List<Object> keyList =  ehCache.getKeys();
			logger.info("This Cache key size:"+keyList.size());
			Element element = ehCache.get(token);
			logger.info("Element with token:"+token+" \t is:"+element);
			if(element != null)
			{
				String objValue = element.getObjectValue().toString();
				logger.info(objValue);
				OrderedJSONObject orderedJSONObject = (OrderedJSONObject) OrderedJSONObject.parse(objValue);
				
				result[0] = (String) orderedJSONObject.get("uid");
				result[1] = (String) orderedJSONObject.get("msisdn");

			}
		} catch (IllegalStateException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (CacheException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		logger.info("Found in cache - uid:"+result[0]+"\tmsisdn:"+result[1]);
		
		return result;
	}
	
}
