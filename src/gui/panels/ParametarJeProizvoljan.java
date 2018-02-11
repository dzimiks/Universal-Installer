package gui.panels;

import java.awt.GridBagConstraints;
import gui.panels.custom.*;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import gui.model.Parameter;
import gui.panels.custom.BirajPanel;

public class ParametarJeProizvoljan extends JPanel {

	private GlavniPanel jp;

	public ParametarJeProizvoljan(Parameter p) {

		jp = p.getComponent();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;

		this.add(new BirajPanel(jp), c);

		c.gridx = 0;
		c.gridy = 1;

		this.add(jp, c);

	}

	public GlavniPanel getJp() {
		return jp;
	}

}
