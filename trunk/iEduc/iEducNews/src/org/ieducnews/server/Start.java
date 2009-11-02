package org.ieducnews.server;

import java.net.URL;

import org.mortbay.jetty.Server;

public class Start {

	public static final String CONFIG_FILE_NAME = "jetty-config.xml";

	public static void main(String[] args) {
		Server jettyServer = null;
		try {
			URL jettyConfig = Start.class.getResource(CONFIG_FILE_NAME);
			if (jettyConfig != null) {
				jettyServer = new Server(jettyConfig);
				jettyServer.start();
			}
		} catch (Exception e) {
			System.out.println("Could not start the Jetty server: " + e);
		}
	}

}
