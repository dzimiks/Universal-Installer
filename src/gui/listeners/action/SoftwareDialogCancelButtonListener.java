package gui.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.dialogs.SoftwareDialog;

/**
 * Listener za cancel dugme SoftwareDialog-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class SoftwareDialogCancelButtonListener implements ActionListener {

	private SoftwareDialog dialog;
	
	public SoftwareDialogCancelButtonListener(SoftwareDialog dialog) {
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.setVisible(false);
	}
}