package org.modelibra.swing.domain.model.concept.entity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.ModelSession;
import org.modelibra.config.NeighborConfig;
import org.modelibra.config.PropertyConfig;
import org.modelibra.exception.ModelibraRuntimeException;
import org.modelibra.swing.domain.model.concept.entity.neighbor.EntityNeighborButton;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.swing.widget.ModelibraPanel;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityTablePanel extends ModelibraPanel {

	private boolean internalContext;

	private ModelibraFrame contentFrame;

	private JLabel messageLabel;

	private EntityTable entityTable;

	public EntityTablePanel(boolean internalContext,
			ModelibraFrame contentFrame, boolean displayOnly,
			ModelSession modelSession, IEntities<?> entities,
			List<PropertyConfig> propertyConfigList,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		this.internalContext = internalContext;
		this.contentFrame = contentFrame;
		entities.getErrors().empty();
		setLayout(new BorderLayout());

		JPanel messagePanel = new JPanel();
		messageLabel = new JLabel("");
		messagePanel.add(messageLabel);

		if (propertyConfigList.size() == 0) {
			throw new ModelibraRuntimeException(
					"There are no essential properties for this concept.");
		}

		entityTable = createTable(displayOnly, modelSession, entities,
				propertyConfigList, natLang);
		entityTable.setSelectedRow(0);
		JScrollPane tableScrollPane = new JScrollPane(entityTable);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);

		add(messagePanel, BorderLayout.NORTH);
		add(tableScrollPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		addDisplayButton(buttonPanel, contentFrame, modelSession, entities,
				natLang);
		if (!displayOnly) {
			addNewButton(contentFrame, buttonPanel, modelSession, entities,
					natLang);
			addEditButton(buttonPanel, contentFrame, modelSession, entities,
					natLang);
			addRemoveButton(buttonPanel, modelSession, entities, natLang);
		}
		// Neighbor buttons for navigation
		if (neighborConfigList != null) {
			addNeighborButtons(buttonPanel, contentFrame, displayOnly,
					modelSession, neighborConfigList, natLang);
		}
	}

	protected EntityTable createTable(boolean displayOnly,
			ModelSession modelSession, final IEntities<?> entities,
			List<PropertyConfig> propertyConfigList, final NatLang natLang) {
		EntityTableModel entityTableModel = new EntityTableModel(displayOnly,
				modelSession, entities, propertyConfigList) {
			protected String getText(String key) {
				return natLang.getText(key);
			}

			protected void error(String key) {
				setMessage(natLang.getText(key) + " "
						+ getErrorMsgsByKeys(entities, natLang));
			}

			protected void noError() {
				setMessage("");
			}
		};
		return new EntityTable(entityTableModel);
	}

	protected void addDisplayButton(JPanel buttonPanel,
			ModelibraFrame contentFrame, ModelSession modelSession,
			IEntities<?> entities, NatLang natLang) {
		buttonPanel.add(new EntityButton(internalContext, contentFrame, true,
				modelSession, entities, natLang) {
			protected IEntity<?> getEntity() {
				return entityTable.getCurrentEntity();
			}
		});
	}

	protected void addNewButton(ModelibraFrame contentFrame,
			JPanel buttonPanel, ModelSession modelSession,
			final IEntities<?> entities, final NatLang natLang) {
		buttonPanel.add(new EntityNewButton(internalContext, contentFrame,
				modelSession, entities, natLang));
	}

	protected void addEditButton(JPanel buttonPanel,
			ModelibraFrame contentFrame, ModelSession modelSession,
			IEntities<?> entities, NatLang natLang) {
		buttonPanel.add(new EntityButton(internalContext, contentFrame, false,
				modelSession, entities, natLang) {
			protected IEntity<?> getEntity() {
				return entityTable.getCurrentEntity();
			}
		});
	}

	protected void addRemoveButton(JPanel buttonPanel,
			ModelSession modelSession, final IEntities<?> entities,
			final NatLang natLang) {
		buttonPanel
				.add(new EntityRemoveButton(modelSession, entities, natLang) {
					protected IEntity<?> getEntity() {
						return entityTable.getCurrentEntity();
					}

					protected void message(String key) {
						setMessage(natLang.getText(key) + " "
								+ getErrorMsgsByKeys(entities, natLang));
					}
				});
	}

	protected void addNeighborButtons(JPanel buttonPanel,
			ModelibraFrame contentFrame, boolean displayOnly,
			ModelSession modelSession, List<NeighborConfig> neighborConfigList,
			NatLang natLang) {
		for (NeighborConfig neighborConfig : neighborConfigList) {
			buttonPanel.add(new EntityNeighborButton(contentFrame, displayOnly,
					modelSession, neighborConfig, natLang) {
				protected IEntity<?> getEntity() {
					return entityTable.getCurrentEntity();
				}
			});
		}
	}

	public void setMessage(String message) {
		messageLabel.setText(message);
		contentFrame.pack();
	}

}
