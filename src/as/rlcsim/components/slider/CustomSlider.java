package as.rlcsim.components.slider;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import as.rlcsim.lex.Lex;

public class CustomSlider extends JPanel implements ChangeListener,
		ActionListener {

	private static final long serialVersionUID = 1L;

	JSlider slider;
	JButton addButton = new JButton("*10");
	JButton subButton = new JButton("/10");
	JLabel label = new JLabel();
	double mnoznik = 1;
	int licznik = 0;
	double value;
	String jednostka;

	public CustomSlider(String arg0, String arg1) {
		jednostka = arg1;
		slider = new JSlider(1, 100, 50);
		slider.setOrientation(JSlider.VERTICAL);
		slider.addChangeListener(this);
		addButton.addActionListener(this);
		subButton.addActionListener(this);
		value = 5 * mnoznik;
		refreshLabel();

		TitledBorder border = BorderFactory.createTitledBorder(arg0);
		Box box = Box.createVerticalBox();
		box.setBorder(border);
		box.add(label);
		box.add(addButton);
		box.add(slider);
		box.add(subButton);

		this.setLayout(new FlowLayout());
		this.add(box);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Object source = e.getSource();
		if (source.equals(slider)) {
			value = this.getValue();
		}
		refreshLabel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source.equals(addButton)) {
			if (licznik < 10) {
				licznik++;
				mnoznik = Math.pow(10, licznik);
			}
		}
		if (source.equals(subButton)) {
			if (licznik > -10) {
				licznik--;
				mnoznik = Math.pow(10, licznik);
			}
		}
		value = this.getValue();
		refreshLabel();
	}

	public void refreshLabel() {
		label.setText("" + Lex.addUnit(value) + jednostka);
	}

	public double getValue() {
		return slider.getValue() * mnoznik;
	}

	public static void main(String[] args) {
		JFrame fr = new JFrame();
		fr.setLayout(new FlowLayout());
		CustomSlider sl = new CustomSlider("taka nazwa", "F");
		fr.add(sl);

		fr.setSize(300, 300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
}
