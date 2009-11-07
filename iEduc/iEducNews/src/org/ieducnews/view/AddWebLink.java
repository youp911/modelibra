package org.ieducnews.view;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.ieducnews.model.WebLink;
import org.ieducnews.model.WebLinks;

public class AddWebLink extends BasePage {
	
	public AddWebLink() {
		final WebApp webApp = (WebApp) getApplication();
		final WebLinks webLinks = webApp.getDomainModel().getWebLinks();
		final WebLink weblink = new WebLink();
		
		Form form = new Form("form");
		form.add(new RequiredTextField("name", new PropertyModel(weblink, "name")));
		form.add(new RequiredTextField("link", new PropertyModel(weblink, "link")));
		form.add(new Button("save"){
			@Override public void onSubmit(){			
				webLinks.add(weblink);
				webApp.getDomainModel().save();
				setResponsePage(new HomePage());
			}
		});
		add (form);
		add(new FeedbackPanel("feedback"));
	}
	
}