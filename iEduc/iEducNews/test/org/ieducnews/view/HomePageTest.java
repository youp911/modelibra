package org.ieducnews.view;

import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.BeforeClass;
import org.junit.Test;

public class HomePageTest {

	private static WicketTester tester;

	@BeforeClass
	public static void prepareTester() {
		tester = new WicketTester(new WebApp());
		tester.startPage(HomePage.class);
	}

	@Test
	public void containComponents() {
		tester.assertComponent("menu", Panel.class);
		tester.assertComponent("webLinks", ListView.class);
		tester.assertComponent("footer", Panel.class);
	}

}
