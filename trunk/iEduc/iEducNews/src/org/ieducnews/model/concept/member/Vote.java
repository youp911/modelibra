package org.ieducnews.model.concept.member;

import java.io.Serializable;

import org.ieducnews.model.concept.contribution.Comment;
import org.ieducnews.model.concept.contribution.Submission;

public class Vote implements Serializable {

	private static final long serialVersionUID = 1;

	private Boolean up;

	private Submission submission;
	
	private Comment comment;

	public void setUp(Boolean up) {
		this.up = up;
	}

	public Boolean getUp() {
		return up;
	}

	public boolean isUp() {
		return getUp();
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}

	public Submission getSubmission() {
		return submission;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Comment getComment() {
		return comment;
	}

	public void output() {
		System.out.println("text: " + getUp());
		
		if (getComment() == null) {
			getSubmission().output();
		} else {
			getComment().output();
		}
	}

}
