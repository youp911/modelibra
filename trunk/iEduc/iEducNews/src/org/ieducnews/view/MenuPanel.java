package org.ieducnews.view;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class MenuPanel extends Panel{

	public MenuPanel(String id) {
		super(id);

		add(new BookmarkablePageLink("new", HomePage.class));
	}

}
