package org.ieducnews.server;

import java.net.URL;

import org.ieducnews.util.PathLocator;
import org.mortbay.jetty.Server;

public class Start {

	public static final String CONFIG_FILE_NAME = "jetty-config.xml";

	public static void main(String[] args) {
		Server jettyServer = null;
		PathLocator pathLocator = new PathLocator();
		try {
			URL jettyConfig = new URL("file:"
					+ pathLocator.getClassBasedPath(Start.class,
							CONFIG_FILE_NAME));
			if (jettyConfig != null) {
				jettyServer = new Server(jettyConfig);
				jettyServer.start();
			}
		} catch (Exception e) {
			System.out.println("Could not start the Jetty server: " + e);
		}
	}

}
