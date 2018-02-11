package gui.commands;

import gui.model.MainModel;
import gui.model.Software;
import gui.model.tree.Node;

/**
 * Komanda koja dodaje novi modul i osvezava stablo.
 * 
 * @author Vanja Paunovic
 *
 */
public class AddNewModuleCommand extends Command {

	private Node node;
	
	public AddNewModuleCommand(MainModel model, Node node) {
		this.model = model;
		this.node = node;
	}
	
	@Override
	public void doCommand() {
		if (node instanceof Software) {
			Node child = this.node.addNewChild();
			model.getTreeModel().reload();
			Invoker.getInstance().executeCommand(new TreeSelectCommand(model, child));
		}
		else return;
	}
}