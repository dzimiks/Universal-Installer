package gui.panels.custom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Dijalog extends JDialog {

	private JTextField tf;

	public Dijalog(Addable tip, GlavniPanel panel) {
//		setLayout(new BorderLayout(10, 10));
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 0;
		c.gridy = 0;
		setLocationRelativeTo(null);
		setSize(new Dimension(300, 170));
		
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(150, 30));
		tf.setMinimumSize(new Dimension(150, 30));
		tf.setMaximumSize(new Dimension(150, 30));
		switch (tip) {
		case LABEL:
			add(new JLabel("Naziv labele:"), c);
			break;
		case TEXTFIELD:
			add(new JLabel("Pocetno stanje u tekstfield-u:"), c);
			break;
		case CHECKBOX:
			add(new JLabel("Naziv checkbox-a"), c);
			break;
		}
		c.gridy++;
		add(tf, c);
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListenerOKDialog(this, panel, tip));
		c.gridy++;
		add(btnOK, c);
	}

	public JTextField getTf() {
		return tf;
	}

}
