package org.ieducnews.view;

import java.util.ArrayList;

import org.apache.wicket.protocol.http.WebApplication;
import org.ieducnews.model.WebLink;

@SuppressWarnings("all")
public class WebApp extends WebApplication {

	private ArrayList webLinks;

	public Class getHomePage() {
		return HomePage.class;
	}

	protected void init() {
		webLinks = new ArrayList();

		WebLink webLink01 = new WebLink();
		webLink01.setName("Hacker News");
		webLink01.setLink("http://news.ycombinator.com/");

		WebLink webLink02 = new WebLink();
		webLink02.setName("TechCrunch");
		webLink02.setLink("http://www.techcrunch.com/");

		webLinks.add(webLink01);
		webLinks.add(webLink02);
	}

	public ArrayList getWebLinks() {
		return webLinks;
	}

}
