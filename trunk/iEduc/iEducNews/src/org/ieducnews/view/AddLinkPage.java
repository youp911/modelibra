package org.ieducnews.view;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.validator.UrlValidator;
import org.ieducnews.model.WebLink;
import org.ieducnews.model.WebLinks;

public class AddLinkPage extends BasePage {

	public AddLinkPage() {
		WebApp webApp = (WebApp) getApplication();
		WebLinks webLinks = webApp.getDomainModel().getWebLinks();
		WebLink webLink = new WebLink();

		Form<WebLink> form = new Form<WebLink>("form",
				new CompoundPropertyModel<WebLink>(webLink));
		RequiredTextField<String> nameField = new RequiredTextField<String>(
				"name");
		form.add(nameField);
		RequiredTextField<String> linkField = new RequiredTextField<String>(
				"link");
		linkField.add(new UrlValidator());
		form.add(linkField);
		form.add(new SaveButton("save", webApp, webLinks, webLink));
		add(form);
		add(new FeedbackPanel("feedback"));
	}

	private class SaveButton extends Button {

		private static final long serialVersionUID = 1;

		private WebApp webApp;

		private WebLinks webLinks;

		private WebLink webLink;

		private SaveButton(String wicketId, WebApp webApp, WebLinks webLinks,
				WebLink webLink) {
			super(wicketId);
			this.webApp = webApp;
			this.webLinks = webLinks;
			this.webLink = webLink;
		}

		@Override
		public void onSubmit() {
			if (webLinks.contains(webLink.getName())) {
				error("this name exists already.");
			} else {
				webLinks.add(webLink);
				webApp.getDomainModel().save();
				setResponsePage(new HomePage());
			}
		}
	}

}