package org.ieducnews.server;

import java.util.Properties;

import org.ieducnews.util.PropertiesLoader;

public class ConfigProperties {

	public static final String CONFIG_PROPERTIES_FILE_NAME = "config.properties";

	public static final String JETTY_CONFIG_PATH_KEY = "jetty-config-path";

	private Properties properties;

	public ConfigProperties(Class<?> claz) {
		PropertiesLoader propertiesLoader = new PropertiesLoader();
		properties = propertiesLoader.load(claz, CONFIG_PROPERTIES_FILE_NAME);
	}

	public String getJettyConfigPath() {
		return properties.getProperty(JETTY_CONFIG_PATH_KEY);
	}

}
