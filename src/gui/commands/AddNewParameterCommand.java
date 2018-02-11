package gui.commands;

import gui.model.MainModel;
import gui.model.Module;
import gui.model.tree.Node;

/**
 * Komanda koja dodaje novi parametar i osvezava stablo.
 * 
 * @author Vanja Paunovic
 *
 */
public class AddNewParameterCommand extends Command {

	private Node node;
	
	public AddNewParameterCommand(MainModel model, Node node) {
		this.model = model;
		this.node = node;
	}
	
	@Override
	public void doCommand() {
		if (node instanceof Module) {
			Node child = this.node.addNewChild();
			model.getTreeModel().reload();
			Invoker.getInstance().executeCommand(new TreeSelectCommand(model, child));
		}
		else return;
	}
}