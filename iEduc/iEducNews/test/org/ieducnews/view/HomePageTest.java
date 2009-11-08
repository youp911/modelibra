package org.ieducnews.view;

import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.BeforeClass;
import org.junit.Test;

public class HomePageTest {

	private static WicketTester tester;

	@BeforeClass
	public static void beforeTests() {
		tester = new WicketTester(new WebApp());
		tester.startPage(HomePage.class);
	}

	@Test
	public void containComponents() {
		tester.assertComponent("menu", Panel.class);
		tester.assertComponent("webLinks", PageableListView.class);
		tester.assertComponent("navigator", PagingNavigator.class);
		tester.assertComponent("footer", Panel.class);
	}

}
