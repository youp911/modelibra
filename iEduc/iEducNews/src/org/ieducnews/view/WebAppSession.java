package org.ieducnews.view;

import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.ieducnews.model.concept.member.Member;
import org.ieducnews.model.concept.member.Member.SecurityRole;

public class WebAppSession extends WebSession {

	private static final long serialVersionUID = 1;

	private Member member;

	public static WebAppSession get() {
		return (WebAppSession) Session.get();
	}

	public WebAppSession(Request request) {
		super(request);
	}

	public synchronized Member getMember() {
		return member;
	}

	public synchronized void setMember(Member member) {
		this.member = member;
		dirty();
	}

	public boolean isAuthenticated() {
		return (member != null);
	}

	public boolean isAdmin() {
		return (member.getRole().equals(SecurityRole.ADMIN));
	}

}