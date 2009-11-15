package org.ieducnews.model.concept.member;

import java.io.Serializable;

public class Vote implements Serializable {

	private static final long serialVersionUID = 1;

	private Boolean up;

	public void setUp(Boolean up) {
		this.up = up;
	}

	public Boolean getUp() {
		return up;
	}

	public boolean isUp() {
		return getUp();
	}

	public void output() {
		System.out.println("text: " + getUp());
	}

}
