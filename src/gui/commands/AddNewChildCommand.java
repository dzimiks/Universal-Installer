package gui.commands;

import gui.model.MainModel;
import gui.model.Parameter;
import gui.model.tree.Node;

/**
 * Komanda koja dodaje novo dete cvoru i osvezava stablo.
 * 
 * @author Vanja Paunovic
 *
 */
public class AddNewChildCommand extends Command {

	private Node node;
	
	public AddNewChildCommand(MainModel model, Node node) {
		this.model = model;
		this.node = node;
	}
	
	@Override
	public void doCommand() {
		if (node instanceof Parameter)
			return;

		Node child = this.node.addNewChild();
		model.getTreeModel().reload();
		Invoker.getInstance().executeCommand(new TreeSelectCommand(model, child));
	}
}