package gui.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import gui.model.Module;
import gui.model.Parameter;

public class ParametarJeStart extends JPanel {
	
	private JCheckBox cb;
	
	public ParametarJeStart(Parameter p){
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		cb = new JCheckBox("Pokrenuti " +((Module)p.getParent()).getName());		
		cb.setPreferredSize(new Dimension(200, 30));
		
		if(p.getValue() != null && p.getValue().equals("true")){
			cb.setSelected(true);
		}else{
			cb.setSelected(false);
		}
		add(cb);
	}

	public JCheckBox getCb() {
		return cb;
	}

	public void setCb(JCheckBox cb) {
		this.cb = cb;
	}
	
	
}
