package gui.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.dialogs.ParameterDialog;

/**
 * Listener za cancel dugme ParameterDialog-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class ParameterDialogCancelButtonListener implements ActionListener {

	private ParameterDialog dialog;
	
	public ParameterDialogCancelButtonListener() {
		this.dialog = ParameterDialog.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.setVisible(false);
	}
}