package org.ieducnews.server;

import java.net.URL;

import org.ieducnews.util.PathLocator;
import org.mortbay.jetty.Server;

public class Start {

	public static final String CONFIG_FILE_NAME = "jetty-config.xml";

	private String locateJettyConfigPath() {
		PathLocator pathLocator = new PathLocator();
		return pathLocator.getClassBasedPath(Start.class, CONFIG_FILE_NAME);
	}

	public static void main(String[] args) {
		Start start = new Start();
		Server jettyServer = null;
		try {
			URL jettyConfig = new URL("file:" + start.locateJettyConfigPath());
			if (jettyConfig != null) {
				jettyServer = new Server(jettyConfig);
				jettyServer.start();
			}
		} catch (Exception e) {
			System.out.println("Could not start the Jetty server: " + e);
		}
	}

}
