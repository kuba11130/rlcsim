package as.rlcsim.components.table.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModelTabeli extends AbstractTableModel {

	private java.util.List<ModelDanych> daneTabeli = null;
	private static final long serialVersionUID = 1L;
	private String[] nazwy = { "numer", "nazwa", "usun" };

	public ModelTabeli() {
	}

	@Override
	public int getColumnCount() {

		return nazwy.length;
	}

	@Override
	public int getRowCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {

		ModelDanych model = daneTabeli.get(rowIndex);
		switch (colIndex) {
		case 0:
			return model.getNumer();
		case 1:
			return model.getNazwa();
		case 2:
			return model.getUsun();

		default:
			return model;
		}
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return super.getColumnClass(arg0);
	}

	@Override
	public String getColumnName(int column) {
		return nazwy[column].toString();
	}

	/**
	 * @return the daneTabeli
	 */
	public java.util.List<ModelDanych> getDaneTabeli() {
		return daneTabeli;
	}

	/**
	 * @param daneTabeli
	 *            the daneTabeli to set
	 */
	public void setDaneTabeli(java.util.List<ModelDanych> daneTabeli) {
		this.daneTabeli = daneTabeli;
	}

	public void add(String str, Boolean rdb, Integer itg) {
		ModelDanych mdl = new ModelDanych();
		mdl.add(str, rdb, itg);
		daneTabeli = new ArrayList<>();
		daneTabeli.add(mdl);
	}

}
