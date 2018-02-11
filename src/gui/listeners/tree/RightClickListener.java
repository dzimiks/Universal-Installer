package gui.listeners.tree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import gui.model.MainModel;
import gui.model.tree.Node;
import gui.view.tree.TreePopupMenu;
import gui.view.tree.TreeView;
import gui.view.tree.WorkspaceTree;

/**
 * Otvara TreePopupMenu za selektovani cvor.
 * 
 * @author Vanja Paunovic
 *
 */
public class RightClickListener implements MouseListener {

	private MainModel model;
	private TreeView treeView;
	
	public RightClickListener(MainModel model, TreeView treeView) {
		this.model = model;
		this.treeView = treeView;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			WorkspaceTree tree = treeView.getTree();
			TreePath path = tree.getPathForLocation(e.getX(), e.getY());

			if (path == null)
				return;

			tree.setSelectionPath(path);

			TreePopupMenu tpm = new TreePopupMenu(model, (Node) tree.getLastSelectedPathComponent());
			tpm.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}