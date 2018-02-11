package gui.controller.tree;

import gui.listeners.tree.NameFocusListener;
import gui.model.MainModel;
import gui.view.tree.TreeCellEditor;

/**
 * Controller TreeCellEditor-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreeCellEditorController {

	protected MainModel model;
	protected TreeCellEditor view;
	
	public TreeCellEditorController(TreeCellEditor view, MainModel model) {
		this.view = view;
		this.model = model;
		this.view.setNameFocusListener(new NameFocusListener(view));
	}
}