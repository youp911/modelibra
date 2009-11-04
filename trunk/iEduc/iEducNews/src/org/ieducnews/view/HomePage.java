package org.ieducnews.view;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.ieducnews.model.WebLink;
import org.ieducnews.model.WebLinks;

@SuppressWarnings("all")
public class HomePage extends BasePage {

	public HomePage() {
		WebApp webApp = (WebApp) getApplication();
		WebLinks webLinks = webApp.getDomainModel().getWebLinks();
		WebLinks orderedWebLinks = webLinks.orderByName();
		add(new WebLinksListView("webLinksList", orderedWebLinks.getList()));
	}

	private class WebLinksListView extends ListView {

		private WebLinksListView(String wicketId, List webLinks) {
			super(wicketId, webLinks);
		}

		protected void populateItem(ListItem listItem) {
			WebLink webLink = (WebLink) listItem.getModelObject();
			listItem.add(new ExternalLink("linkUrl", webLink.getLink(), webLink
					.getName()));
			listItem.add(new Label("linkLabel", webLink.getLink()));
		}
	}

}

