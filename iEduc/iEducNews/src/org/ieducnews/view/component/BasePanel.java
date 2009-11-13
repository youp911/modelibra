package org.ieducnews.view.component;

import org.apache.wicket.markup.html.panel.Panel;
import org.ieducnews.view.WebAppSession;

public class BasePanel extends Panel {

	private static final long serialVersionUID = 1;

	public BasePanel(String id) {
		super(id);
	}
	
	public WebAppSession getWebAppSession() {
		return (WebAppSession) getSession();
	}

}
