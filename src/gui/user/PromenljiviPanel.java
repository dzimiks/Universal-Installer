package gui.user;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.model.CopyParameter;
import gui.model.Parameter;
import gui.panels.custom.CustomPanelShow;

public class PromenljiviPanel extends JPanel{
	
	public PromenljiviPanel(CopyParameter p) {
		add(new CustomPanelShow(p.getValue()));
	}
	
/**	public PromenljiviPanel(CopyParameter p1 , CopyParameter p2) {
		add(new CustomPanelShow(p1.getValue()));
		add(new CustomPanelShow(p2.getValue()));
	}
	
	public PromenljiviPanel(CopyParameter p1 , CopyParameter p2 , CopyParameter p3) {
		add(new CustomPanelShow(p1.getValue()));
		add(new CustomPanelShow(p2.getValue()));
		add(new CustomPanelShow(p3.getValue()));
	}
	
	public PromenljiviPanel(CopyParameter p1, CopyParameter p2, CopyParameter p3, CopyParameter p4) {
		add(new CustomPanelShow(p1.getValue()));
		add(new CustomPanelShow(p2.getValue()));
		add(new CustomPanelShow(p3.getValue()));
		add(new CustomPanelShow(p4.getValue()));
	}			**/
}
