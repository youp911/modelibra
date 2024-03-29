package org.modelibra.swing.domain.model.concept.entity.property;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.action.EntitiesAction;
import org.modelibra.action.UpdateAction;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.widget.ModelibraFrame;

@SuppressWarnings("serial")
public abstract class EntityPropertyCheckBox extends JCheckBox {

	private PropertyBridge propertyBridge;

	public EntityPropertyCheckBox(final ModelibraFrame contentFrame,
			final boolean displayOnly, final boolean add,
			final IEntities<?> entities, final IEntity<?> entity,
			final PropertyConfig propertyConfig) {
		if (add) {
			propertyBridge = new PropertyBridge(entity, propertyConfig);
		} else {
			propertyBridge = new PropertyBridge(entity.copy(), propertyConfig);
		}
		setSelected(propertyBridge.getBooleanProperty());
		if (displayOnly) {
			setEnabled(false);
		}
		if (propertyBridge.getPropertyConfig().isUpdate()) {
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					boolean propertyValueBolean = isSelected();
					propertyBridge.setProperty(propertyValueBolean);
					if (propertyBridge.isSetProperty()) {
						if (add) {
							message("accepted");
						} else {
							message("empty");
							EntitiesAction action = new UpdateAction(
									contentFrame.getApp().getModelSession(),
									entities, entity, propertyBridge
											.getEntity());
							action.execute();
							if (!action.isExecuted()) {
								message("updateNot");
							}
						}
					} else {
						message("invalidType");
					}
				}
			});
		}
	}

	public String getPropertyName() {
		return propertyBridge.getPropertyName();
	}

	protected abstract void message(String key);

}
