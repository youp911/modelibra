package org.modelibra.swing.domain.model.concept.entity;

import java.util.List;

import javax.swing.BoxLayout;

import org.modelibra.IEntity;
import org.modelibra.config.ConceptConfig;
import org.modelibra.config.NeighborConfig;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.ModelibraPanel;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityAbsorbedParentsPanel extends ModelibraPanel {

	public EntityAbsorbedParentsPanel(IEntity<?> entity,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		addAbsorbedParents(entity, neighborConfigList, natLang);
	}

	protected void addAbsorbedParents(IEntity<?> entity,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		for (final NeighborConfig neighborConfig : neighborConfigList) {
			if (neighborConfig.isParent() && neighborConfig.isAbsorb()) {
				IEntity<?> parentEntity = entity
						.getParentNeighbor(neighborConfig.getCode());
				if (parentEntity != null) {
					ConceptConfig parentConceptConfig = neighborConfig
							.getDestinationConceptConfig();
					List<PropertyConfig> essentialPropertyConfigList = parentConceptConfig
							.getPropertiesConfig()
							.getEssentialPropertyConfigList();
					add(new EntityPropertiesPanel(null, true, false, null, null,
							parentEntity, essentialPropertyConfigList, natLang));
				}
			}
		}
	}

}
