package gui.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.dialogs.ModuleDialog;


/**
 * Listener za cancel dugme ModuleDialog-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class ModuleDialogCancelButtonListener implements ActionListener {

	private ModuleDialog dialog;
	
	public ModuleDialogCancelButtonListener(ModuleDialog dialog) {
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.setVisible(false);
	}
}