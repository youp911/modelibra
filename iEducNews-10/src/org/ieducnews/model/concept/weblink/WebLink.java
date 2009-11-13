package org.ieducnews.model.concept.weblink;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;

import org.ieducnews.model.type.EasyDate;

public class WebLink implements Serializable {

	private static final long serialVersionUID = 1;

	private String name;

	private URL link;

	private Date creationDate = new Date();

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLink(URL link) {
		this.link = link;
	}

	public URL getLink() {
		return link;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void output() {
		System.out.println("name: " + getName());
		System.out.println("link: " + getLink());
		System.out.println("creation date: " + getCreationDate());
	}

	public void outputWithEasyDate() {
		output();
		System.out.println("creation easy date: "
				+ new EasyDate(getCreationDate()));
	}

}
