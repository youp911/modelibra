/*
 * Modelibra
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.modelibra.wicket.widget;

import java.net.URL;
import java.util.Date;
import java.util.Locale;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.Oid;
import org.modelibra.config.NeighborConfig;
import org.modelibra.config.PropertyConfig;
import org.modelibra.exception.TypeRuntimeException;
import org.modelibra.type.Email;
import org.modelibra.type.PropertyClass;
import org.modelibra.util.TextHandler;
import org.modelibra.util.Transformer;
import org.modelibra.wicket.view.View;
import org.modelibra.wicket.view.ViewModel;

/**
 * Label panel.
 * 
 * @author Dzenan Ridjanovic
 * @version 2008-10-28
 */
public class LabelPanel extends Panel {

	private static final long serialVersionUID = 101840L;

	private Label label;

	/**
	 * Constructs a label panel.
	 * 
	 * @param viewModel
	 *            view model
	 * @param view
	 *            view
	 */
	public LabelPanel(final ViewModel viewModel, final View view) {
		super(view.getWicketId());
		Locale locale = view.getLocale();

		IEntity<?> entity = viewModel.getEntity();
		PropertyConfig propertyConfig = viewModel.getPropertyConfig();
		boolean shortContext = false;
		if (!view.getUserProperties().isEmpty()) {
			Boolean shortTextBoolean = (Boolean) view.getUserProperties()
					.getUserProperty("shortText");
			if (shortTextBoolean != null) {
				shortContext = shortTextBoolean.booleanValue();
			}
		}

		String propertyCode = propertyConfig.getCode();
		Class<?> propertyClass = propertyConfig.getPropertyClassObject();
		String propertyValueText = null;
		try {
			if (entity != null) {
				if (propertyConfig.isReference()) {
					String neighborCode = propertyConfig.getReferenceNeighbor();
					NeighborConfig neighborConfig = entity.getConceptConfig()
							.getNeighborsConfig().getNeighborConfig(
									neighborCode);
					String neighborConceptCode = neighborConfig
							.getDestinationConcept();
					IEntities<?> neighborEntities = viewModel.getModel()
							.getEntry(neighborConceptCode);
					if (neighborEntities != null) {
						Long referenceOid = (Long) entity
								.getProperty(propertyCode);
						Oid neighborParentOid = new Oid(referenceOid);
						IEntity<?> neighborParent = neighborEntities
								.retrieveByOid(neighborParentOid);
						if (neighborParent != null) {
							PropertyConfig uniquelPropertyConfig = neighborParent
									.getConceptConfig().getPropertiesConfig()
									.getFirstUniquePropertyConfig();
							if (uniquelPropertyConfig != null
									&& uniquelPropertyConfig.getPropertyClass()
											.equals(PropertyClass.getString())) {
								propertyValueText = (String) neighborParent
										.getProperty(uniquelPropertyConfig
												.getCode());
							}
						}
					}
				} else if (propertyClass == String.class) {
					propertyValueText = (String) entity
							.getProperty(propertyCode);
					if (propertyValueText != null && shortContext) {
						int shortTextLength = viewModel.getModel()
								.getModelConfig().getDomainConfig()
								.getShortTextDefaultLengthInt();
						if (propertyValueText.length() > shortTextLength) {
							TextHandler textHandler = new TextHandler();
							propertyValueText = textHandler
									.extractBeginPlusThreeDots(
											propertyValueText, shortTextLength);
						}
					}
					if (propertyConfig.isScramble()) {
						propertyValueText = "********";
					}
				} else if (propertyClass == Integer.class) {
					Integer propertyValue = (Integer) entity
							.getProperty(propertyCode);
					propertyValueText = Transformer.string(propertyValue);
				} else if (propertyClass == Long.class) {
					Long propertyValue = (Long) entity
							.getProperty(propertyCode);
					propertyValueText = Transformer.string(propertyValue);
				} else if (propertyClass == Float.class) {
					Float propertyValue = (Float) entity
							.getProperty(propertyCode);
					propertyValueText = Transformer.string(propertyValue,
							locale);
				} else if (propertyClass == Double.class) {
					Double propertyValue = (Double) entity
							.getProperty(propertyCode);
					propertyValueText = Transformer.string(propertyValue,
							locale);
				} else if (propertyClass == Boolean.class) {
					Boolean propertyValue = (Boolean) entity
							.getProperty(propertyCode);
					propertyValueText = Transformer.string(propertyValue);
				} else if (propertyClass == Date.class) {
					Date propertyValue = (Date) entity
							.getProperty(propertyCode);
					String datePattern = viewModel.getModel().getModelConfig()
							.getDatePattern();
					propertyValueText = Transformer.string(propertyValue,
							datePattern);
				} else if (propertyClass == URL.class) {
					URL propertyValue = (URL) entity.getProperty(propertyCode);
					propertyValueText = Transformer.string(propertyValue);
				} else if (propertyClass == Email.class) {
					Email propertyValue = (Email) entity
							.getProperty(propertyCode);
					propertyValueText = Transformer.string(propertyValue);
				} else {
					Object propertyValue = entity.getProperty(propertyCode);
					if (propertyValue != null) {
						propertyValueText = propertyValue.toString();
					}
				}
			}
		} catch (TypeRuntimeException e) {
			if (propertyConfig.isRequired()) {
				throw new TypeRuntimeException(
						"LabelPanel.construcur -- required property is either null or it has a wrong type: "
								+ propertyConfig.getCode(), e);
			} else {
				propertyValueText = null;
			}
		}
		label = new Label("propertyValue", propertyValueText);
		add(label);
	}

	/**
	 * Sets an attribute.
	 * 
	 * @param attributeName
	 *            attribute name
	 * @param attributeValue
	 *            attribute value
	 */
	public void setAttribute(String attributeName, String attributeValue) {
		AttributeModifier attributeModifier = new AttributeModifier(
				attributeName, true, new Model(attributeValue));
		label.add(attributeModifier);
	}

}
