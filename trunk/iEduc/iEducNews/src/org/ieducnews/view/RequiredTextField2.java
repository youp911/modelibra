package org.ieducnews.view;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

public class RequiredTextField2 extends TextField {

	public RequiredTextField2(String id) {
		super(id);
	}

	public RequiredTextField2(String id, Class type) {
		super(id, type);
		setRequired(true);
	}

	public RequiredTextField2(String id, IModel model) {
		super(id, model);
		setRequired(true);
	}

	public RequiredTextField2(String id, IModel model, Class type) {
		super(id, model, type);
		setRequired(true);
	}
	
}
