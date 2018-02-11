package gui.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import gui.model.Parameter;

//TODO sredi sve
public class ParametarJeLanguage extends JPanel {

	private JCheckBox cb1;
	private JCheckBox cb2;
	private JCheckBox cb3;

	public ParametarJeLanguage(Parameter p) {

		cb1 = new JCheckBox("Engleski");
		cb2 = new JCheckBox("Srpski");
		cb3 = new JCheckBox("Ћирилица");

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (p.getValue() != null) {
			String[] s = p.getValue().split("-");
			
			if (s[0].equals("true")) {
				cb1.setSelected(true);
			} else {
				cb1.setSelected(false);
			}
			if (s[1].equals("true")) {
				cb2.setSelected(true);
			} else {
				cb2.setSelected(false);
			}
			if (s[2].equals("true")) {
				cb3.setSelected(true);
			} else {
				cb3.setSelected(false);
			}

		}
		c.gridx = 0;
		c.gridy = 0;
		add(cb1, c);

		c.gridx = 0;
		c.gridy = 1;
		add(cb2, c);

		c.gridx = 0;
		c.gridy = 2;
		add(cb3, c);
	}

	public JCheckBox getCb1() {
		return cb1;
	}

	public JCheckBox getCb2() {
		return cb2;
	}

	public JCheckBox getCb3() {
		return cb3;
	}

}
