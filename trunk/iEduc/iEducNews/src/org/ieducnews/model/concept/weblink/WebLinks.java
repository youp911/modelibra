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
		Collections.sort(list, new NameComparator());
		if (!ascending) {
			Collections.reverse(list);
		}
		orderedWebLinks.setList(list);
		return orderedWebLinks;
	}

	public WebLinks orderByName() {
		return orderByName(true);
	}

	public void output(String title) {
		System.out.println(title);
		for (WebLink webLink : webLinksList) {
			webLink.output();
		}
	}

	private class NameComparator implements Comparator<WebLink> {
		/**
		 * Compares two web links by comparing the name properties.
		 * 
		 * @param webLink1
		 *            web link 1
		 * @param webLink2
		 *            web link 2
		 * @return 0 if values are equal, > 0 if the first value is greater than
		 *         the second one, < 0 if the second value is greater than the
		 *         first one
		 */
		public int compare(WebLink webLink1, WebLink webLink2) {
			int result = 0;
			String name1 = webLink1.getName();
			String name2 = webLink2.getName();
			if (name1 != null && name2 != null) {
				result = name1.compareTo(name2);
			}
			return result;
		}
	}

}
