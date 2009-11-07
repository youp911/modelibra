package org.ieducnews.view;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

@SuppressWarnings("all")
public class FooterPanel extends Panel {

	public FooterPanel(String id) {
		super(id);
		add(new NewLink("newLink"));
		add(new BookmarkablePageLink("aboutLink", AboutPage.class));
	}

}
