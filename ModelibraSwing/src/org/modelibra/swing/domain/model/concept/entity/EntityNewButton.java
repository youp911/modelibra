package org.modelibra.swing.domain.model.concept.entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.ModelSession;
import org.modelibra.config.ConceptConfig;
import org.modelibra.swing.ModelibraButton;
import org.modelibra.swing.ModelibraFrame;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityNewButton extends ModelibraButton {

	public EntityNewButton(final boolean internalContext,
			final ModelibraFrame contentFrame, final ModelSession modelSession,
			final IEntities<?> entities, final NatLang natLang) {
		setButtonName(natLang);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConceptConfig conceptConfig = entities.getConceptConfig();
				EntityBridge entityBridge = new EntityBridge(entities,
						conceptConfig.getPropertiesConfig().getList(),
						conceptConfig.getNeighborsConfig()
								.getParentConfigList());
				IEntity<?> defaultEntity = entityBridge.createDefaultEntity();
				if (defaultEntity != null) {
					ModelibraFrame modelibraFrame = new EntityAttributesFrame(
							internalContext, false, true, modelSession,
							entities, defaultEntity, defaultEntity
									.getConceptConfig().getPropertiesConfig()
									.getPropertyConfigWithoutReferenceList(),
							defaultEntity.getConceptConfig()
									.getNeighborsConfig().getList(), natLang);
					contentFrame.displayDownRight(modelibraFrame);
					contentFrame.addChildFrame(modelibraFrame);
				}
			}
		});
	}

	protected void setButtonName(NatLang natLang) {
		setText(natLang.getText("new"));
	}

}
