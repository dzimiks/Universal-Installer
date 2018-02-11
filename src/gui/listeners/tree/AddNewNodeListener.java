package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.AddNewChildCommand;
import gui.commands.Invoker;
import gui.dialogs.ModuleDialog;
import gui.dialogs.ParameterDialog;
import gui.dialogs.SoftwareDialog;
import gui.model.MainModel;
import gui.model.Module;
import gui.model.Software;
import gui.model.Workspace;
import gui.view.tree.TreePopupMenu;

/**
 * Listener za dodavanje novog cvora u stablo.
 * 
 * @author Vanja Paunovic
 *
 */
public class AddNewNodeListener implements ActionListener {

	private MainModel model;
	private TreePopupMenu popupMenu;
	private SoftwareDialog softwareDialog;
	private ModuleDialog moduleDialog;
	private ParameterDialog parameterDialog;
	
	public AddNewNodeListener(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
		this.softwareDialog = new SoftwareDialog(model);
		this.moduleDialog = new ModuleDialog(model);
		this.parameterDialog = ParameterDialog.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = model.getSelectedObject();
		
		if (obj instanceof Workspace) {
			softwareDialog.setTfName("");
			softwareDialog.setVisible(true);
		}
		else if (obj instanceof Software) {
			moduleDialog.setTfName("");
			moduleDialog.setPath("");
			moduleDialog.setVisible(true);
		}
		else if (obj instanceof Module) {
			parameterDialog.setTfName("");
			parameterDialog.setVisible(true);
		}
		else
			Invoker.getInstance().executeCommand(new AddNewChildCommand(model, popupMenu.getSelectedNode()));
	}
}