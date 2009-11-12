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

public class SignInPage extends BasePage {

	public SignInPage() {
		add(new SignInForm("signInForm"));
		add(new SignUpForm("signUpForm"));
		add(new FeedbackPanel("feedback"));
	}

	private static class SignInForm extends StatelessForm {

		private String entryPassword;

		private String entryAccount;

		public SignInForm(final String id) {
			super(id);
			setModel(new CompoundPropertyModel(this));
			add(new RequiredTextField("account"));
			add(new PasswordTextField("password"));
		}

		public String getPassword() {
			return entryPassword;
		}

		public String getAccount() {
			return entryAccount;
		}

		@Override
		public final void onSubmit() {
			if (signIn(entryAccount, entryPassword)) {
				if (!continueToOriginalDestination()) {
					setResponsePage(getApplication().getHomePage());
				}
			} else {
				error("Unknown username/password");
			}
		}

		public void setPassword(String password) {
			this.entryPassword = password;
		}

		public void setAccount(String account) {
			this.entryAccount = account;
		}

		private boolean signIn(String username, String password) {
			if (username != null && password != null) {
				WebApp webApp = (WebApp) getApplication();
				Members members = webApp.getDomainModel().getMembers();
				Member member = members.retrieveByAccount(username);
				if (member != null) {
					if (member.getPassword().equals(password)) {
						WebAppSession.get().setMember(member);
						return true;
					}
				}
			}
			return false;
		}
	}

	private static class SignUpForm extends StatelessForm {

		private String entryPassword;

		private String entryAccount;

		public SignUpForm(final String id) {
			super(id);
			setModel(new CompoundPropertyModel(this));
			add(new RequiredTextField("account"));
			add(new PasswordTextField("password"));
		}

		public String getPassword() {
			return entryPassword;
		}

		public String getAccount() {
			return entryAccount;
		}

		@Override
		public final void onSubmit() {
			if (signUp(entryAccount, entryPassword)) {
				if (!continueToOriginalDestination()) {
					setResponsePage(new MemberPage(WebAppSession.get()
							.getMember()));
				}
			} else {
				error("This account name already exist. Please choose another one.");
			}
		}

		public void setPassword(String password) {
			this.entryPassword = password;
		}

		public void setAccount(String account) {
			this.entryAccount = account;
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