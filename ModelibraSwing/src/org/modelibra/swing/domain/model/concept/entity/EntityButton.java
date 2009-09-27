package org.modelibra.swing.domain.model.concept.entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.ModelSession;
import org.modelibra.swing.widget.ModelibraButton;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public abstract class EntityButton extends ModelibraButton {

	public EntityButton(final boolean internalContext,
			final ModelibraFrame contentFrame, final boolean displayOnly,
			final ModelSession modelSession, final IEntities<?> entities,
			final NatLang natLang) {
		setButtonName(displayOnly, natLang);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IEntity<?> entity = getEntity();
				if (entity != null) {
					ModelibraFrame modelibraFrame = new EntityAttributesFrame(contentFrame.getApp(),
							internalContext, displayOnly, false, modelSession,
							entities, entity, entity.getConceptConfig()
									.getPropertiesConfig()
									.getPropertyConfigWithoutReferenceList(),
							entity.getConceptConfig().getNeighborsConfig()
									.getList(), natLang);
					contentFrame.displayDownRight(modelibraFrame);
					contentFrame.addChildFrame(modelibraFrame);
				}
			}
		});
	}

	protected void setButtonName(boolean displayOnly, NatLang natLang) {
		if (displayOnly) {
			setText(natLang.getText("display"));
		} else {
			setText(natLang.getText("edit"));
		}
	}

	protected abstract IEntity<?> getEntity();

}
