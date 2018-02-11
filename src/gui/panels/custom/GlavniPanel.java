package gui.panels.custom;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GlavniPanel extends JPanel {
	
	public GlavniPanel(){
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
	}
	
	public void dodajStavku(Addable tip, Dijalog d){
		switch (tip) {
		case LABEL:
			add(new MojLabel(d.getTf().getText()));
			break;
		case TEXTFIELD:
			add(new MojTextField(d.getTf().getText()));
			break;
		case CHECKBOX:
			add(new MojCheckBox(d.getTf().getText()));
			break;
		}

	}
	
	public void nevidljiviDugmici(){
		
		for(int i = 0; i < getComponentCount(); i++){
			JPanel c = (JPanel) getComponent(i);
			for(int j = 0; j < c.getComponentCount(); j++){
				if(c.getComponent(j) instanceof JButton){
					((JButton)c.getComponent(j)).setVisible(false);
				}
			}
		}
		
	}
	
	public void vidiljiviDugmici(){
		
		for(int i = 0; i < getComponentCount(); i++){
			JPanel c = (JPanel) getComponent(i);
			for(int j = 0; j < c.getComponentCount(); j++){
				if(c.getComponent(j) instanceof JButton){
					((JButton)c.getComponent(j)).setVisible(true);
				}
			}
		}
		
	}
}
