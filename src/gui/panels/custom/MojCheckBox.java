package gui.panels.custom;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MojCheckBox extends JPanel{
	
	private JCheckBox cb;
	private JButton btnDelete;
	
	public MojCheckBox(String text){
		cb = new JCheckBox(text);
		cb.setSize(new Dimension(150, 30));
		btnDelete = new JButton("X");
		
		btnDelete.addActionListener(new ActionListenerDeleteItem(this));
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		add(cb);
		add(btnDelete);
	}

	public JCheckBox getCb() {
		return cb;
	}
	
	
	
}
