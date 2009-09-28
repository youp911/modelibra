package org.modelibra.swing.domain.model.concept.entity;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.modelibra.Entity;
import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.domain.model.concept.entity.property.EntityPropertyWidgetPanel;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.swing.widget.ModelibraPanel;

@SuppressWarnings("serial")
public class EntityPropertiesPanel extends ModelibraPanel implements Observer {

	private ModelibraFrame contentFrame;

	private boolean displayOnly;

	private boolean add;

	private IEntities<?> entities;

	private IEntity<?> entity;

	private List<PropertyConfig> propertyConfigList;

	public EntityPropertiesPanel(ModelibraFrame contentFrame,
			boolean displayOnly, boolean add, IEntities<?> entities,
			IEntity<?> entity, List<PropertyConfig> propertyConfigList) {
		this.contentFrame = contentFrame;
		this.displayOnly = displayOnly;
		this.add = add;
		this.entities = entities;
		this.entity = entity;
		this.propertyConfigList = propertyConfigList;

		((Entity<?>) entity).addObserver(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		addTitle(contentFrame, entity);
		addProperties(contentFrame, displayOnly, add, entities, entity,
				propertyConfigList);
	}

	protected void addTitle(ModelibraFrame contentFrame, IEntity<?> entity) {
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		titlePanel.add(new JLabel(contentFrame.getApp().getNatLang().getText(
				entity.getConceptConfig().getCode())));
		add(titlePanel);
	}

	private int getPropertyWithoutReferenceCount(
			List<PropertyConfig> propertyConfigList) {
		int propertyWithoutReferenceCount = 0;
		for (PropertyConfig propertyConfig : propertyConfigList) {
			if (!propertyConfig.isReference()) {
				propertyWithoutReferenceCount++;
			}
		}
		return propertyWithoutReferenceCount;
	}

	protected void addProperties(ModelibraFrame contentFrame,
			boolean displayOnly, boolean add, IEntities<?> entities,
			IEntity<?> entity, List<PropertyConfig> propertyConfigList) {
		JPanel propertiesPanel = new JPanel();
		propertiesPanel.setLayout(new GridLayout(
				getPropertyWithoutReferenceCount(propertyConfigList), 2, 4, 4));
		for (PropertyConfig propertyConfig : propertyConfigList) {
			if (!propertyConfig.isReference()) {
				propertiesPanel.add(new EntityPropertyWidgetPanel(contentFrame,
						displayOnly, add, entities, entity, propertyConfig));
			}
		}
		add(propertiesPanel);
	}

	// implemented from Observer
	public void update(Observable o, Object arg) {
		if (o == entity) {
			if (arg instanceof PropertyConfig) {
				PropertyConfig propertyConfig = (PropertyConfig) arg;
				for (Component component : getComponents()) {
					if (component instanceof JPanel) {
						JPanel panel = (JPanel) component;
						for (Component subcomponent : panel.getComponents()) {
							if (subcomponent instanceof EntityPropertyWidgetPanel) {
								EntityPropertyWidgetPanel propertyPanel = (EntityPropertyWidgetPanel) subcomponent;
								if (propertyPanel.getPropertyName().equals(
										propertyConfig.getCode())) {
									removeAll();
									addTitle(contentFrame, entity);
									addProperties(contentFrame, displayOnly,
											add, entities, entity,
											propertyConfigList);
									validate();
									contentFrame.pack();
								}
							}
						}
					}
				}
			}
		}
	}

}
