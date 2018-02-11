package gui.view.tree;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import gui.controller.tree.TreePopupMenuController;
import gui.model.MainModel;
import gui.model.Module;
import gui.model.Parameter;
import gui.model.Software;
import gui.model.Workspace;
import gui.model.tree.Node;

/**
 * PopupMenu koji sadrzi dogadjaje koji ce biti primenjeni na cvorove.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreePopupMenu extends JPopupMenu {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	private MainModel model;
	private TreePopupMenuController pmController;
	private Node node;
	private JMenuItem addNew;
	private JMenuItem delete;
	private JMenuItem rename;

	private HashMap<Class<? extends Object>, List<JMenuItem>> menuItems;
	
	public TreePopupMenu(MainModel model, Node node) {
		super();
		this.model = model;
		this.node = node;
		
		this.initialize();
		this.pmController = new TreePopupMenuController(this.model, this);
	}
	
	private void initialize() {
		this.addNew = new JMenuItem("Dodaj");
		this.delete = new JMenuItem("Obrisi");
		this.rename = new JMenuItem("Preimenuj");

		this.menuItems = new HashMap<Class<? extends Object>, List<JMenuItem>>();

		menuItems.put(Workspace.class, Arrays.asList(addNew));
		menuItems.put(Software.class, node.getClass() == Software.class && ((Software) node).isOpened()
						? Arrays.asList(addNew, rename, delete)
						: Arrays.asList(delete));
		menuItems.put(Module.class, Arrays.asList(addNew, rename, delete));
		menuItems.put(Parameter.class, Arrays.asList(rename, delete));

		if (this.menuItems.containsKey(node.getClass())) {
			for (JMenuItem item : this.menuItems.get(node.getClass()))
				this.add(item);
		} 
	}
	
	public Node getSelectedNode() {
		return this.node;
	}
	
	public void setAddNewListener(ActionListener listener) {
		this.addNew.addActionListener(listener);
	}
	
	public void setDeleteListener(ActionListener listener) {
		this.delete.addActionListener(listener);
	}

	public void setRenameListener(ActionListener listener) {
		this.rename.addActionListener(listener);
	}
}