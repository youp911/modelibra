package org.ieducnews.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesLoader {

	public Properties load(Class<?> referenceClass, String fileName) {
		Properties properties = new Properties();
		URL configUrl = referenceClass.getResource(fileName);
		if (configUrl != null) {
			try {
				InputStream inputStream = configUrl.openStream();
				properties.clear();
				properties.load(inputStream);
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return properties;
	}

}
