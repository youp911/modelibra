package org.ieducnews.view;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddLinkPageTest {

	private static WicketTester tester;

	@BeforeClass
	public static void prepareTester() {
		tester = new WicketTester(new WebApp());
		tester.startPage(AddLinkPage.class);
	}

	@Test
	public void containComponents() {
		tester.assertComponent("menu", Panel.class);
		tester.assertComponent("form", Form.class);
		tester.assertComponent("feedback", FeedbackPanel.class);
		tester.assertComponent("footer", Panel.class);
	}

}
