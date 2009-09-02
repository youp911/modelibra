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
import org.modelibra.ModelSession;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.ModelibraFrame;
import org.modelibra.swing.ModelibraPanel;
import org.modelibra.swing.domain.model.concept.entity.property.EntityPropertyWidgetPanel;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityPropertiesPanel extends ModelibraPanel implements Observer {

	private ModelibraFrame contentFrame;

	private boolean displayOnly;

	private boolean add;

	private ModelSession modelSession;

	private IEntities<?> entities;

	private IEntity<?> entity;

	private List<PropertyConfig> propertyConfigList;

	private NatLang natLang;

	public EntityPropertiesPanel(ModelibraFrame contentFrame,
			boolean displayOnly, boolean add, ModelSession modelSession,
			IEntities<?> entities, IEntity<?> entity,
			List<PropertyConfig> propertyConfigList, NatLang natLang) {
		this.contentFrame = contentFrame;
		this.displayOnly = displayOnly;
		this.add = add;
		this.modelSession = modelSession;
		this.entities = entities;
		this.entity = entity;
		this.propertyConfigList = propertyConfigList;
		this.natLang = natLang;

		((Entity<?>) entity).addObserver(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		addTitle(entity, natLang);
		addProperties(contentFrame, displayOnly, add, modelSession, entities,
				entity, propertyConfigList, natLang);
	}

	protected void addTitle(IEntity<?> entity, NatLang natLang) {
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		titlePanel.add(new JLabel(natLang.getText(entity.getConceptConfig()
				.getCode())));
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
			boolean displayOnly, boolean add, ModelSession modelSession,
			IEntities<?> entities, IEntity<?> entity,
			List<PropertyConfig> propertyConfigList, NatLang natLang) {
		JPanel propertiesPanel = new JPanel();
		propertiesPanel.setLayout(new GridLayout(
				getPropertyWithoutReferenceCount(propertyConfigList), 2, 4, 4));
		for (PropertyConfig propertyConfig : propertyConfigList) {
			if (!propertyConfig.isReference()) {
				propertiesPanel.add(new EntityPropertyWidgetPanel(contentFrame,
						displayOnly, add, modelSession, entities, entity,
						propertyConfig, natLang));
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
									addTitle(entity, natLang);
									addProperties(contentFrame, displayOnly,
											add, modelSession, entities,
											entity, propertyConfigList, natLang);
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
