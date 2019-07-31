package com.test.assignment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Token {

	public static String getTooken() throws IOException
	{
		String token = null;
		FileReader reader=new FileReader("config.properties");
		Properties p=new Properties();
		p.load(reader);
		token=p.getProperty("token");
		return token;
	}
	
}
