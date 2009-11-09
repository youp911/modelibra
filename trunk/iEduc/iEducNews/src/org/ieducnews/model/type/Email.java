package org.ieducnews.model.type;

import java.io.Serializable;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Email type value must be a valid email address. A valid email address must
 * have at least two characters before the @ sign (before text) and at least
 * three characters after the sign (after text). The after text must have at
 * least one inner dot.
 */
public class Email implements Serializable {

	private static final long serialVersionUID = 1;

	public static final int BEFORE_AT_TEXT_MIN_LENGTH = 2;

	public static final int AFTER_AT_TEXT_MIN_LENGTH = 3;

	private String emailAddress;

	/**
	 * Constructs an email address object.
	 * 
	 * @param emailAddress
	 *            email address
	 * @throws email
	 *             address exception if there is a problem
	 */
	public Email(String emailAddress) {
		if (validate(emailAddress)) {
			this.emailAddress = emailAddress;
		} else {
			this.emailAddress = "not.valid@email.com";
		}
	}

	/**
	 * Validates an email address string. A valid email address must have at
	 * least two characters before the @ sign (before text) and at least three
	 * characters after the sign (after text). The after text must have at least
	 * one inner dot.
	 * 
	 * @param emailAddress
	 *            email address
	 * @return <code>true</code> if a valid email address
	 */
	private boolean validate(String emailAddress) {
		boolean result = false;
		if (emailAddress != null) {
			try {
				new InternetAddress(emailAddress);
			} catch (AddressException e) {
				System.out.println("not valid email: " + emailAddress);
			}
			String[] atTokens = emailAddress.split("@");
			if (atTokens.length == 2) {
				String beforeAt = atTokens[0];
				String afterAt = atTokens[1];
				if (beforeAt.length() >= BEFORE_AT_TEXT_MIN_LENGTH
						&& afterAt.length() >= AFTER_AT_TEXT_MIN_LENGTH) {
					if (atLeastOneInnerDot(afterAt)) {
						result = true;
					}
				}
			}
		}
		return result;
	}

	/**
	 * Validates if after the @ sign text (after text) has at least one inner
	 * dot.
	 * 
	 * @param afterText
	 *            after the AT sign text
	 * @return <code>true</code> if after text has at least one inner dot
	 */
	private boolean atLeastOneInnerDot(String afterText) {
		boolean result = false;
		int firstDotIndex = afterText.indexOf(".");
		if (firstDotIndex > 0 && firstDotIndex < afterText.length() - 1) {
			result = true;
		}
		return result;
	}

	/**
	 * Checks if two email addresses are equal.
	 * 
	 * @param value
	 *            email address
	 * @return <code>true</code> if two email addresses are equal
	 */
	public boolean equals(Object value) {
		if (value instanceof Email) {
			Email email = (Email) value;
			if (toString().equals(email.toString())) {
				return true;
			}
		} else if (value instanceof String) {
			String emailString = (String) value;
			return equals(new Email(emailString));
		}
		return false;
	}

	/**
	 * Provides an email address as a string.
	 * 
	 * @return email address string
	 */
	public String toString() {
		return emailAddress;
	}

}
