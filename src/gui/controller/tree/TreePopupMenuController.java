package gui.controller.tree;

import gui.listeners.tree.AddNewNodeListener;
import gui.listeners.tree.DeleteNodeListener;
import gui.listeners.tree.RenameNodeListener;
import gui.model.MainModel;
import gui.view.tree.TreePopupMenu;

/**
 * Controller TreePopupMenu-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreePopupMenuController {

	protected MainModel model;
	private TreePopupMenu popupMenu;
	
	public TreePopupMenuController(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
		
		this.popupMenu.setAddNewListener(new AddNewNodeListener(model, popupMenu));
		this.popupMenu.setDeleteListener(new DeleteNodeListener(model, popupMenu));
		this.popupMenu.setRenameListener(new RenameNodeListener(model, popupMenu));
	}
}