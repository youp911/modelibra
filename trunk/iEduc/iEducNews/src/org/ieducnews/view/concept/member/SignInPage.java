package org.ieducnews.view.concept.member;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.ieducnews.model.concept.member.Member;
import org.ieducnews.model.concept.member.Members;
import org.ieducnews.model.concept.member.Member.SecurityRole;
import org.ieducnews.view.BasePage;
import org.ieducnews.view.WebApp;
import org.ieducnews.view.WebAppSession;

public final class SignInPage extends BasePage {

	public SignInPage() {
		add(new SignInForm("signIn"));
		add(new SignUpForm("signUp"));
		add(new FeedbackPanel("feedback"));
	}

	private abstract class SignForm extends StatelessForm<SignForm> {

		private static final long serialVersionUID = 1;

		private String account;

		private String password;

		private SignForm(String wicketId) {
			super(wicketId);
			setModel(new CompoundPropertyModel<SignForm>(this));
			add(new RequiredTextField<String>("account"));
			add(new PasswordTextField("password"));
		}

		String getAccount() {
			return account;
		}

		String getPassword() {
			return password;
		}

	}

	private final class SignInForm extends SignForm {

		private static final long serialVersionUID = 1;

		private SignInForm(String wicketId) {
			super(wicketId);
		}

		@Override
		public void onSubmit() {
			if (signIn(getAccount(), getPassword())) {
				if (!continueToOriginalDestination()) {
					setResponsePage(getApplication().getHomePage());
				}
			} else {
				error("Unknown username/password");
			}
		}

		private boolean signIn(String username, String password) {
			if (username != null && password != null) {
				WebApp webApp = (WebApp) getApplication();
				Members members = webApp.getDomainModel().getMembers();
				Member member = members.retrieveByAccount(username);
				if (member != null && member.isApproved()) {
					if (member.getPassword().equals(password)) {
						WebAppSession.get().setMember(member);
						return true;
					}
				}
			}
			return false;
		}
	}

	private final class SignUpForm extends SignForm {

		private static final long serialVersionUID = 1;

		private SignUpForm(String id) {
			super(id);
		}

		@Override
		public final void onSubmit() {
			if (signUp(getAccount(), getPassword())) {
				if (!continueToOriginalDestination()) {
					setResponsePage(new MemberPage(WebAppSession.get()
							.getMember()));
				}
			} else {
				error("This account exists already. Please choose another name.");
			}
		}

		private boolean signUp(String username, String password) {
			if (username != null && password != null) {
				WebApp webApp = (WebApp) getApplication();
				Members members = webApp.getDomainModel().getMembers();
				if (!members.contains(username)) {
					Member member = new Member();
					member.setAccount(username);
					member.setPassword(password);
					member.setRole(SecurityRole.REGULAR);
					member.setKarma(1);
					member.setApproved(true);
					members.add(member);
					webApp.getDomainModel().save();
					WebAppSession.get().setMember(member);
					return true;
				}
			}
			return false;
		}
	}

}