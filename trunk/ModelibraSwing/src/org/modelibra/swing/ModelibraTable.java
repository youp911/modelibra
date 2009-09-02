package org.modelibra.swing;

import javax.swing.JTable;

@SuppressWarnings("serial")
public abstract class ModelibraTable extends JTable {

	public ModelibraTable(ModelibraTableModel modelibraTableModel) {
		super(modelibraTableModel);
	}
	
	public void setSelectedRow(int ix) {
		if (getRowCount() <= 0)
			return;
		if (ix < 0) {
			ix = getSelectedRow();
		}
		if ((ix >= 0) && (ix <= getRowCount() - 1)) {
			setRowSelectionInterval(ix, ix);
			scrollRectToVisible(getCellRect(ix, 0, true));
		}
	}

}
