package as.rlcsim.components.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import as.rlcsim.components.slider.CustomSlider;
import as.rlcsim.components.table.model.ModelTabeli;

public class Tabela extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable tabela = new JTable();
	private ModelTabeli model = new ModelTabeli();

	public Tabela() {
		tabela.setModel(getModel());
		tabela.setSize(200, 200);
		tabela.setPreferredScrollableViewportSize(new Dimension(200, 200));
		this.setBackground(Color.green);
		this.add(tabela);

		this.setSize(200, 200);
	}

	/**
	 * @return the model
	 */
	public ModelTabeli getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(ModelTabeli model) {
		this.model = model;
	}

	public void addDane(String str, Boolean rdb, Integer itg) {
		model.add(str, rdb, itg);
	}
	public static void main(String[] args) {
		JFrame fr = new JFrame();
		fr.setLayout(new FlowLayout());
		Tabela sl = new Tabela();
		fr.add(sl);

		fr.setSize(300, 300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
}
