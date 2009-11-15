package org.ieducnews.model.concept.contribution;

public class Submission extends Contribution {

	private static final long serialVersionUID = 1;

	private String name;

	private Specialization specialization;

	public enum Specialization {
		WEBLINK, QUESTION
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public boolean isWebLink() {
		if (specialization.equals(Specialization.WEBLINK)) {
			return true;
		}
		return false;
	}

	public void output() {
		super.output();
		System.out.println("specialization: " + getSpecialization());
	}

}
