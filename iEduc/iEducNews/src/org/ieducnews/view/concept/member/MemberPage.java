package org.ieducnews.view.concept.member;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.ieducnews.model.concept.member.Member;
import org.ieducnews.model.concept.weblink.WebLink;
import org.ieducnews.model.concept.weblink.WebLinks;
import org.ieducnews.view.BasePage;
import org.ieducnews.view.WebApp;
import org.ieducnews.view.WebAppSession;


public class MemberPage extends BasePage {

	public MemberPage(Member member) {

		Form<Member> form = new Form<Member>("form",
				new CompoundPropertyModel<Member>(member));
		
		form.add(new Label("account",member.getAccount()));
		form.add(new Label("karma",member.getKarma().toString()));

		
		add(form);
	}
	
}