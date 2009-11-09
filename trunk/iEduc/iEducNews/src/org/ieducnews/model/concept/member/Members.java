package org.ieducnews.model.concept.member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Members implements Serializable {

	private static final long serialVersionUID = 1;

	private List<Member> membersList = new ArrayList<Member>();

	public void add(Member member) {
		membersList.add(member);
	}

	public boolean remove(Member member) {
		return membersList.remove(member);
	}

	public boolean remove(String account) {
		for (Member member : membersList) {
			if (member.getAccount().equals(account)) {
				return remove(member);
			}
		}
		return false;
	}

	public boolean contains(Member member) {
		return membersList.contains(member);
	}

	public boolean contains(String account) {
		for (Member member : membersList) {
			if (member.getAccount().equals(account)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return membersList.size();
	}

	public boolean isEmpty() {
		return membersList.isEmpty();
	}

	public List<Member> getList() {
		return new ArrayList<Member>(membersList);
	}

	private void setList(List<Member> list) {
		membersList = list;
	}

	public Members orderByAccount(boolean ascending) {
		Members orderedMembers = new Members();
		List<Member> list = getList();
		Collections.sort(list, new AccountComparator());
		if (!ascending) {
			Collections.reverse(list);
		}
		orderedMembers.setList(list);
		return orderedMembers;
	}

	public Members orderByAccount() {
		return orderByAccount(true);
	}

	public void output(String title) {
		System.out.println(title);
		for (Member member : membersList) {
			member.output();
		}
	}

	private class AccountComparator implements Comparator<Member> {
		/**
		 * Compares two web links by comparing the name properties.
		 * 
		 * @param member1
		 *            account 1
		 * @param member2
		 *            account 2
		 * @return 0 if values are equal, > 0 if the first value is greater than
		 *         the second one, < 0 if the second value is greater than the
		 *         first one
		 */
		public int compare(Member member1, Member member2) {
			int result = 0;
			String account1 = member1.getAccount();
			String account2 = member2.getAccount();
			if (account1 != null && account2 != null) {
				result = account1.compareTo(account2);
			}
			return result;
		}
	}

}
