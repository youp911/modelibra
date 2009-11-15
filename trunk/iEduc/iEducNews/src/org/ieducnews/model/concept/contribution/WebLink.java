package org.ieducnews.model.concept.contribution;

import java.net.URL;


public class WebLink extends Submission {

	private static final long serialVersionUID = 1;

	private URL link;

	public void setLink(URL link) {
		this.link = link;
	}

	public URL getLink() {
		return link;
	}

	public void output() {
		super.output();
		System.out.println("name: " + getName());
		System.out.println("link: " + getLink());
	}

}
