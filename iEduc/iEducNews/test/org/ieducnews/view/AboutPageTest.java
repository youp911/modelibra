package org.ieducnews.view;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.WicketTester;
import org.ieducnews.view.staticpages.AboutPage;
import org.junit.BeforeClass;
import org.junit.Test;

public class AboutPageTest {

	private static WicketTester tester;

	@BeforeClass
	public static void beforeTests() {
		tester = new WicketTester(new WebApp());
		tester.startPage(AboutPage.class);
	}

	@Test
	public void containComponents() {
		tester.assertComponent("menu", Panel.class);
		tester.assertComponent("footer", Panel.class);
	}

}
