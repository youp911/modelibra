package org.modelibra.swing.domain.model.concept.entity;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import org.modelibra.IEntities;
import org.modelibra.ModelSession;
import org.modelibra.config.NeighborConfig;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.ModelibraFrame;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityTableFrame extends ModelibraFrame {

	public EntityTableFrame(boolean internalContext, boolean displayOnly,
			ModelSession modelSession, IEntities<?> entities,
			List<PropertyConfig> propertyConfigList,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		addTitle(entities, natLang);
		addEntityTable(internalContext, displayOnly, modelSession, entities,
				propertyConfigList, neighborConfigList, natLang);
		pack();
	}

	protected void addTitle(IEntities<?> entities, NatLang natLang) {
		setTitle(natLang.getText(entities.getConceptConfig().getEntitiesCode()));
	}

	protected void addEntityTable(boolean internalContext, boolean displayOnly,
			ModelSession modelSession, IEntities<?> entities,
			List<PropertyConfig> propertyConfigList,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		EntityTablePanel entityTablePanel = new EntityTablePanel(
				internalContext, this, displayOnly, modelSession, entities,
				propertyConfigList, neighborConfigList, natLang);
		container.add(entityTablePanel);
	}

}
