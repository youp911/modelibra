package org.ieducnews.view;

import org.apache.wicket.markup.html.WebPage;
import org.ieducnews.view.component.FooterPanel;
import org.ieducnews.view.component.MenuMemberPanel;
import org.ieducnews.view.component.MenuPanel;

public abstract class BasePage extends WebPage {

	public BasePage() {
		add(new MenuPanel("menu"));
		add(new FooterPanel("footer"));
		add(new MenuMemberPanel("member"));
	}

}
