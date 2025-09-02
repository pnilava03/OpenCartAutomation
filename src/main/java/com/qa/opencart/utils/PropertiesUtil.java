package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	Properties properties = new Properties();

	public PropertiesUtil() {
		try {
			properties.load(new FileInputStream("./src/test/resources/config/config.properties"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String getPropertiesValue(String key) {

		return properties.getProperty(key);

	}

}
