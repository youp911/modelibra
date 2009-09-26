package org.modelibra.swing.domain.model.concept.entity.property;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.ModelSession;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.swing.widget.ModelibraPanel;
import org.modelibra.type.PropertyClass;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityPropertyWidgetPanel extends ModelibraPanel {

	private ModelibraFrame contentFrame;

	private JLabel messageLabel;

	private PropertyConfig propertyConfig;

	public EntityPropertyWidgetPanel(ModelibraFrame contentFrame,
			boolean displayOnly, boolean add, ModelSession modelSession,
			IEntities<?> entities, IEntity<?> entity,
			PropertyConfig propertyConfig, NatLang natLang) {
		this.contentFrame = contentFrame;
		this.propertyConfig = propertyConfig;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		addPropertyLabels(propertyConfig, natLang);
		addPropertyWidget(contentFrame, displayOnly, add, modelSession,
				entities, entity, propertyConfig, natLang);
	}

	protected void addPropertyLabels(PropertyConfig propertyConfig,
			NatLang natLang) {
		JPanel messagePanel = new JPanel();
		messagePanel.add(new JLabel(natLang.getText(propertyConfig
				.getConceptConfig().getCode()
				+ "." + propertyConfig.getCode())
				+ ": "));
		messageLabel = new JLabel("");
		messagePanel.add(messageLabel);
		add(messagePanel);
	}

	protected void addPropertyWidget(ModelibraFrame contentFrame,
			final boolean displayOnly, final boolean add,
			final ModelSession modelSession, final IEntities<?> entities,
			final IEntity<?> entity, final PropertyConfig propertyConfig,
			final NatLang natLang) {
		if (propertyConfig.getPropertyClass()
				.equals(PropertyClass.getBoolean())) {
			add(new EntityPropertyCheckBox(displayOnly, add, modelSession,
					entities, entity, propertyConfig) {
				protected void message(String key) {
					setMessage(natLang.getText(key) + " "
							+ getErrorMsgsByKeys(entities, natLang));
				}
			});
		} else if (propertyConfig.getPropertyClass().equals(
				PropertyClass.getString())
				&& propertyConfig.isScramble()) {
			add(new EntityPropertyPasswordField(displayOnly, add, modelSession,
					entities, entity, propertyConfig) {
				protected void message(String key) {
					setMessage(natLang.getText(key) + " "
							+ getErrorMsgsByKeys(entities, natLang));
				}
			});
		} else if (propertyConfig.getPropertyClass().equals(
				PropertyClass.getString())
				&& propertyConfig.getDisplayLengthInt() > MIN_LONG_TEXT_LENGTH) {
			add(new EntityPropertyLongTextPanel(contentFrame, displayOnly, add,
					modelSession, entities, entity, propertyConfig, natLang));
		} else {
			add(new EntityPropertyTextField(displayOnly, add, modelSession,
					entities, entity, propertyConfig) {
				protected void message(String key) {
					setMessage(natLang.getText(key) + " "
							+ getErrorMsgsByKeys(entities, natLang));
				}
			});
		}
	}

	private void setMessage(String message) {
		messageLabel.setText(message);
		contentFrame.pack();
	}

	public String getPropertyName() {
		return propertyConfig.getCode();
	}

}
