package org.ieducnews.view;

import org.apache.wicket.protocol.http.WebApplication;
import org.ieducnews.model.DomainModel;

public class WebApp extends WebApplication {

	private DomainModel domainModel;

	@Override
	protected void init() {
		super.init();
		domainModel = new DomainModel();
	}

	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	public DomainModel getDomainModel() {
		return domainModel;
	}

}
