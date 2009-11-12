package org.ieducnews.view.concept.member;

import java.util.List;

import javax.mail.internet.AddressException;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.ieducnews.model.concept.member.Member;
import org.ieducnews.model.concept.member.Members;
import org.ieducnews.model.concept.weblink.WebLink;
import org.ieducnews.model.concept.weblink.WebLinks;
import org.ieducnews.model.type.Email;
import org.ieducnews.view.BasePage;
import org.ieducnews.view.HomePage;
import org.ieducnews.view.WebApp;
import org.ieducnews.view.WebAppSession;
import org.ieducnews.view.type.EmailConverter;

public class MemberPage extends BasePage {

	public MemberPage(final Member member) {
		final WebApp webApp = (WebApp) getApplication();
		WebAppSession webAppSession = (WebAppSession) getSession();
		
		Form<Member> form = new Form<Member>("form",
				new CompoundPropertyModel<Member>(member));
		
		form.add(new Label("account",member.getAccount()));
		form.add(new Label("karma",member.getKarma().toString()));
		
		Label password_label = new Label("password_label","password :");
		Label retrivePassword = new Label("retrivePassword","retrive password");
		//Link Retreive Password
		form.add(password_label);
		form.add(retrivePassword);
		
		Label lastName_label = new Label("lastName_label","last name :");
		final TextField<String> lastName = new TextField<String>("lastName", new Model(member.getLastName()));
		form.add(lastName_label);
		form.add(lastName);
		
		Label firstName_label = new Label("firstName_label","first name :");
		final TextField<String> firstName = new TextField<String>("firstName", new Model(member.getFirstName()));
		form.add(firstName_label);
		form.add(firstName);
		
		Label email_label = new Label("email_label","email :");
		final TextField<String> email = new TextField<String>("email", new Model(member.getEmail()));
		form.add(email_label);
		form.add(email);
		
		add(form);
		
		form.add(new Button("update") {
			@Override
			public void onSubmit() {				
				member.setLastName(lastName.getDefaultModelObjectAsString());
				member.setFirstName(firstName.getDefaultModelObjectAsString());
				try {
					member.setEmail(new Email(email.getDefaultModelObjectAsString()));
				} catch (AddressException e) {
					error(email.getDefaultModelObjectAsString() + " is not a valid email.");
				}
				webApp.getDomainModel().save();
				
			}
		});	
		
		if (!isOwningMemberOrAdmin(member)){
			password_label.setVisible(false);
			retrivePassword.setVisible(false);
			lastName_label.setVisible(false);
			lastName.setVisible(false);
			firstName_label.setVisible(false);
			firstName.setVisible(false);
			email_label.setVisible(false);
			email.setVisible(false);
		}
		
		add(new FeedbackPanel("feedback"));
	}
	
	private boolean isOwningMemberOrAdmin(Member member){
		WebAppSession webAppSession = (WebAppSession) getSession();
		boolean result = false;
		
		if (webAppSession.isAuthenticated()){
			if (webAppSession.getMember().equals(member)) result=true;
			if (webAppSession.isAdmin()) result=true;
		}
		return result;
	} 
	
}