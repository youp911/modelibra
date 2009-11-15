package org.ieducnews.model.concept.weblink;

import java.net.URL;
import java.util.Date;

import org.ieducnews.model.DomainModel;
import org.ieducnews.model.concept.contribution.Submission;
import org.ieducnews.model.concept.contribution.Submissions;
import org.ieducnews.model.concept.contribution.WebLink;
import org.ieducnews.model.config.ModelProperties;
import org.ieducnews.model.type.EasyDate;
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
	public void orderWebLinksByName() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		Submissions orderedWebLinks = webLinks.orderByName();

		if (!webLinks.isEmpty()) {
			Assert.assertFalse(orderedWebLinks.isEmpty());
		}
		Assert.assertEquals(webLinks.size(), orderedWebLinks.size());
		Assert.assertNotSame(webLinks, orderedWebLinks);

		orderedWebLinks.output("---Web links ordered by name---");
	}

	@Test
	public void orderWebLinksByDescendingName() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		Submissions orderedWebLinks = webLinks.orderByName(false);

		if (!webLinks.isEmpty()) {
			Assert.assertFalse(orderedWebLinks.isEmpty());
		}
		Assert.assertEquals(webLinks.size(), orderedWebLinks.size());
		Assert.assertNotSame(webLinks, orderedWebLinks);

		orderedWebLinks.output("---Web links ordered by descending name---");
	}

	@Test
	public void orderWebLinksByCreationDate() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		Submissions orderedWebLinks = webLinks.orderByCreationDate();

		if (!webLinks.isEmpty()) {
			Assert.assertFalse(orderedWebLinks.isEmpty());
		}
		Assert.assertEquals(webLinks.size(), orderedWebLinks.size());
		Assert.assertNotSame(webLinks, orderedWebLinks);

		orderedWebLinks.output("---Web links ordered by creation date---");
	}

	@Test
	public void retrieveWebLinkByName() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		String expectedName = "Hacker News";
		Submission webLink = webLinks.retrieveByName(expectedName);
		if (webLink != null) {
			Assert.assertEquals(expectedName, webLink.getName());
		}
	}

	@Test
	public void webLinkNotRetrievedByName() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		String expectedName = "Educ News";
		boolean containCheck = webLinks.contains(expectedName);
		if (!containCheck) {
			Submission webLink = webLinks.retrieveByName(expectedName);
			Assert.assertNull(webLink);
		}
	}

	@Test
	public void validateWebLinkForNullName() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		WebLink webLink = new WebLink();
		Assert.assertFalse(webLinks.add(webLink));
		Assert.assertFalse(webLinks.contains(webLink));
	}

	@Test
	public void validateWebLinkForUniqueName() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		String expectedName = "Hacker News";
		Submission webLink = webLinks.retrieveByName(expectedName);
		if (webLink != null) {
			WebLink anotherLink = new WebLink();
			anotherLink.setName("Hacker News");
			Assert.assertFalse(webLinks.add(anotherLink));
			Assert.assertFalse(webLinks.contains(anotherLink));
		}
	}

	@Test
	public void selectWebLinksCreatedToday() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		Date selectionDate = new Date();
		Submissions selectedWebLinks = webLinks.selectByDate(selectionDate);

		System.out.println("selection date: " + selectionDate);
		EasyDate selectionEasyDate = new EasyDate(selectionDate);
		System.out.println("selection easy date: " + selectionEasyDate);
		selectedWebLinks.output("---Selected web links---");
	}

	@Test
	public void webLinkNotRemoved() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		WebLink calendar = new WebLink();
		calendar.setName("Class Calendar");
		calendar
				.setLink(new URL(
						"http://java.sun.com/javase/6/docs/api/java/util/Calendar.html"));

		WebLink gregorianCalendar = new WebLink();
		gregorianCalendar.setName("Class GregorianCalendar");
		gregorianCalendar
				.setLink(new URL(
						"http://java.sun.com/javase/6/docs/api/java/util/GregorianCalendar.html"));

		webLinks.add(calendar);
		Assert.assertFalse(webLinks.remove(gregorianCalendar));
	}

	@Test
	public void removeWebLink() throws Exception {
		Submissions webLinks = domainModel.getSubmissions();
		WebLink gregorianCalendar = new WebLink();
		gregorianCalendar.setName("Class GregorianCalendar");
		gregorianCalendar
				.setLink(new URL(
						"http://java.sun.com/javase/6/docs/api/java/util/GregorianCalendar.html"));

		webLinks.add(gregorianCalendar);
		Assert.assertTrue(webLinks.remove(gregorianCalendar));
	}

	@AfterClass
	public static void afterTests() {
		domainModel.save();
	}

}
