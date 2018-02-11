package gui.view.tree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeSelectionModel;

import gui.constants.Constants;
import gui.controller.tree.TreeController;
import gui.model.MainModel;
import gui.model.Workspace;
import gui.model.tree.Node;
import gui.observer.MainObserver;
import gui.observer.NotificationObserver;


/**
 * Graficki prikaz WorkspaceTree-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreeView extends JPanel implements MainObserver {

	/**
	 * VersionUID za serijalizaciju
	 */
	private static final long serialVersionUID = 1;
	
	private MainModel model;
	private WorkspaceTree tree;
	private DefaultListModel<Node> freeNodesListModel;
	
	public TreeView(MainModel model) {
		this.model = model;
		this.model.addObserver(this);
		this.initialize();
		new TreeController(model, this);
	}
	
	/**
	 * Pravi celo stablo.
	 */
	private void initialize() {
		
		Node root = Workspace.getInstance();
		this.setPreferredSize(Constants.TREE_SIZE);
		
		DefaultTreeModel treeModel = new DefaultTreeModel(Workspace.getInstance());
		treeModel.setRoot(root);
		
		this.tree = new WorkspaceTree(this.model);
		this.tree.setModel(treeModel);
		
		TreeCellRendered tcr = new TreeCellRendered();
		this.tree.setCellRenderer(tcr);
		this.tree.setCellEditor(new TreeCellEditor(this.tree, tcr, this.model));
		this.tree.setEditable(true);
		this.tree.setShowsRootHandles(true);
		
		TreeSelectionModel selectionModel = new DefaultTreeSelectionModel();
		selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		this.tree.setSelectionModel(selectionModel);
		
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(1000, 1000));
		
		int height = Constants.TREE_VIEW_HEIGHT;
		
		JScrollPane treeScrollPane = new JScrollPane(tree);
		
		treeScrollPane.setSize(new Dimension(50, height));
		treeScrollPane.setMaximumSize(new Dimension(50, height));
		treeScrollPane.setMinimumSize(new Dimension(50, height));
		treeScrollPane.setPreferredSize(new Dimension(50, height));
		treeScrollPane.setAutoscrolls(true);
		
		this.add(treeScrollPane, BorderLayout.NORTH);
		
		freeNodesListModel = new DefaultListModel<>();

		this.reloadFreeNodesList();
		this.model.setTreeModel(treeModel);
	}
	
	/**
	 * Ponovo ucitava listu slobodnih cvorova.
	 */
	public void reloadFreeNodesList() {
		this.freeNodesListModel.removeAllElements();
		for (Node node : this.model.getFreeNodes()) {
			this.freeNodesListModel.addElement(node);
		}
	}

	public WorkspaceTree getTree() {
		return tree;
	}
	
	public Node getSelectedNode() {
		Object o = tree.getLastSelectedPathComponent();
		
		if (o instanceof Node) 
			return (Node) o;
		
		return null;
	}
	
	/**
	 * Dodaje listener na odgovarajucu stavku iz menija.
	 * 
	 * @param listener
	 * 			Listener koji ce biti dodat.
	 */
	public void addTreeListener(MouseListener listener) {
		this.tree.addMouseListener(listener);
	}
	
	@Override
	public void update(NotificationObserver notification, Object obj) {
		if (notification == NotificationObserver.FREE_NODES_CHANGED) 
			this.reloadFreeNodesList();
	}
}