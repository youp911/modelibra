package org.ieducnews.view;

import java.util.List;

import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.ieducnews.model.concept.weblink.WebLink;
import org.ieducnews.model.concept.weblink.WebLinks;

public class HomePage extends BasePage {

	public static final int NUMBER_OF_LINKS_ON_ONE_PAGE = 16;

	public HomePage() {
		WebLinks webLinks = getWebApp().getDomainModel().getWebLinks();
		WebLinks orderedWebLinks = webLinks.orderByName();
		WebLinksListView listView = new WebLinksListView("webLinks",
				orderedWebLinks.getList());
		add(listView);
		PagingNavigator pagingNavigator = new PagingNavigator("navigator",
				listView);
		if (orderedWebLinks.size() <= NUMBER_OF_LINKS_ON_ONE_PAGE) {
			pagingNavigator.setVisible(false);
		}
		add(pagingNavigator);
	}

	private class WebLinksListView extends PageableListView<WebLink> {

		private static final long serialVersionUID = 1;

		private WebLinksListView(String wicketId, List<WebLink> webLinks) {
			super(wicketId, webLinks, NUMBER_OF_LINKS_ON_ONE_PAGE);
		}

		protected void populateItem(ListItem<WebLink> listItem) {
			WebLink webLink = listItem.getModelObject();
			listItem.add(new ExternalLink("linkUrl", webLink.getLink()
					.toString(), webLink.getName()));
			listItem.add(new Label("linkLabel", webLink.getLink().toString()));
			listItem.add(new RemoveLink("removeLink", webLink));
		}
	}

	private class RemoveLink extends Link<WebLink> {

		private static final long serialVersionUID = 1;

		private WebLink webLink;

		private RemoveLink(String wicketId, WebLink webLink) {
			super(wicketId);
			this.webLink = webLink;
			add(new SimpleAttributeModifier("onclick",
					"return confirm('Are you sure you want to remove this link?');"));
		}

		@Override
		public void onClick() {
			WebApp webApp = (WebApp) getApplication();
			WebLinks webLinks = webApp.getDomainModel().getWebLinks();
			if (webLinks.contains(webLink)) {
				webLinks.remove(webLink);
				webApp.getDomainModel().save();
			}
			setResponsePage(HomePage.class);
		}

		@Override
		public boolean isVisible() {
			if (getWebAppSession().isAuthenticated()) {
				return getWebAppSession().isAdmin();
			}
			return false;
		}
	}

}
