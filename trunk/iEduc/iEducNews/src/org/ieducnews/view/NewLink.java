package org.ieducnews.view;

import org.apache.wicket.markup.html.link.Link;

@SuppressWarnings("all")
public class NewLink extends Link {

	public NewLink(String wicketId) {
		super(wicketId);
	}

	@Override
	public void onClick() {
		setResponsePage(new HomePage());
	}

}
