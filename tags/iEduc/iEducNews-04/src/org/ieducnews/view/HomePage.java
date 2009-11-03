package org.ieducnews.view;

import java.util.ArrayList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.ieducnews.model.WebLink;

@SuppressWarnings("all")
public class HomePage extends WebPage {

	public HomePage() {
		WebApp webApp = (WebApp) getApplication();
		ArrayList webLinks = webApp.getWebLinks();
		WebLinksListView webLinksListView = new WebLinksListView("webLinks",
				webLinks);
		add(webLinksListView);
	}

	private class WebLinksListView extends ListView {

		private WebLinksListView(String wicketId, ArrayList webLinks) {
			super(wicketId, webLinks);
		}

		protected void populateItem(ListItem listItem) {
			WebLink webLink = (WebLink) listItem.getModelObject();
			ExternalLink linkUrl = new ExternalLink("linkUrl", webLink
					.getLink(), webLink.getName());
			listItem.add(linkUrl);
			Label linkLabel = new Label("linkLabel", webLink.getLink());
			listItem.add(linkLabel);
		}
	}

}
