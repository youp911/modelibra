package org.modelibra.swing.domain;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.modelibra.ModelSession;
import org.modelibra.config.ConceptConfig;
import org.modelibra.config.DomainConfig;
import org.modelibra.config.ModelConfig;
import org.modelibra.swing.domain.model.ModelTable;
import org.modelibra.swing.domain.model.ModelTablePanel;
import org.modelibra.swing.domain.model.concept.ConceptTablePanel;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class DomainModelsTableFrame extends ModelibraFrame implements
		ListSelectionListener {

	public static final int FRAME_WIDTH = 400;
	public static final int FRAME_HEIGHT = 400;
	public static final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH,
			FRAME_HEIGHT);

	private ModelSession modelSession;

	private NatLang natLang;

	private Container container;

	private DomainTable domainTable;

	private ModelTable modelTable;

	private ModelTablePanel modelTablePanel;

	private ConceptTablePanel entryConceptTablePanel;

	public DomainModelsTableFrame(ModelSession modelSession,
			List<DomainConfig> domainConfigList, NatLang natLang) {
		this.modelSession = modelSession;
		this.natLang = natLang;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		setTitle(natLang.getText("Domains"));
		container = getContentPane();
		DomainTablePanel domainTablePanel = new DomainTablePanel(modelSession,
				domainConfigList, natLang);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(domainTablePanel);

		if (domainConfigList.isEmpty()) {
			modelTablePanel = new ModelTablePanel(this, modelSession,
					new ArrayList<ModelConfig>(), natLang);
			entryConceptTablePanel = new ConceptTablePanel(this, modelSession,
					new ArrayList<ConceptConfig>(), natLang);
		} else {
			DomainConfig domainConfig = domainConfigList.get(0);
			List<ModelConfig> modelConfigList = domainConfig.getModelsConfig()
					.getList();
			modelTablePanel = new ModelTablePanel(this, modelSession,
					modelConfigList, natLang);
			if (modelConfigList.isEmpty()) {
				entryConceptTablePanel = new ConceptTablePanel(this,
						modelSession, new ArrayList<ConceptConfig>(), natLang);
			} else {
				ModelConfig modelConfig = modelConfigList.get(0);
				List<ConceptConfig> entryConceptConfigList = modelConfig
						.getConceptsConfig().getEntryConceptConfigList();
				entryConceptTablePanel = new ConceptTablePanel(this,
						modelSession, entryConceptConfigList, natLang);
			}

		}
		container.add(modelTablePanel);
		container.add(entryConceptTablePanel);

		domainTable = domainTablePanel.getDomainTable();
		domainTable.getSelectionModel().addListSelectionListener(this);

		modelTable = modelTablePanel.getModelTable();
		modelTable.getSelectionModel().addListSelectionListener(this);

		setSize(FRAME_SIZE);
	}

	// implemented from ListSelectionListener
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == domainTable) {
			DomainConfig domainConfig = domainTable.getCurrentDomainConfig();
			if (domainConfig != null) {
				container.remove(modelTablePanel);
				container.remove(entryConceptTablePanel);
				List<ModelConfig> modelConfigList = domainConfig
						.getModelsConfig().getList();
				modelTablePanel = new ModelTablePanel(this, modelSession,
						modelConfigList, natLang);
				if (modelConfigList.isEmpty()) {
					entryConceptTablePanel = new ConceptTablePanel(this,
							modelSession, new ArrayList<ConceptConfig>(),
							natLang);
				} else {
					ModelConfig modelConfig = modelConfigList.get(0);
					List<ConceptConfig> entryConceptConfigList = modelConfig
							.getConceptsConfig().getEntryConceptConfigList();
					entryConceptTablePanel = new ConceptTablePanel(this,
							modelSession, entryConceptConfigList, natLang);
				}
				container.add(modelTablePanel);
				container.add(entryConceptTablePanel);
				validate();
			}
		} else if (e.getSource() == modelTable) {
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
