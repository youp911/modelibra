package org.modelibra.swing.domain.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.modelibra.config.ModelConfig;
import org.modelibra.swing.widget.ModelibraFrame;
import org.modelibra.swing.widget.ModelibraPanel;

@SuppressWarnings("serial")
public class ModelTablePanel extends ModelibraPanel {

	private ModelTable modelTable;

	public ModelTablePanel(final ModelibraFrame contextFrame,
			List<ModelConfig> modelConfigList) {
		ModelTableModel modelDisplayTableModel = new ModelTableModel(
				modelConfigList) {
			protected String getText(String key) {
				return contextFrame.getApp().getNatLang().getText(key);
			}
		};
		modelTable = new ModelTable(modelDisplayTableModel);
		modelTable.setSelectedRow(0);

		setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(modelTable);
		add(scrollPane, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public ModelTable getModelTable() {
		return modelTable;
	}

}
