package org.ieducnews.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebLinksTest {

	private static DomainModel domainModel;

	@BeforeClass
	public static void createModel() {
		domainModel = new DomainModel();
	}

	@Test
	public void webLinksCreated() throws Exception {
		WebLinks webLinks = domainModel.getWebLinks();

		WebLink webLink01 = new WebLink();
		webLink01.setName("TechCrunch");
		webLink01.setLink("http://www.techcrunch.com/");

		WebLink webLink02 = new WebLink();
		webLink02.setName("Hacker News");
		webLink02.setLink("http://news.ycombinator.com/");

		webLinks.add(webLink01);
		webLinks.add(webLink02);

		Assert.assertTrue(webLinks.contains(webLink01));
		Assert.assertTrue(webLinks.contains(webLink02));

		Assert.assertEquals(7, webLinks.size());
	}

	@Test
	public void webLinksOrdered() throws Exception {
		WebLinks webLinks = domainModel.getWebLinks();
		WebLinks orderedWebLinks = webLinks.orderByName();

		Assert.assertFalse(orderedWebLinks.isEmpty());
		Assert.assertEquals(webLinks.size(), orderedWebLinks.size());
		Assert.assertNotSame(webLinks, orderedWebLinks);

		orderedWebLinks.output("---Web links ordered by name---");
	}

}
