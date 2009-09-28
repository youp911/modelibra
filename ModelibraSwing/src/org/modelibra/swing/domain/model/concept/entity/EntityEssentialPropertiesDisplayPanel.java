package org.modelibra.swing.domain.model.concept.entity;

import java.util.List;

import javax.swing.JPanel;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.swing.widget.ModelibraPanel;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityEssentialPropertiesDisplayPanel extends ModelibraPanel {

	public EntityEssentialPropertiesDisplayPanel(ModelibraFrame contentFrame,
			IEntities<?> entities, IEntity<?> entity, NatLang natLang) {
		JPanel entityPropertiesPanel;
		if (entities.size() > 0) {
			List<PropertyConfig> essentialPropertyConfigList = entities
					.getConceptConfig().getPropertiesConfig()
					.getEssentialPropertyConfigList();
			entityPropertiesPanel = new EntityPropertiesPanel(contentFrame,
					true, false, entities, entity, essentialPropertyConfigList);
		} else {
			entityPropertiesPanel = new JPanel();
		}
		add(entityPropertiesPanel);
	}

}
