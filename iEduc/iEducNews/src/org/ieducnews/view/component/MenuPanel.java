package org.ieducnews.view.component;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.ieducnews.view.AboutPage;
import org.ieducnews.view.concept.contribution.AddSubmissionPage;

public class MenuPanel extends Panel {

	private static final long serialVersionUID = 1;

	public MenuPanel(String wicketId) {
		super(wicketId);
		add(new HomeLink("new"));
		add(new BookmarkablePageLink<WebPage>("submit", AddSubmissionPage.class));
		add(new BookmarkablePageLink<WebPage>("about", AboutPage.class));
	}

}
