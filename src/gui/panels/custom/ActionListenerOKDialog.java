package gui.panels.custom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import gui.view.MainView;

public class ActionListenerOKDialog implements ActionListener {

	private Dijalog d;
	private GlavniPanel gp;
	private Addable tip;
	public ActionListenerOKDialog(Dijalog d, GlavniPanel gp, Addable tip) {
		super();
		this.d = d;
		this.gp = gp;
		this.tip = tip;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gp.dodajStavku(tip, d);
		d.setVisible(false);
		JPanel jp = MainView.getInstance().getPanRight();
		MainView.getInstance().getSplitPane().remove(jp);
		MainView.getInstance().getSplitPane().add(jp);
		
	}

}
