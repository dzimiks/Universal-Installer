package gui.commands;

import gui.model.MainModel;
import gui.model.Workspace;
import gui.model.tree.Node;

/**
 * Komanda koja brise cvor i osvezava stablo.
 * 
 * @author Vanja Paunovic
 *
 */
public class DeleteCommand extends Command {

	private Node node;
	
	public DeleteCommand(MainModel model, Node node) {
		this.model = model;
		this.node = node;
	}
	
	@Override
	public void doCommand() {
		if (node instanceof Workspace || node == null)
			return;
		
		Node parent = (Node) node.getParent();
		node.removeFromParent();
		model.getTreeModel().reload();
		Invoker.getInstance().executeCommand(new TreeSelectCommand(model, parent));
	}
}