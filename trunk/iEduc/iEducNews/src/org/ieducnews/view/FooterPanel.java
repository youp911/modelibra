package org.ieducnews.view;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class FooterPanel extends Panel {

	private static final long serialVersionUID = 1;

	public FooterPanel(String id) {
		super(id);
		add(new NewLink("new"));
		add(new BookmarkablePageLink<WebPage>("about", AboutPage.class));
		add(new BookmarkablePageLink<WebPage>("submit", AddLinkPage.class));
	}

}
