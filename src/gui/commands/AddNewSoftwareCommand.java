package gui.commands;

import gui.model.MainModel;
import gui.model.Workspace;
import gui.model.tree.Node;

/**
 * Komanda koja dodaje novi softver i osvezava stablo.
 * 
 * @author Vanja Paunovic
 *
 */
public class AddNewSoftwareCommand extends Command {

	public AddNewSoftwareCommand(MainModel model) {
		this.model = model;
	}
	
	@Override
	public void doCommand() {
		Node child = Workspace.getInstance().addNewChild();
		model.getTreeModel().reload();
		Invoker.getInstance().executeCommand(new TreeSelectCommand(model, child));
	}
}