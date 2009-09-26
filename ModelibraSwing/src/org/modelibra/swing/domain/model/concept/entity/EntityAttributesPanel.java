package org.modelibra.swing.domain.model.concept.entity;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.modelibra.Entity;
import org.modelibra.IEntities;
import org.modelibra.IEntity;
import org.modelibra.ModelSession;
import org.modelibra.action.AddAction;
import org.modelibra.action.EntitiesAction;
import org.modelibra.config.NeighborConfig;
import org.modelibra.config.PropertyConfig;
import org.modelibra.swing.domain.model.concept.entity.neighbor.EntityNeighborButton;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.swing.widget.ModelibraPanel;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class EntityAttributesPanel extends ModelibraPanel implements Observer {

	private ModelibraFrame contentFrame;

	private JLabel messageLabel;

	private IEntity<?> entity;

	private List<NeighborConfig> neighborConfigList;

	private NatLang natLang;

	public EntityAttributesPanel(boolean internalContext,
			ModelibraFrame contentFrame, boolean displayOnly, boolean add,
			ModelSession modelSession, final IEntities<?> entities,
			IEntity<?> entity, List<PropertyConfig> propertyConfigList,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		this.contentFrame = contentFrame;
		this.entity = entity;
		this.neighborConfigList = neighborConfigList;
		this.natLang = natLang;

		entities.getErrors().empty();

		((Entity<?>) entity).addObserver(this);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		addMessage();
		addProperties(contentFrame, displayOnly, add, modelSession, entities,
				entity, propertyConfigList, natLang);
		addExternalParentLookups(internalContext, displayOnly, add,
				modelSession, entities, entity, neighborConfigList, natLang);
		addNeighborButtons(contentFrame, displayOnly, modelSession, entity,
				neighborConfigList, natLang);
		addAbsorbedParents(entity, neighborConfigList, natLang);
		if (add) {
			addAction(modelSession, entities, entity, natLang);
		}
	}

	protected void addMessage() {
		JPanel messagePanel = new JPanel();
		messageLabel = new JLabel("");
		messagePanel.add(messageLabel);
		add(messagePanel);
	}

	protected void addProperties(ModelibraFrame contextFrame,
			boolean displayOnly, boolean add, ModelSession modelSession,
			IEntities<?> entities, IEntity<?> entity,
			List<PropertyConfig> propertyConfigList, NatLang natLang) {
		add(new EntityPropertiesPanel(contextFrame, displayOnly, add,
				modelSession, entities, entity, propertyConfigList, natLang));
	}

	protected void addExternalParentLookups(boolean internalContext,
			boolean displayOnly, boolean add, ModelSession modelSession,
			IEntities<?> entities, IEntity<?> entity,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		if (!displayOnly) {
			List<NeighborConfig> externalParentNeighborConfigList = getExternalParentNeighborConfigList(
					internalContext, entity, neighborConfigList);
			if (externalParentNeighborConfigList.size() > 0) {
				add(new EntityParentLookupsPanel(add, modelSession, entities,
						entity, externalParentNeighborConfigList, natLang));
			}
		}
	}

	private List<NeighborConfig> getParentNeighborConfigList(
			List<NeighborConfig> neighborConfigList) {
		List<NeighborConfig> parentNeighborConfigList = new ArrayList<NeighborConfig>();
		if (neighborConfigList != null && neighborConfigList.size() > 0) {
			for (NeighborConfig neighborConfig : neighborConfigList) {
				if (neighborConfig.isParent()) {
					parentNeighborConfigList.add(neighborConfig);
				}
			}
		}
		return parentNeighborConfigList;
	}

	private List<NeighborConfig> getExternalParentNeighborConfigList(
			boolean internalContext, IEntity<?> entity,
			List<NeighborConfig> neighborConfigList) {
		List<NeighborConfig> externalParentNeighborConfigList = new ArrayList<NeighborConfig>();
		if (neighborConfigList != null && neighborConfigList.size() > 0) {
			for (NeighborConfig neighborConfig : neighborConfigList) {
				if (neighborConfig.isParent() && neighborConfig.isExternal()) {
					// if
					// (!neighborConfig.getDestinationConceptConfig().equalOid(
					// entity.getConceptConfig())) {
					if (internalContext) {
						externalParentNeighborConfigList.add(neighborConfig);
					}
				}
			}
		}
		return externalParentNeighborConfigList;
	}

	// for all neighbors
	protected void addNeighborButtons(ModelibraFrame contextFrame,
			boolean displayOnly, ModelSession modelSession,
			final IEntity<?> entity, List<NeighborConfig> neighborConfigList,
			NatLang natLang) {
		if (neighborConfigList != null && neighborConfigList.size() > 0) {
			JPanel neighborButtonsPanel = new JPanel();
			for (NeighborConfig neighborConfig : neighborConfigList) {
				neighborButtonsPanel.add(new EntityNeighborButton(contextFrame,
						displayOnly, modelSession, neighborConfig, natLang) {
					protected IEntity<?> getEntity() {
						return entity;
					}
				});
			}
			add(neighborButtonsPanel);
		}
	}

	// absorptions of essential properties of parent neighbors
	protected void addAbsorbedParents(IEntity<?> entity,
			List<NeighborConfig> neighborConfigList, NatLang natLang) {
		List<NeighborConfig> parentNeighborConfigList = getParentNeighborConfigList(neighborConfigList);
		if (parentNeighborConfigList.size() > 0) {
			add(new EntityAbsorbedParentsPanel(entity,
					parentNeighborConfigList, natLang));
		}
	}

	protected void addAction(final ModelSession modelSession,
			final IEntities<?> entities, final IEntity<?> entity,
			final NatLang natLang) {
		JPanel actionPanel = new JPanel();
		add(actionPanel);
		JButton addButton = new JButton(natLang.getText("add"));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMessage(natLang.getText("empty"));
				EntitiesAction action = new AddAction(modelSession, entities,
						entity);
				action.execute();
				if (!action.isExecuted()) {
					setMessage(natLang.getText("addNot") + " "
							+ getErrorMsgsByKeys(entities, natLang));
				} else {
					contentFrame.exit();
				}
			}
		});
		actionPanel.add(addButton);
	}

	private void setMessage(String message) {
		messageLabel.setText(message);
		contentFrame.pack();
	}

	// implemented from Observer
	// see Book.setPersonOid
	public void update(Observable o, Object arg) {
		if (o == entity) {
			if (arg instanceof PropertyConfig) {
				PropertyConfig propertyConfig = (PropertyConfig) arg;
				if (propertyConfig.isReference()) {
					for (Component component : getComponents()) {
						if (component instanceof EntityAbsorbedParentsPanel) {
							remove(component);
						}
					}
					addAbsorbedParents(entity, neighborConfigList, natLang);
					contentFrame.pack();
				}
			}
		}
	}

	// implemented from Observer
	// see Book.setPerson
	// update is not called when setPerson is used instead of setPersonOid
	// public void update(Observable o, Object arg) {
	// if (o == entity) {
	// if (arg instanceof NeighborConfig) {
	// NeighborConfig neighborConfig = (NeighborConfig) arg;
	// if (neighborConfig.isParent()) {
	// for (Component component : getComponents()) {
	// if (component instanceof EntityAbsorbedParentsPanel) {
	// remove(component);
	// }
	// }
	// addAbsorbedParents(entity, neighborConfigList, natLang);
	// contextFrame.pack();
	// }
	// }
	// }
	// }

}
