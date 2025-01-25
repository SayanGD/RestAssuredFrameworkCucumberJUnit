package com.map.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader
{
	Properties properties;
	public PropertyReader() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties");
		properties=new Properties();
		properties.load(fis);
	}

	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}
}