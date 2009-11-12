package org.ieducnews.view.concept.member;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.convert.IConverter;
import org.ieducnews.model.concept.member.Member;
import org.ieducnews.model.type.Email;
import org.ieducnews.view.BasePage;
import org.ieducnews.view.HomePage;
import org.ieducnews.view.WebApp;
import org.ieducnews.view.WebAppSession;
import org.ieducnews.view.type.EmailConverter;

public class MemberPage extends BasePage {

	public MemberPage(final Member member) {
		Form<Member> form = new Form<Member>("form",
				new CompoundPropertyModel<Member>(member));
		form.add(new Label("account"));
		form.add(new PasswordTextField("password"));
		form.add(new Label("karma"));
		form.add(new TextField<String>("lastName"));
		form.add(new TextField<String>("firstName"));
		form.add(new EmailField("email", Email.class));
		form.add(new UpdateButton("update", (WebApp) getApplication()));
		add(form);
		add(new FeedbackPanel("feedback"));
		if (!isOwningMemberOrAdmin(member)) {
			/*
			 * passwordField.setVisible(false); lastNameField.setVisible(false);
			 * lastNameField.setVisible(false); firstName.setVisible(false);
			 * emailField.setVisible(false); button.setVisible(false);
			 */
		}
	}

	private boolean isOwningMemberOrAdmin(Member member) {
		WebAppSession webAppSession = (WebAppSession) getSession();
		if (webAppSession.isAuthenticated()) {
			if (webAppSession.getMember().equals(member)) {
				return true;
			}
			if (webAppSession.isAdmin()) {
				return true;
			}
		}
		return false;
	}

	private class EmailField extends TextField<Email> {

		private static final long serialVersionUID = 1;

		private EmailField(String wicketId, Class<Email> validationType) {
			super(wicketId, validationType);
		}

		public IConverter getConverter(final Class<?> type) {
			return new EmailConverter();
		}
	}

	private class UpdateButton extends Button {

		private static final long serialVersionUID = 1;

		private WebApp webApp;

		private UpdateButton(String wicketId, WebApp webApp) {
			super(wicketId);
			this.webApp = webApp;
		}

		@Override
		public void onSubmit() {
			webApp.getDomainModel().save();
			setResponsePage(HomePage.class);
		}
	}

}