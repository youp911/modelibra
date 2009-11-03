package org.ieducnews.model;

public class DomainModel {

	private WebLinks webLinks = new WebLinks();

	public DomainModel() {
		init();
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

}
