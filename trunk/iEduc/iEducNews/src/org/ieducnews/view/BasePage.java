package org.ieducnews.view;

import org.apache.wicket.markup.html.WebPage;

public abstract class BasePage extends WebPage {

	public BasePage() {
		add(new MenuPanel("menuPanel"));
		add(new FooterPanel("footerPanel"));
	}

}
