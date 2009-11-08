package org.ieducnews.view;

import org.apache.wicket.markup.html.WebPage;
import org.ieducnews.view.navigation.FooterPanel;
import org.ieducnews.view.navigation.MenuPanel;

public abstract class BasePage extends WebPage {

	public BasePage() {
		add(new MenuPanel("menu"));
		add(new FooterPanel("footer"));
	}

}
