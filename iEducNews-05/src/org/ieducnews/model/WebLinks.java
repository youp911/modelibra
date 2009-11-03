package org.ieducnews.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class WebLinks {

	private List webLinksList = new ArrayList();

	public void add(WebLink webLink) {
		webLinksList.add(webLink);
	}

	public boolean contains(WebLink webLink) {
		return webLinksList.contains(webLink);
	}

	public int size() {
		return webLinksList.size();
	}

	public boolean isEmpty() {
		return webLinksList.isEmpty();
	}

	public List getList() {
		return new ArrayList(webLinksList);
	}

	private void setList(List list) {
		webLinksList = list;
	}

	public WebLinks orderByName() {
		WebLinks orderedWebLinks = new WebLinks();
		List list = getList();
		Collections.sort(list, new NameComparator());
		orderedWebLinks.setList(list);
		return orderedWebLinks;
	}

	public void output(String title) {
		System.out.println(title);
		for (Object linkObject : webLinksList) {
			WebLink webLink = (WebLink) linkObject;
			webLink.output();
		}
	}

	@SuppressWarnings("all")
	private class NameComparator implements Comparator {

		public int compare(Object entity1, Object entity2)
				throws IllegalArgumentException {
			if (entity1 instanceof WebLink && entity2 instanceof WebLink) {
				WebLink webLink1 = (WebLink) entity1;
				WebLink webLink2 = (WebLink) entity2;
				return compareWebLinks(webLink1, webLink2);
			} else {
				throw new IllegalArgumentException();
			}
		}

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
		private int compareWebLinks(WebLink webLink1, WebLink webLink2) {
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
