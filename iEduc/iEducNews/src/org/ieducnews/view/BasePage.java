package org.ieducnews.view;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.ieducnews.model.WebLink;

@SuppressWarnings("all")
public class BasePage extends WebPage {

	public BasePage() {
		add(new MenuPanel("menuPanel"));
		add(new FooterPanel("footerPanel"));
	}

}

