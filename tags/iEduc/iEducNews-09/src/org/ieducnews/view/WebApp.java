package org.ieducnews.view;

import org.apache.wicket.protocol.http.WebApplication;
import org.ieducnews.model.DomainModel;

public class WebApp extends WebApplication {

	private DomainModel domainModel;

	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	public void setDomainModel(DomainModel domainModel) {
		this.domainModel = domainModel;
	}

	public DomainModel getDomainModel() {
		if (domainModel == null) {
			domainModel = new DomainModel();
			domainModel = domainModel.load();
		}
		return domainModel;
	}

}
