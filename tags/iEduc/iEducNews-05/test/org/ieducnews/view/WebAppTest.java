package org.ieducnews.view;

import static org.junit.Assert.assertEquals;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebAppTest {

	private static WicketTester tester;

	private static WebApplication app;

	@BeforeClass
	public static void prepareTester() {
		app = new WebApp();
		tester = new WicketTester(app);
	}

	@Test
	public void defineHomePage() throws Exception {
		assertEquals(HomePage.class, app.getHomePage());
	}

	@Test
	public void renderHomePage() {
		tester.startPage(HomePage.class);
		tester.assertRenderedPage(HomePage.class);
		tester.assertNoErrorMessage();
	}

}
