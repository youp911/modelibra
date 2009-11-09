package org.ieducnews.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.mail.internet.AddressException;

import org.ieducnews.model.concept.member.Member;
import org.ieducnews.model.concept.member.Members;
import org.ieducnews.model.concept.weblink.WebLink;
import org.ieducnews.model.concept.weblink.WebLinks;
import org.ieducnews.model.config.ModelProperties;
import org.ieducnews.model.type.Email;

public class DomainModel implements Serializable {

	private static final long serialVersionUID = 1;

	private File file;

	private WebLinks webLinks = new WebLinks();

	private Members members = new Members();

	public DomainModel() {
		ModelProperties modelProperties = new ModelProperties(
				ModelProperties.class);
		createFile(modelProperties);
	}

	public DomainModel(ModelProperties modelProperties) {
		createFile(modelProperties);
	}

	private void createFile(ModelProperties modelProperties) {
		file = new File(modelProperties.getFilePath());
	}

	private void initWebLinks() {
		try {
			WebLink webLink01 = new WebLink();
			webLink01.setName("Hacker News");
			webLink01.setLink(new URL("http://news.ycombinator.com/"));

			WebLink webLink02 = new WebLink();
			webLink02.setName("TechCrunch");
			webLink02.setLink(new URL("http://www.techcrunch.com/"));

			WebLink webLink03 = new WebLink();
			webLink03.setName("Jane's E-Learning Pick");
			webLink03.setLink(new URL("http://janeknight.typepad.com/"));

			WebLink webLink04 = new WebLink();
			webLink04.setName("Web Standards Curriculum");
			webLink04
					.setLink(new URL(
							"http://dev.opera.com/articles/view/1-introduction-to-the-web-standards-cur/"));

			WebLink webLink05 = new WebLink();
			webLink05.setName("Free Online Classes");
			webLink05.setLink(new URL(
					"http://www.guidetoonlineschools.com/online-classes"));

			webLinks.add(webLink01);
			webLinks.add(webLink02);
			webLinks.add(webLink03);
			webLinks.add(webLink04);
			webLinks.add(webLink05);
		} catch (MalformedURLException e) {
			System.out.println("Not a valid URL: " + e);
		}
	}

	private void initMembers() {
		Member member01 = new Member();
		member01.setLastName("Ridjanovic");
		member01.setFirstName("Dzenan");
		String member01Email = "dzenanr@gmail.com";
		try {
			member01.setEmail(new Email(member01Email));
		} catch (AddressException e) {
			System.out.println(member01Email + " is not a valid email.");
		}
		member01.setAccount("dzenanr");
		member01.setPassword("dr");
		member01.setRole("admin");
		member01.setApproved(true);

		Member member02 = new Member();
		member02.setLastName("Daneault");
		member02.setFirstName("Pascal");
		String member02Email = "pascal.daneault@gmail.com";
		try {
			member02.setEmail(new Email(member02Email));
		} catch (AddressException e) {
			System.out.println(member02Email + " is not a valid email.");
		}
		member02.setAccount("pascald");
		member02.setPassword("pd");
		member02.setRole("admin");
		member02.setApproved(true);

		members.add(member01);
		members.add(member02);
	}

	public WebLinks getWebLinks() {
		return webLinks;
	}

	public Members getMembers() {
		return members;
	}

	public DomainModel load() {
		try {
			if (!file.exists()) {
				initMembers();
				initWebLinks();
				save();
			}
			BufferedInputStream buffer = new BufferedInputStream(
					new FileInputStream(file));
			ObjectInput i = new ObjectInputStream(buffer);
			return (DomainModel) i.readObject();

		} catch (ClassNotFoundException e1) {
			throw new RuntimeException(e1);
		} catch (IOException e2) {
			throw new RuntimeException(e2);
		}
	}

	public void save() {
		try {
			if (!file.exists()) {

				file.createNewFile();
				System.out.println("Model file created: "
						+ file.getAbsolutePath());
			}
			BufferedOutputStream buffer = new BufferedOutputStream(
					new FileOutputStream(file));
			ObjectOutput o = new ObjectOutputStream(buffer);
			o.writeObject(this);
			buffer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
