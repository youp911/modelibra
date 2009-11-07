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

import org.ieducnews.model.config.ModelProperties;

public class DomainModel implements Serializable {

	private static final long serialVersionUID = 1;

	private File file;

	private WebLinks webLinks = new WebLinks();

	public DomainModel() {
		ModelProperties modelProperties = new ModelProperties(
				ModelProperties.class);
		createFile(modelProperties);
	}

	public DomainModel(ModelProperties modelProperties) {
		init();
		createFile(modelProperties);
	}

	private void createFile(ModelProperties modelProperties) {
		file = new File(modelProperties.getFilePath());
	}

	private void init() {
		WebLink webLink01 = new WebLink();
		webLink01.setName("Hacker News");
		webLink01.setLink("http://news.ycombinator.com/");

		WebLink webLink02 = new WebLink();
		webLink02.setName("TechCrunch");
		webLink02.setLink("http://www.techcrunch.com/");

		WebLink webLink03 = new WebLink();
		webLink03.setName("Jane's E-Learning Pick");
		webLink03.setLink("http://janeknight.typepad.com/");

		WebLink webLink04 = new WebLink();
		webLink04.setName("Web Standards Curriculum");
		webLink04
				.setLink("http://dev.opera.com/articles/view/1-introduction-to-the-web-standards-cur/");

		WebLink webLink05 = new WebLink();
		webLink05.setName("Free Online Classes");
		webLink05.setLink("http://www.guidetoonlineschools.com/online-classes");

		webLinks.add(webLink01);
		webLinks.add(webLink02);
		webLinks.add(webLink03);
		webLinks.add(webLink04);
		webLinks.add(webLink05);
	}

	public WebLinks getWebLinks() {
		return webLinks;
	}

	public DomainModel load() {
		try {
			if (file.exists()) {
				BufferedInputStream buffer = new BufferedInputStream(
						new FileInputStream(file));
				ObjectInput i = new ObjectInputStream(buffer);
				return (DomainModel) i.readObject();
			}
			return this;
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
