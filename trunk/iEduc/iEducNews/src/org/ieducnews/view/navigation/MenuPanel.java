package org.ieducnews.view.navigation;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.ieducnews.view.generic.HomeLink;
import org.ieducnews.view.staticpages.AboutPage;
import org.ieducnews.view.weblink.AddLinkPage;

public class MenuPanel extends Panel {

	private static final long serialVersionUID = 1;

	public MenuPanel(String id) {
		super(id);
		add(new HomeLink("new"));
		add(new BookmarkablePageLink<WebPage>("submit", AddLinkPage.class));
		add(new BookmarkablePageLink<WebPage>("about", AboutPage.class));
	}

}
