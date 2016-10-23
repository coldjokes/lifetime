package me.lifetime.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 所有chat输出
 *
 */
public class Messages {
	
	private static final Logger log = Logger.getLogger(Messages.class);
	
	private static Properties prop;
	
	static {
		 try {  
			 Resource res = new ClassPathResource("message.properties");   
			 //指定文件资源对应的编码格式（UTF-8）  
			 EncodedResource encRes = new EncodedResource(res,"UTF-8"); 
			 prop =PropertiesLoaderUtils.loadProperties(encRes);
		 } catch (IOException e) {  
			 log.error("Read message.properties failed", e);
		 }  
	}
	
	public static String get(String key){
		return prop.getProperty(key);
	}
}


