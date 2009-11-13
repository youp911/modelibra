package org.ieducnews.view.component;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.ieducnews.view.AboutPage;
import org.ieducnews.view.concept.weblink.AddLinkPage;

public class FooterPanel extends Panel {

	private static final long serialVersionUID = 1;

	public FooterPanel(String wicketId) {
		super(wicketId);
		add(new HomeLink("new"));
		add(new BookmarkablePageLink<WebPage>("about", AboutPage.class));
		add(new BookmarkablePageLink<WebPage>("submit", AddLinkPage.class));
	}

}
