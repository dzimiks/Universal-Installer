package gui.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.commands.AddNewSoftwareCommand;
import gui.commands.Invoker;
import gui.dialogs.SoftwareDialog;
import gui.model.MainModel;
import gui.model.Software;
import gui.model.tree.Node;

/**
 * Listener za ok dugme SoftwareDialog-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class SoftwareDialogOkButtonListener implements ActionListener {

	private SoftwareDialog dialog;
	private MainModel model;
	
	public SoftwareDialogOkButtonListener(SoftwareDialog dialog, MainModel model) {
		this.dialog = dialog;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (dialog.getTfName() == null || dialog.getTfName().equals("")) {
			JOptionPane.showMessageDialog(null, "Molimo Vas, unesite naziv softvera.", 
					model.getSelectedObject().toString(), JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		Invoker.getInstance().executeCommand(new AddNewSoftwareCommand(model));
		Node node = (Software) model.getSelectedObject();
		node.setName(dialog.getTfName());
		dialog.setVisible(false);
	}
}