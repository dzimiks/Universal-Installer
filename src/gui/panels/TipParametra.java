package gui.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.model.Parameter;

public class TipParametra extends JPanel {

	private JTextField tf;

	public TipParametra(Parameter p) {
		
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(200, 30));
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		tf.setEditable(false);
		tf.setText(p.getType().toString());

		add(tf);

	}

	public JTextField getTf() {
		return tf;
	}

	public void setTf(JTextField tf) {
		this.tf = tf;
	}

}
