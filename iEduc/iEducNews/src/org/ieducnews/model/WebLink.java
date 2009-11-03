package org.ieducnews.model;

public class WebLink {

	private String name;

	private String link;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}
	
	public void output() {
		System.out.println("name: " + getName());
		System.out.println("link: " + getLink());
	}

}
