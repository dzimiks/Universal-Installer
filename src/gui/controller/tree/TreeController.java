package gui.controller.tree;

import gui.listeners.tree.RightClickListener;
import gui.model.MainModel;
import gui.view.tree.TreeView;

/**
 * Controller stabla.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreeController {

	public MainModel model;
	public TreeView treeView;
	
	public TreeController(MainModel model, TreeView treeView) {
		this.model = model;
		this.treeView = treeView;
		this.treeView.addTreeListener(new RightClickListener(model, treeView));
	}
}