package org.ieducnews.model.concept.weblink;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WebLinks implements Serializable {

	private static final long serialVersionUID = 1;

	private List<WebLink> webLinksList = new ArrayList<WebLink>();

	public void add(WebLink webLink) {
		webLinksList.add(webLink);
	}

	public boolean remove(WebLink webLink) {
		return webLinksList.remove(webLink);
	}

	public boolean remove(String name) {
		for (WebLink webLink : webLinksList) {
			if (webLink.getName().equals(name)) {
				return remove(webLink);
			}
		}
		return false;
	}

	public boolean contains(WebLink webLink) {
		return webLinksList.contains(webLink);
	}

	public boolean contains(String name) {
		for (WebLink webLink : webLinksList) {
			if (webLink.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return webLinksList.size();
	}

	public boolean isEmpty() {
		return webLinksList.isEmpty();
	}

	public List<WebLink> getList() {
		return new ArrayList<WebLink>(webLinksList);
	}

	private void setList(List<WebLink> list) {
		webLinksList = list;
	}

	public WebLinks orderByName(boolean ascending) {
		WebLinks orderedWebLinks = new WebLinks();
		List<WebLink> list = getList();
		Collections.sort(list, NAME_COMPARATOR);
		if (!ascending) {
			Collections.reverse(list);
		}
		orderedWebLinks.setList(list);
		return orderedWebLinks;
	}

	public WebLinks orderByName() {
		return orderByName(true);
	}

	public WebLinks orderByCreationDate(boolean ascending) {
		WebLinks orderedWebLinks = new WebLinks();
		List<WebLink> list = getList();
		Collections.sort(list, CREATION_DATE_COMPARATOR);
		if (!ascending) {
			Collections.reverse(list);
		}
		orderedWebLinks.setList(list);
		return orderedWebLinks;
	}

	public WebLinks orderByCreationDate() {
		return orderByName(true);
	}

	private static final Comparator<WebLink> NAME_COMPARATOR = new NameComparator();

	private static final Comparator<WebLink> CREATION_DATE_COMPARATOR = new CreationDateComparator();

	private static class NameComparator implements Comparator<WebLink> {
		public int compare(WebLink webLink1, WebLink webLink2) {
			return webLink1.getName().compareTo(webLink2.getName());
		}
	}

	private static class CreationDateComparator implements Comparator<WebLink> {
		public int compare(WebLink webLink1, WebLink webLink2) {
			return webLink1.getCreationDate().compareTo(
					webLink2.getCreationDate());
		}
	}

	public void output(String title) {
		System.out.println(title);
		for (WebLink webLink : webLinksList) {
			webLink.output();
		}
	}

}
