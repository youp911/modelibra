package org.modelibra.swing.domain.model;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.modelibra.ModelSession;
import org.modelibra.config.ConceptConfig;
import org.modelibra.config.ModelConfig;
import org.modelibra.swing.app.App;
import org.modelibra.swing.app.IConstants;
import org.modelibra.swing.domain.model.concept.ConceptTablePanel;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class ModelEntryConceptsTableFrame extends ModelibraFrame implements
		ListSelectionListener, IConstants {

	private ModelSession modelSession;

	private NatLang natLang;

	private Container container;

	private ModelTable modelTable;

	private ModelTablePanel modelTablePanel;

	private ConceptTablePanel entryConceptTablePanel;

	public ModelEntryConceptsTableFrame(App app, ModelSession modelSession,
			List<ModelConfig> modelConfigList, NatLang natLang) {
		super(app);
		this.modelSession = modelSession;
		this.natLang = natLang;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		setTitle(natLang.getText("Models"));
		container = getContentPane();
		ModelTablePanel modelTablePanel = new ModelTablePanel(this,
				modelSession, modelConfigList, natLang);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(modelTablePanel);

		if (modelConfigList.isEmpty()) {
			entryConceptTablePanel = new ConceptTablePanel(this, modelSession,
					new ArrayList<ConceptConfig>(), natLang);
		} else {
			ModelConfig modelConfig = modelConfigList.get(0);
			List<ConceptConfig> entryConceptConfigList = modelConfig
					.getConceptsConfig().getEntryConceptConfigList();
			entryConceptTablePanel = new ConceptTablePanel(this, modelSession,
					entryConceptConfigList, natLang);
		}
		container.add(entryConceptTablePanel);

		modelTable = modelTablePanel.getModelTable();
		modelTable.getSelectionModel().addListSelectionListener(this);

		setSize(FRAME_SIZE);
	}

	// implemented from ListSelectionListener
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == modelTable) {
			ModelConfig modelConfig = modelTable.getCurrentModelConfig();
			if (modelConfig != null) {
				container.remove(entryConceptTablePanel);
				List<ConceptConfig> entryConceptConfigList = modelConfig
						.getConceptsConfig().getEntryConceptConfigList();
				entryConceptTablePanel = new ConceptTablePanel(this,
						modelSession, entryConceptConfigList, natLang);
				container.add(entryConceptTablePanel);
			}
		}
	}

}
