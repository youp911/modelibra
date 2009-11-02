package org.ieducnews.server;

import java.net.URL;

import org.mortbay.jetty.Server;

public class Start {

	private String findJettyConfigPath() {
		ConfigProperties configProperties = new ConfigProperties(Start.class);
		return configProperties.getJettyConfigPath();
	}

	public static void main(String[] args) {
		Start start = new Start();
		Server jettyServer = null;
		try {
			URL jettyConfig = new URL("file:" + start.findJettyConfigPath());
			if (jettyConfig != null) {
				jettyServer = new Server(jettyConfig);
				jettyServer.start();
			}
		} catch (Exception e) {
			System.out.println("Could not start the Jetty server: " + e);
		}
	}

}
