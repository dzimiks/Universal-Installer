package gui.listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


/**
 * Dijalog koji se pojavljuje pri izlasku iz programa.
 * 
 * @author Vanja Paunovic
 *
 */
public class ExitListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		JFrame frame = (JFrame) e.getComponent();
		int code = JOptionPane.showConfirmDialog(frame, "Da li ste sigurni da želite da zatvorite aplikaciju?", 
												 "Zatvaranje aplikacije?", JOptionPane.YES_NO_OPTION);
		if (code != JOptionPane.YES_OPTION)
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		else
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
}