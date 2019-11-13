
package com.jboss.classloadingtest;

import java.io.InputStream;
import java.util.Properties;

final public class Util {
	
	private Properties settings;
	private static Util instance;
	
	public String getMsg(String msgID) {
		return settings.getProperty(msgID);
	}


	public static synchronized Util getInstance()
	{
		while (instance == null)
		{
			instance = new Util();
		}
		return instance;
	}

	
	private Util()
	{
		try
		{
		InputStream settingsStream = this.getClass().getClassLoader().getResourceAsStream("settings.properties");
		settings = new Properties();
		settings.load(settingsStream);
		System.out.println("Properties loaded from settings.properties");
		settings.list(System.out);
		
		}
		catch (Exception ex)
		{
			System.err.println(ex);
		}
	}
}
