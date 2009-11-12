package org.ieducnews.model.concept.member;

import java.io.Serializable;

import org.ieducnews.model.type.Email;

public class Member implements Serializable {

	private static final long serialVersionUID = 1;

	public enum SecurityRole {
		REGULAR, ADMIN
	}

	private String lastName;

	private String firstName;

	private Email email;

	private Integer karma = 0;

	private String account;

	private String password;

	private SecurityRole role = SecurityRole.REGULAR;

	private Boolean approved = false;

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Email getEmail() {
		return email;
	}

	public void setKarma(Integer karma) {
		this.karma = karma;
	}

	public Integer getKarma() {
		return karma;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount() {
		return account;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setRole(SecurityRole role) {
		this.role = role;
	}

	public SecurityRole getRole() {
		return role;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean getApproved() {
		return approved;
	}

	public boolean isApproved() {
		return getApproved();
	}

	public void output() {
		System.out.println("last name: " + getLastName());
		System.out.println("first name: " + getFirstName());
		System.out.println("email: " + getEmail());
		System.out.println("vote: " + getKarma());
		System.out.println("account" + getAccount());
		System.out.println("password: " + getPassword());
		System.out.println("role: " + getRole());
		System.out.println("approved: " + getApproved());
	}

}
