package org.ieducnews.view;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.WicketTester;
import org.ieducnews.model.DomainModel;
import org.ieducnews.model.config.ModelProperties;
import org.ieducnews.view.staticpages.AboutPage;
import org.ieducnews.view.weblink.AddLinkPage;
import org.junit.BeforeClass;
import org.junit.Test;

public class HomePageTest {

	private static WicketTester tester;

	@BeforeClass
	public static void beforeTests() {
		ModelProperties modelProperties = new ModelProperties(
				AboutPageTest.class);
		DomainModel domainModel = new DomainModel(modelProperties);
		domainModel = domainModel.load();

		WebApp webApp = new WebApp();
		webApp.setDomainModel(domainModel);

		tester = new WicketTester(webApp);
		tester.startPage(HomePage.class);
	}

	@Test
	public void containComponents() {
		tester.assertComponent("menu", Panel.class);
		tester.assertComponent("menu:new", Link.class);
		tester.assertComponent("menu:submit", BookmarkablePageLink.class);
		tester.assertComponent("menu:about", BookmarkablePageLink.class);
		tester.assertComponent("webLinks", PageableListView.class);
		tester.assertComponent("navigator", PagingNavigator.class);
		tester.assertComponent("footer", Panel.class);
		tester.assertComponent("footer:new", Link.class);
		tester.assertComponent("footer:submit", BookmarkablePageLink.class);
		tester.assertComponent("footer:about", BookmarkablePageLink.class);
	}

	@Test
	public void navigateToHome() {
		tester.clickLink("menu:new");
		tester.assertRenderedPage(HomePage.class);
	}

	@Test
	public void navigateToSubmitLink() {
		tester.clickLink("menu:submit");
		tester.assertRenderedPage(AddLinkPage.class);
	}

	@Test
	public void navigateToAbout() {
		tester.clickLink("menu:about");
		tester.assertRenderedPage(AboutPage.class);
	}

}
