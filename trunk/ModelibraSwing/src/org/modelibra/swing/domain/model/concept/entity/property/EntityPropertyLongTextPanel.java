package org.modelibra.swing.domain.model.concept.entity.property;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.ModelSession;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.ModelibraFrame;
import org.modelibra.swing.ModelibraPanel;
import org.modelibra.type.PropertyClass;
import org.modelibra.util.NatLang;
import org.modelibra.util.TextHandler;

@SuppressWarnings("serial")
public class EntityPropertyLongTextPanel extends ModelibraPanel {

	public EntityPropertyLongTextPanel(final ModelibraFrame contentFrame,
			boolean displayOnly, boolean add, ModelSession modelSession,
			IEntities<?> entities, IEntity<?> entity,
			PropertyConfig propertyConfig, NatLang natLang) {
		addPropertyLongText(contentFrame, displayOnly, add, modelSession,
				entities, entity, propertyConfig, natLang);
	}

	protected void addPropertyLongText(final ModelibraFrame contextFrame,
			final boolean displayOnly, final boolean add,
			final ModelSession modelSession, final IEntities<?> entities,
			final IEntity<?> entity, final PropertyConfig propertyConfig,
			final NatLang natLang) {
		if (propertyConfig.getPropertyClass().equals(PropertyClass.getString())
				&& propertyConfig.getDisplayLengthInt() > MIN_LONG_TEXT_LENGTH) {
			int displayTextLength = entity.getConceptConfig().getModelConfig()
					.getDomainConfig().getShortTextDefaultLengthInt();
			TextHandler textHandler = new TextHandler();
			String propertyLongText = (String) entity
					.getProperty(propertyConfig.getCode());
			String propertyDisplayText;
			if (propertyLongText != null) {
				propertyDisplayText = textHandler.extractBeginPlusThreeDots(
						propertyLongText, displayTextLength);
			} else {
				propertyDisplayText = "";
			}
			JLabel displayTextLabel = new JLabel(propertyDisplayText);
			add(displayTextLabel);

			JButton textButton = new JButton("...");
			textButton.setPreferredSize(new Dimension(28, 14));
			textButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ModelibraFrame modelibraFrame = new EntityPropertyTextAreaFrame(
							displayOnly, add, modelSession, entities, entity,
							propertyConfig, natLang);
					if (contextFrame == null) {
						displayDownRight(modelibraFrame);
					} else {
						contextFrame.displayDownRight(modelibraFrame);
						contextFrame.addChildFrame(modelibraFrame);
					}
				}
			});
			add(textButton);
		}

	}

}
