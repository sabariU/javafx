package com.fedex.avis.imrtesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class TestMain {
	
	public static void main(String[] args) {
		try {
			Properties props = new Properties();
			ClassLoader classLoader = TestMain.class.getClassLoader();
			//File file = new File(classLoader.getResource("IMR.properties").getFile());
			//InputStream stream = TestMain.class.getResourceAsStream("IMR.properties");
			
			//class
			
			//InputStream in = TestMain.class.getResourceAsStream("IMR.properties");
			
		//	props.load(in);
			System.out.println(props.getProperty("uat.jdbcURL"));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
