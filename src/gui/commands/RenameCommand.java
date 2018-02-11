package gui.commands;

import gui.model.MainModel;
import gui.model.tree.Node;

/**
 * Komanda koja preimenuje cvor i osvezava stablo.
 * 
 * @author Vanja Paunovic
 *
 */
public class RenameCommand extends Command {

	private Node node;
	
	public RenameCommand(MainModel model, Node node) {
		this.model = model;
		this.node = node;
	}

	@Override
	public void doCommand() {
		try {
			model.doTreeRename(node);
		}
		catch (NullPointerException e) {
			
		}
	}
}