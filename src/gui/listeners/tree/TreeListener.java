package gui.listeners.tree;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import gui.model.MainModel;

/**
 * Povezuje selekciju iz WorkspaceTree-a sa glavnim prozorom.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreeListener implements TreeSelectionListener {

	private MainModel model;
	
	public TreeListener(MainModel model) {
		this.model = model;
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		TreePath path = e.getPath();
		model.updateSelection(path);
	}
}