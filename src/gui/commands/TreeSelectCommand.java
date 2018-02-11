package gui.commands;

import gui.model.MainModel;
import gui.model.tree.Node;

/**
 * Komanda koja ukazuje na dogadjaj selekcije u stablu.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreeSelectCommand extends Command {

	private Node node;
	
	public TreeSelectCommand(MainModel model, Node node) {
		this.model = model;
		this.node = node;
	}

	@Override
	public void doCommand() {
		model.doTreeSelection(node);
	}
}