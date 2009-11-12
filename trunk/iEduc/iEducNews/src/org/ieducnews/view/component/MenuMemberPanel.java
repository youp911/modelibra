package org.ieducnews.view.component;

import org.apache.wicket.markup.html.panel.Panel;
import org.ieducnews.view.component.HomeLink;

public class MenuMemberPanel extends Panel {

	private static final long serialVersionUID = 1;

	public MenuMemberPanel(String id) {
		super(id);
		add(new SignInLink("signin"));
	}

}