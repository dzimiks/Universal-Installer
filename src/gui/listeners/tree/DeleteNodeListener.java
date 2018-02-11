package gui.listeners.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.commands.DeleteCommand;
import gui.commands.Invoker;
import gui.model.MainModel;
import gui.view.tree.TreePopupMenu;

/**
 * Listener za brisanje selektovanog cvora iz stabla.
 * 
 * @author Vanja Paunovic
 *
 */
public class DeleteNodeListener implements ActionListener {

	private MainModel model;
	private TreePopupMenu popupMenu;
	
	public DeleteNodeListener(MainModel model, TreePopupMenu popupMenu) {
		this.model = model;
		this.popupMenu = popupMenu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker.getInstance().executeCommand(new DeleteCommand(model, popupMenu.getSelectedNode()));
	}
}