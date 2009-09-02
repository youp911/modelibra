package org.modelibra.swing.domain;

import java.util.List;

import org.modelibra.config.DomainConfig;
import org.modelibra.swing.ModelibraTableModel;

@SuppressWarnings("serial")
public abstract class DomainTableModel extends ModelibraTableModel {

	private List<DomainConfig> domainConfigList;

	public DomainTableModel(List<DomainConfig> domainConfigList) {
		this.domainConfigList = domainConfigList;
	}

	public List<DomainConfig> getDomainsConfigList() {
		return domainConfigList;
	}

	private DomainConfig getDomainConfig(int number) {
		return domainConfigList.get(number);
	}

	// implemented from AbstractTableModel
	public int getRowCount() {
		return domainConfigList.size();
	}

	// implemented from AbstractTableModel
	public int getColumnCount() {
		return 2;
	}

	// implemented from AbstractTableModel
	public Object getValueAt(int r, int c) {
		if (c == 0) {
			return getDomainConfig(r).getCode();
		} else if (c == 1) {
			return getDomainConfig(r).getType();
		}
		return null;
	}

	@Override
	public String getColumnName(int c) {
		if (c == 0) {
			return getText("Domain.name");
		} else if (c == 1) {
			return getText("Domain.type");
		}
		return "?";
	}

	protected abstract String getText(String key);

	@Override
	public boolean isCellEditable(int r, int c) {
		return false;
	}

	@Override
	public Class<?> getColumnClass(int c) {
		return String.class;
	}

}
