package org.ieducnews.view;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class MenuPanel extends Panel {

	private static final long serialVersionUID = 1;

	public MenuPanel(String id) {
		super(id);
		add(new NewLink("newLink"));
		add(new BookmarkablePageLink<WebPage>("aboutLink", AboutPage.class));
		add(new BookmarkablePageLink<WebPage>("submit", AddWebLink.class));
	}

}
