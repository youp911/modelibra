package org.ieducnews;

import java.util.ArrayList;

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

}
