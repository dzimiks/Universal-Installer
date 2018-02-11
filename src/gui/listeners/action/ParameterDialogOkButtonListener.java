package gui.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.commands.AddNewParameterCommand;
import gui.commands.Invoker;
import gui.dialogs.ParameterDialog;
import gui.model.MainModel;
import gui.model.Parameter;
import gui.model.tree.Node;

/**
 * Listener za ok dugme ParameterDialog-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class ParameterDialogOkButtonListener implements ActionListener {

	private ParameterDialog dialog;
	private MainModel model;
	
	public ParameterDialogOkButtonListener(MainModel model) {
		this.dialog = ParameterDialog.getInstance();
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (dialog.getTfName() == null || dialog.getTfName().equals("")) {
			JOptionPane.showMessageDialog(null, "Molimo Vas, unesite naziv parametra.", 
					model.getSelectedObject().toString(), JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		Invoker.getInstance().executeCommand(new AddNewParameterCommand(model, (Node) model.getSelectedObject()));
		Parameter node = (Parameter) model.getSelectedObject();
		
		node.setName(dialog.getTfName());
		node.setType(dialog.getCmbType());
		dialog.setVisible(false);
	}
}