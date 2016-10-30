package me.lifetime.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Config {
	private static final Logger log = Logger.getLogger(Config.class);
	
	private static Properties prop;
	
	static {
		 try {  
			 Resource res = new ClassPathResource("lifetime.properties");   
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
