package org.ieducnews.model;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class WebLinkTest {

	@Test
	public void webLinksCreated() throws Exception {
		WebLink webLink01 = new WebLink();
		webLink01.setName("Hacker News");
		webLink01.setLink("http://news.ycombinator.com/");

		WebLink webLink02 = new WebLink();
		webLink02.setName("TechCrunch");
		webLink02.setLink("http://www.techcrunch.com/");

		ArrayList webLinks = new ArrayList();
		webLinks.add(webLink01);
		webLinks.add(webLink02);

		Assert.assertTrue(webLinks.contains(webLink01));
		Assert.assertTrue(webLinks.contains(webLink02));
	}

	@Test
	public void webLinksTraversed() throws Exception {
		WebLink webLink01 = new WebLink();
		webLink01.setName("Hacker News");
		webLink01.setLink("http://news.ycombinator.com/");

		WebLink webLink02 = new WebLink();
		webLink02.setName("TechCrunch");
		webLink02.setLink("http://www.techcrunch.com/");

		ArrayList webLinks = new ArrayList();
		webLinks.add(webLink01);
		webLinks.add(webLink02);

		for (Object object : webLinks) {
			WebLink webLink = (WebLink) object;
			webLink.output();
		}
	}

	@Test
	public void webLinkFound() throws Exception {
		WebLink webLink01 = new WebLink();
		webLink01.setName("Hacker News");
		webLink01.setLink("http://news.ycombinator.com/");

		WebLink webLink02 = new WebLink();
		webLink02.setName("TechCrunch");
		webLink02.setLink("http://www.techcrunch.com/");

		ArrayList webLinks = new ArrayList();
		webLinks.add(webLink01);
		webLinks.add(webLink02);

		for (Object object : webLinks) {
			WebLink webLink = (WebLink) object;
			if (webLink.getName().equals("TechCrunch")) {
				webLink.output();
				Assert.assertTrue(webLinks.contains(webLink));
			}
		}
	}

	@Test
	public void webLinkNotFound() throws Exception {
		WebLink webLink01 = new WebLink();
		webLink01.setName("Hacker News");
		webLink01.setLink("http://news.ycombinator.com/");

		WebLink webLink02 = new WebLink();
		webLink02.setName("TechCrunch");
		webLink02.setLink("http://www.techcrunch.com/");

		ArrayList webLinks = new ArrayList();
		webLinks.add(webLink01);
		webLinks.add(webLink02);

		for (Object object : webLinks) {
			WebLink webLink = (WebLink) object;
			if (webLink.getName().equals("Modelibra")) {
				webLink.output();
			} else {
				System.out.println("Not Modelibra");
			}
		}

	}

	@Test
	public void webLinksIterator() throws Exception {
		WebLink webLink01 = new WebLink();
		webLink01.setName("Hacker News");
		webLink01.setLink("http://news.ycombinator.com/");

		WebLink webLink02 = new WebLink();
		webLink02.setName("TechCrunch");
		webLink02.setLink("http://www.techcrunch.com/");

		ArrayList webLinks = new ArrayList();
		webLinks.add(webLink01);
		webLinks.add(webLink02);

		Iterator iterator = webLinks.iterator();
		while (iterator.hasNext()) {
			WebLink webLink = (WebLink) iterator.next();
			webLink.output();
		}
	}

}
