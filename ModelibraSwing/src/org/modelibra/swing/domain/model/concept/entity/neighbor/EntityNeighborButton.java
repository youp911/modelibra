package org.modelibra.swing.domain.model.concept.entity.neighbor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.ModelSession;
import org.modelibra.config.ConceptConfig;
import org.modelibra.config.NeighborConfig;
import org.modelibra.swing.ModelibraButton;
import org.modelibra.swing.ModelibraFrame;
import org.modelibra.swing.domain.model.concept.entity.EntityAttributesFrame;
import org.modelibra.swing.domain.model.concept.entity.EntityTableFrame;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public abstract class EntityNeighborButton extends ModelibraButton {

	public EntityNeighborButton(final ModelibraFrame contentFrame,
			final boolean displayOnly, final ModelSession modelSession,
			final NeighborConfig neighborConfig, final NatLang natLang) {
		setButtonName(neighborConfig, natLang);
		if (neighborConfig.isDisplay()) {
			if (neighborConfig.isParent()) {
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IEntity<?> entity = getEntity();
						if (entity != null) {
							ParentLookupBridge parentLookupBridge = new ParentLookupBridge(
									entity, neighborConfig);
							IEntity<?> parentEntity = parentLookupBridge
									.getParentEntity();
							if (parentEntity != null) {
								IEntities<?> parentEntities = parentLookupBridge
										.getLookupEntities();
								if (parentEntities != null) {
									ConceptConfig neighborConceptConfig = neighborConfig
											.getDestinationConceptConfig();
									boolean internalContext = false;
									if (neighborConfig.isInternal()) {
										internalContext = true;
									}
									ModelibraFrame modelibraFrame = new EntityAttributesFrame(
											internalContext,
											displayOnly,
											false,
											modelSession,
											parentEntities,
											parentEntity,
											neighborConceptConfig
													.getPropertiesConfig()
													.getPropertyConfigWithoutReferenceList(),
											neighborConceptConfig
													.getNeighborsConfig()
													.getList(), natLang);
									contentFrame
											.displayDownRight(modelibraFrame);
									contentFrame.addChildFrame(modelibraFrame);
								}
							}
						}
					}
				});
			} else if (neighborConfig.isChild()) {
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IEntity<?> entity = getEntity();
						if (entity != null) {
							IEntities<?> neighborEntities = entity
									.getChildNeighbor(neighborConfig.getCode());
							if (neighborEntities != null) {
								ConceptConfig neighborConceptConfig = neighborConfig
										.getDestinationConceptConfig();
								boolean internalContext = false;
								if (neighborConfig.isInternal()) {
									internalContext = true;
								}
								ModelibraFrame entityTableFrame = new EntityTableFrame(
										internalContext,
										displayOnly,
										modelSession,
										neighborEntities,
										neighborConceptConfig
												.getPropertiesConfig()
												.getEssentialPropertyConfigList(),
										neighborConceptConfig
												.getNeighborsConfig().getList(),
										natLang);
								contentFrame.displayDownRight(entityTableFrame);
								contentFrame.addChildFrame(entityTableFrame);
							}
						}
					}
				});
			} // if
		} // if
	}

	protected void setButtonName(NeighborConfig neighborConfig, NatLang natLang) {
		setText(natLang.getText(neighborConfig.getConceptConfig().getCode()
				+ "." + neighborConfig.getCode()));
	}

	protected abstract IEntity<?> getEntity();

}