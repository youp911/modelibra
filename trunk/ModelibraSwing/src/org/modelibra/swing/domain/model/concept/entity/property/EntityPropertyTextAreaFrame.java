package org.modelibra.swing.domain.model.concept.entity.property;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.ModelSession;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.app.IAppConstants;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityPropertyTextAreaFrame extends ModelibraFrame {

	public EntityPropertyTextAreaFrame(boolean displayOnly, boolean add,
			ModelSession modelSession, IEntities<?> entities,
			IEntity<?> entity, PropertyConfig propertyConfig, NatLang natLang) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		addTitle(natLang);
		addPropertyTextArea(displayOnly, add, modelSession, entities, entity,
				propertyConfig, natLang);
		setSize(IAppConstants.FRAME_WIDTH,
				IAppConstants.FRAME_HEIGHT);
	}

	protected void addTitle(NatLang natLang) {
		setTitle(natLang.getText("text"));
	}

	protected void addPropertyTextArea(boolean displayOnly, boolean add,
			ModelSession modelSession, IEntities<?> entities,
			IEntity<?> entity, PropertyConfig propertyConfig, NatLang natLang) {
		Container container = getContentPane();
		container.add(new EntityPropertyTextAreaPanel(this, displayOnly, add,
				modelSession, entities, entity, propertyConfig, natLang));
	}

}
