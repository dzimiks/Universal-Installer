package gui.panels.custom;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MojLabel extends JPanel{
	
	private JLabel jl;
	private JButton btnDelete;
	
	public MojLabel(String text){
		jl = new JLabel(text);
		
		btnDelete = new JButton("X");
		
		btnDelete.addActionListener(new ActionListenerDeleteItem(this));
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		add(jl);
		add(btnDelete);
		
	}

	public JLabel getJl() {
		return jl;
	}
	
	
}
