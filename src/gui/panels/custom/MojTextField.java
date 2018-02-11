package gui.panels.custom;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MojTextField extends JPanel {

	private JTextField tf;
	private JButton btnDelete;
	
	public MojTextField(String text){
		
		
		tf = new JTextField(text);
		
		tf.setPreferredSize(new Dimension(150, 30));
		
		btnDelete = new JButton("X");
		
		btnDelete.addActionListener(new ActionListenerDeleteItem(this));
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		add(tf);
		add(btnDelete);
		
	}

	public JTextField getTf() {
		return tf;
	}
	
}
