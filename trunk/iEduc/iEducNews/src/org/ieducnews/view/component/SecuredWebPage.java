package org.ieducnews.view.component;

import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.ieducnews.view.BasePage;
import org.ieducnews.view.concept.member.SignInPage;


public class SecuredWebPage extends BasePage{
	public SecuredWebPage() {
		verifyAccess();
	}
	
	protected void verifyAccess() {
		// Redirect to Login page on invalid access.
		if (!getWebAppSession().isAuthenticated()) {
			throw new RestartResponseAtInterceptPageException(SignInPage.class);
		}
	}
}
