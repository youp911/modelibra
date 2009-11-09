package org.ieducnews.model.component;

import java.util.Comparator;

public class GenericComparator {

	public static <T> Comparator<T> createComparator(
			final Comparator<T>... comparators) {
		return new Comparator<T>() {
			public int compare(T t1, T t2) {
				int result = 0;
				for (Comparator<T> comparator : comparators) {
					result = comparator.compare(t1, t2);
					if (result != 0) {
						break;
					}
				}
				return result;
			}
		};
	}

}
