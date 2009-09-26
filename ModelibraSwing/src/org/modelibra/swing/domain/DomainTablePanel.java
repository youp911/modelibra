package org.modelibra.swing.domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.modelibra.ModelSession;
import org.modelibra.config.DomainConfig;
import org.modelibra.swing.widget.ModelibraPanel;
import org.modelibra.util.NatLang;

@SuppressWarnings("serial")
public class DomainTablePanel extends ModelibraPanel {

	private DomainTable domainTable;

	public DomainTablePanel(final ModelSession modelSession,
			final List<DomainConfig> domainConfigList, final NatLang natLang) {
		DomainTableModel domainTableModel = new DomainTableModel(
				domainConfigList) {
			protected String getText(String key) {
				return natLang.getText(key);
			}
		};
		domainTable = new DomainTable(domainTableModel);
		domainTable.setSelectedRow(0);

		setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(domainTable);
		add(scrollPane, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public DomainTable getDomainTable() {
		return domainTable;
	}

}
