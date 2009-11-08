package org.ieducnews.model;

import org.ieducnews.model.config.ModelProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebLinksTest {

	private static DomainModel domainModel;

	@BeforeClass
	public static void beforeTests() {
		ModelProperties modelProperties = new ModelProperties(
				WebLinksTest.class);
		domainModel = new DomainModel(modelProperties);
		domainModel = domainModel.load();
	}

	@Test
	public void webLinksOrderedByName() throws Exception {
		WebLinks webLinks = domainModel.getWebLinks();
		WebLinks orderedWebLinks = webLinks.orderByName();

		if (!webLinks.isEmpty()) {
			Assert.assertFalse(orderedWebLinks.isEmpty());
		}
		Assert.assertEquals(webLinks.size(), orderedWebLinks.size());
		Assert.assertNotSame(webLinks, orderedWebLinks);

		orderedWebLinks.output("---Web links ordered by name---");
	}

	@Test
	public void webLinksOrderedByDescendingName() throws Exception {
		WebLinks webLinks = domainModel.getWebLinks();
		WebLinks orderedWebLinks = webLinks.orderByName(false);

		if (!webLinks.isEmpty()) {
			Assert.assertFalse(orderedWebLinks.isEmpty());
		}
		Assert.assertEquals(webLinks.size(), orderedWebLinks.size());
		Assert.assertNotSame(webLinks, orderedWebLinks);

		orderedWebLinks.output("---Web links ordered by descending name---");
	}

	@Test
	public void webLinkNotRemoved() throws Exception {
		WebLinks webLinks = domainModel.getWebLinks();
		WebLink calendar = new WebLink();
		calendar.setName("Class Calendar");
		calendar
				.setLink("http://java.sun.com/javase/6/docs/api/java/util/Calendar.html");

		WebLink gregorianCalendar = new WebLink();
		gregorianCalendar.setName("Class GregorianCalendar");
		gregorianCalendar
				.setLink("http://java.sun.com/javase/6/docs/api/java/util/GregorianCalendar.html");

		webLinks.add(calendar);
		Assert.assertFalse(webLinks.remove(gregorianCalendar));
	}

	@Test
	public void webLinkRemoved() throws Exception {
		WebLinks webLinks = domainModel.getWebLinks();
		WebLink gregorianCalendar = new WebLink();
		gregorianCalendar.setName("Class GregorianCalendar");
		gregorianCalendar
				.setLink("http://java.sun.com/javase/6/docs/api/java/util/GregorianCalendar.html");

		webLinks.add(gregorianCalendar);
		Assert.assertTrue(webLinks.remove(gregorianCalendar));
	}

	@AfterClass
	public static void afterTests() {
		domainModel.save();
	}

}
