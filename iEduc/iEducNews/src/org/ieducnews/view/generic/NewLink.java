package org.ieducnews.view.generic;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.ieducnews.view.HomePage;

public class NewLink extends Link<WebPage> {

	private static final long serialVersionUID = 1;

	public NewLink(String wicketId) {
		super(wicketId);
	}

	@Override
	public void onClick() {
		setResponsePage(new HomePage());
	}

}
