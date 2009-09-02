package org.modelibra.swing.domain;

import org.modelibra.config.DomainConfig;
import org.modelibra.swing.ModelibraTable;

@SuppressWarnings("serial")
public class DomainTable extends ModelibraTable {

	private DomainTableModel domainTableModel;

	public DomainTable(DomainTableModel domainDisplayTableModel) {
		super(domainDisplayTableModel);
		this.domainTableModel = domainDisplayTableModel;
	}

	public DomainConfig getCurrentDomainConfig() {
		int selectedRow = getSelectedRow();
		if (selectedRow >= 0) {
			return domainTableModel.getDomainsConfigList().get(selectedRow);
		}
		return null;
	}

}
