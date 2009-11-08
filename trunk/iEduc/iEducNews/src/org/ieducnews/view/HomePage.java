package org.ieducnews.view;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.ieducnews.model.WebLink;
import org.ieducnews.model.WebLinks;

public class HomePage extends BasePage {

	public HomePage() {
		WebApp webApp = (WebApp) getApplication();
		WebLinks webLinks = webApp.getDomainModel().getWebLinks();
		WebLinks orderedWebLinks = webLinks.orderByName();
		WebLinksListView listView = new WebLinksListView("webLinks",
				orderedWebLinks.getList());
		add(listView);
		add(new PagingNavigator("navigator", listView));
	}

	private class WebLinksListView extends PageableListView<WebLink> {

		private static final long serialVersionUID = 1;

		private WebLinksListView(String wicketId, List<WebLink> webLinks) {
			super(wicketId, webLinks, 16);
		}

		protected void populateItem(ListItem<WebLink> listItem) {
			WebLink webLink = listItem.getModelObject();
			listItem.add(new ExternalLink("linkUrl", webLink.getLink(), webLink
					.getName()));
			listItem.add(new Label("linkLabel", webLink.getLink()));
		}
	}

}
