package gui.view.tree;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import gui.listeners.tree.TreeListener;
import gui.model.MainModel;
import gui.model.Software;
import gui.model.tree.Node;
import gui.observer.MainObserver;
import gui.observer.NotificationObserver;

/*
 * Graficki prikaz svih Node-ova i njihove hijearhije.
 */
public class WorkspaceTree extends JTree implements MainObserver {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	
	MainModel model;
	
	public WorkspaceTree(MainModel model) {
		this.model = model;
		this.model.addObserver(this);
		addTreeSelectionListener(new TreeListener(model));
	}
	
	@Override
	protected void setExpandedState(TreePath path, boolean state) {
		Object o = path.getLastPathComponent();
		
		if (o instanceof Software && !((Software) o).isOpened()) {
			
		}
		else super.setExpandedState(path, state);
	}

	@Override
	public void update(NotificationObserver notification, Object obj) {
		
		switch (notification) {
			case TREE_SELECT:
				TreePath path = ((Node) obj).getPath();
				
				if (path != model.getSelectedPath())
					this.setSelectionPath(path);
				
				break;
			case TREE_RENAME:
				this.startEditingAtPath(((Node) obj).getPath());
				break;
			default:
				break;
		}
	}
}