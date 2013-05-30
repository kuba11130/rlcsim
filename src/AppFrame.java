import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import as.rlcsim.components.table.model.ModelDanych;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	Vector<ModelDanych> dane = new Vector<>();
	public AppFrame() {
		Object[] columnNames = { "Type", "Company", "Shares", "Price",
				"Boolean" };
		Object[][] data = {
				{ "Buy", "IBM", new Integer(1000), new Double(80.50), false },
				{ "Sell", "MicroSoft", new Integer(2000), new Double(6.25),
						true },
				{ "Sell", "Apple", new Integer(3000), new Double(7.35), true },
				{ "Buy", "Nortel", new Integer(4000), new Double(20.00), false } };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		DefaultTableModel m = new DefaultTableModel(dane, 3);
		table = new JTable(m) {
			private static final long serialVersionUID = 1L;

			/*
			 * @Override public Class getColumnClass(int column) { return
			 * getValueAt(0, column).getClass(); }
			 */
			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return Integer.class;
				case 3:
					return Double.class;
				default:
					return Boolean.class;
				}
			}
		};
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				AppFrame frame = new AppFrame();
				frame.addData("sadf", false, 3);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.pack();
				frame.setLocation(150, 150);
				frame.setVisible(true);
			}
		});
	}

	private void addData(String str, Boolean rdb, Integer itg) {
		ModelDanych mod = new ModelDanych();
		mod.add(str, rdb, itg);
		dane.add(mod);
	}
}