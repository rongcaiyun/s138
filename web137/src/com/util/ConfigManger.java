package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 使用单例模式，并且创建了Properties对象，用来读取db.properties文件
 * @author Administrator
 *
 */
public class ConfigManger {
	private static ConfigManger configManager;
	private static Properties properties;//读取db.properties文件
	private ConfigManger(){
		String configFile="db.properties";
		properties=new Properties();
		InputStream in=ConfigManger.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ConfigManger getInstance(){
		if(configManager==null){
			configManager=new ConfigManger();
		}
		return configManager;
	}
	public String getString(String key) {
		// TODO Auto-generated method stub
		return properties.getProperty(key);
	}
	
}
