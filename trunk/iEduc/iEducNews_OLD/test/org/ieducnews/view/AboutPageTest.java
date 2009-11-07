package org.ieducnews.view;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.BeforeClass;
import org.junit.Test;

public class AboutPageTest {

	private static WicketTester tester;

	@BeforeClass
	public static void prepareTester() {
		tester = new WicketTester(new WebApp());
		tester.startPage(AboutPage.class);
	}

	@Test
	public void containComponents() {
		tester.assertComponent("menuPanel", Panel.class);
		tester.assertComponent("footerPanel", Panel.class);
	}

}
