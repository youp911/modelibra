package org.ieducnews.view.concept.member;
import java.net.URL;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.ieducnews.model.concept.member.Member;
import org.ieducnews.model.concept.member.Members;
import org.ieducnews.model.concept.weblink.WebLink;
import org.ieducnews.model.concept.weblink.WebLinks;
import org.ieducnews.view.BasePage;
import org.ieducnews.view.WebApp;

public class SignInPage extends BasePage {

	public SignInPage() {
		WebApp webApp = (WebApp) getApplication();
		Members members = webApp.getDomainModel().getMembers();
		Member member = new Member();
		
		Form<Member> form = new Form<Member>("form",
				new CompoundPropertyModel<Member>(member));
		form.add(new RequiredTextField<String>("account"));
		form.add(new PasswordTextField("password"));

		add(form);
		add(new FeedbackPanel("feedback"));
		
	}
	
}