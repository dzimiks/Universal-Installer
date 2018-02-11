package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.Invoker;
import gui.commands.RenameCommand;
import gui.model.MainModel;
import gui.view.tree.TreePopupMenu;

/**
 * Listener za promenu imena cvora u stablu.
 * 
 * @author Vanja Paunovic
 *
 */
public class RenameNodeListener implements ActionListener {

	private MainModel model;
	private TreePopupMenu popupMenu;
	
	public RenameNodeListener(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker.getInstance().executeCommand(new RenameCommand(model, popupMenu.getSelectedNode()));
	}
}