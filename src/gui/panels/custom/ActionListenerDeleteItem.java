package gui.panels.custom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class ActionListenerDeleteItem implements ActionListener{
	
	private JPanel jp;
	public ActionListenerDeleteItem(JPanel jp) {
		// TODO Auto-generated constructor stub
		this.jp = jp;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jp.setVisible(false);
		//TODO ovo radi
//		
//		JPanel p = ((ParameterPanel)MainView.getInstance().getPanRight()).getPanel();
//		ParametarJeProizvoljan r = (ParametarJeProizvoljan)p;
//		r.getJp().remove(jp);
//		MainView.getInstance().getSplitPane().remove(jp);
//		MainView.getInstance().getSplitPane().add(jp);
	}

}
