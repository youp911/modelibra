package org.ieducnews.view.component;

import java.io.Serializable;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.ieducnews.model.concept.weblink.WebLink;
import org.ieducnews.model.concept.weblink.WebLinks;
import org.ieducnews.view.HomePage;
import org.ieducnews.view.WebApp;
import org.ieducnews.view.WebAppSession;
import org.ieducnews.view.concept.member.MemberPage;

public class MenuMemberPanel extends Panel {

	private static final long serialVersionUID = 1;

	public MenuMemberPanel(String id) {
		super(id);
				
		SignInLink signInLink = new SignInLink("signin");
		signInLink.setVisible(!WebAppSession.get().isAuthenticated());	
		add(signInLink);
		
		add(new AccountLink("member"));
		
		add(new SignOutLink("signout"));
	}

	
	private class AccountLink extends Link {
		private static final long serialVersionUID = 1;
		
		private AccountLink(String wicketId) {
			super(wicketId);
			String accountName = null;
			if (WebAppSession.get().isAuthenticated()) accountName=WebAppSession.get().getMember().getAccount();
			add(new Label("account",accountName));
		}

		@Override
		public void onClick() {
			setResponsePage(new MemberPage(WebAppSession.get().getMember()));
		}
		
		@Override
		public boolean isVisible() {
			Boolean result = false;
			if (WebAppSession.get().getMember() != null) result = true;
			return result;
		}	
	}
	
	private class SignOutLink extends Link {
		private static final long serialVersionUID = 1;
		
		private SignOutLink(String wicketId) {
			super(wicketId);
		}

		@Override
		public void onClick() {
			WebAppSession.get().invalidate();
			setResponsePage(HomePage.class);
		}
		
		@Override
		public boolean isVisible() {
			Boolean result = false;
			if (WebAppSession.get().getMember() != null) result = true;
			return result;
		}
	}

}