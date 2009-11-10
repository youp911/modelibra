package org.ieducnews.view.concept.weblink;

import java.net.URL;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.convert.IConverter;
import org.ieducnews.model.concept.weblink.WebLink;
import org.ieducnews.model.concept.weblink.WebLinks;
import org.ieducnews.view.BasePage;
import org.ieducnews.view.HomePage;
import org.ieducnews.view.WebApp;
import org.ieducnews.view.type.UrlConverter;

public class AddLinkPage extends BasePage {

	public AddLinkPage() {
		WebApp webApp = (WebApp) getApplication();
		WebLinks webLinks = webApp.getDomainModel().getWebLinks();
		WebLink webLink = new WebLink();

		Form<WebLink> form = new Form<WebLink>("form",
				new CompoundPropertyModel<WebLink>(webLink));
		form.add(new RequiredTextField<String>("name"));
		form.add(new LinkField("link", URL.class));
		form.add(new SaveButton("save", webApp, webLinks, webLink));
		add(form);
		add(new FeedbackPanel("feedback"));
	}

	private class LinkField extends RequiredTextField<URL> {

		private static final long serialVersionUID = 1;

		private LinkField(String wicketId, Class<URL> validationType) {
			super(wicketId, validationType);
		}

		public IConverter getConverter(final Class<?> type) {
			return new UrlConverter();
		}
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