package org.ieducnews.model.concept.member;

import org.ieducnews.model.DomainModel;
import org.ieducnews.model.config.ModelProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MembersTest {

	private static DomainModel domainModel;

	@BeforeClass
	public static void beforeTests() {
		ModelProperties modelProperties = new ModelProperties(MembersTest.class);
		domainModel = new DomainModel(modelProperties);
		domainModel = domainModel.load();
	}

	@Test
	public void membersOrderedByAccount() throws Exception {
		Members members = domainModel.getMembers();
		Members orderedMembers = members.orderByAccount();

		if (!members.isEmpty()) {
			Assert.assertFalse(orderedMembers.isEmpty());
		}
		Assert.assertEquals(members.size(), orderedMembers.size());
		Assert.assertNotSame(members, orderedMembers);

		orderedMembers.output("---Members ordered by account---");
	}
	
	@AfterClass
	public static void afterTests() {
		domainModel.save();
	}

}
