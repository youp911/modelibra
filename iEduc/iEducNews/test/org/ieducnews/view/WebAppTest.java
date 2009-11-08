package org.ieducnews.view;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebAppTest {

	private static WicketTester tester;

	private static WebApplication app;

	@BeforeClass
	public static void beforeTests() {
		app = new WebApp();
		tester = new WicketTester(app);
	}

	@Test
	public void defineHomePage() throws Exception {
		Assert.assertEquals(HomePage.class, app.getHomePage());
	}

	@Test
	public void renderHomePage() {
		tester.startPage(HomePage.class);
		tester.assertRenderedPage(HomePage.class);
		tester.assertNoErrorMessage();
	}

}
