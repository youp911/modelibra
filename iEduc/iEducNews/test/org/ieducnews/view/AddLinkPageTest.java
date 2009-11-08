package org.ieducnews.view;

import java.io.File;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.apache.wicket.validation.validator.UrlValidator;
import org.ieducnews.model.DomainModel;
import org.ieducnews.model.WebLink;
import org.ieducnews.model.WebLinks;
import org.ieducnews.model.config.ModelProperties;
import org.ieducnews.view.weblink.AddLinkPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddLinkPageTest {

	private static WicketTester tester;
	
	@Before
	public void prepareTester() {
		tester = new WicketTester(new WebApp());
		tester.setupRequestAndResponse();
		tester.startPage(AddLinkPage.class);
	}

	@Test
	public void containComponents() {
		tester.assertComponent("menu", Panel.class);
		tester.assertComponent("form", Form.class);
		tester.assertComponent("form:name", RequiredTextField.class);
		tester.assertComponent("form:link", RequiredTextField.class);
		tester.assertComponent("form:save", Button.class);
		tester.assertComponent("feedback", FeedbackPanel.class);
		tester.assertComponent("footer", Panel.class);
	}
	
	@Test
	public void nameRequiered() {
		//given
		FormTester formTester = tester.newFormTester("form");
		formTester.setValue("link", "http://www.testlink.com");
		
		//Sumbit
		formTester.submit("save");
		
		//Required fields messages are displayed
		tester.assertErrorMessages(new String[]{
			"name is required."
		});
	}
	
	@Test
	public void linkRequiered() {
		//given
		FormTester formTester = tester.newFormTester("form");
		formTester.setValue("name", "This is a test name");
		
		//Sumbit
		formTester.submit("save");
		
		//Required fields messages are displayed
		tester.assertErrorMessages(new String[]{
			"link is required."
		});
		
	}
	
	@Test
	public void submitLink() {
		//given
		FormTester formTester = tester.newFormTester("form");
		formTester.setValue("name", "Test Name");
		formTester.setValue("link", "http://www.testlink.com");
		
		//Sumbit
		formTester.submit("save");
		
		//No messages
		tester.assertNoErrorMessage();
		tester.assertNoInfoMessage();
		
		//Redirection
		tester.assertRenderedPage(HomePage.class);
	}
	
	@Test
	public void existingName() {
		//given
		FormTester formTester = tester.newFormTester("form");
		
		//Previous entry
		formTester.setValue("name", "Test Name");
		formTester.setValue("link", "http://www.testlink.com");
		
		//Sumbit
		formTester.submit("save");
		
		//Required fields messages are displayed
		tester.assertErrorMessages(new String[]{
			"this name exists already."
		});
		
	}
	
	@AfterClass
	public static void afterTest() {
		//TODO Remove test link
	}

}
