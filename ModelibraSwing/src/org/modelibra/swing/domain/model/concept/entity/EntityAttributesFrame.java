package org.modelibra.swing.domain.model.concept.entity;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.ModelSession;
import org.modelibra.config.NeighborConfig;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityAttributesFrame extends ModelibraFrame {

	public EntityAttributesFrame(boolean internalContext, boolean displayOnly,
			boolean add, ModelSession modelSession, IEntities<?> entities,
			IEntity<?> entity, List<PropertyConfig> propertyConfigList,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		addTitle(entity, natLang);
		addAttributes(internalContext, displayOnly, add, modelSession,
				entities, entity, propertyConfigList, neighborConfigList,
				natLang);
		pack();
	}

	protected void addTitle(IEntity<?> entity, NatLang natLang) {
		setTitle(natLang.getText(entity.getConceptConfig().getCode()));
	}

	protected void addAttributes(boolean internalContext, boolean displayOnly,
			boolean add, ModelSession modelSession, IEntities<?> entities,
			IEntity<?> entity, List<PropertyConfig> propertyConfigList,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(new EntityAttributesPanel(internalContext, this,
				displayOnly, add, modelSession, entities, entity,
				propertyConfigList, neighborConfigList, natLang));
	}

}
