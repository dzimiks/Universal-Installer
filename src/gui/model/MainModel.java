package gui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import gui.model.tree.Node;
import gui.observer.MainObserver;
import gui.observer.NotificationObserver;
import gui.observer.Observable;
import gui.observer.ObserverList;

/**
 * Glavni model MVC arhitekture.
 * 
 * @author Vanja Paunovic
 *
 */
public class MainModel implements Observable, Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	private static MainModel instance = null;

	/**
	 * Model WorkspaceTree. Koristi se da osvezi stablo.
	 */
	private DefaultTreeModel treeModel;
	
	/**
	 * ObserverList koji reaguje na svaku promenu podataka.
	 */
	private ObserverList observerList;
	
	/**
     * Node-ovi koji su uklonjeni iz WorkspaceTree, ali nisu obrisani.
     * Oni su sacuvani ovde dok cekaju da budu vraceni u stablo.
     */
    private List<Node> freeNodes;
	
	/**
	 * Cuva trenutno selektovan path u stablu.
	 */
	private TreePath selectedPath;

	
	private MainModel() {
		this.observerList = new ObserverList();
		this.freeNodes = new ArrayList<>();
	}
	
	@Override
	public void addObserver(MainObserver observer) {
		this.observerList.addObserver(observer);
	}

	/**
	 * Obavestava WorkspaceTree da selektuje cvor.
	 * 
	 * @param node
	 * 			Node koji ce biti selektovan.
	 */
	public void doTreeSelection(Node node) {
		this.observerList.notifyObservers(NotificationObserver.TREE_SELECT, node);
	}
	
	/**
	 * Obavestava WorkspaceTree da preimenuje cvor.
	 * 
	 * @param node
	 * 			Node koji ce biti preimenovan.
	 */
	public void doTreeRename(Node node) {
		this.observerList.notifyObservers(NotificationObserver.TREE_RENAME, node);
	}
	
	/**
	 * Azurira izabranu putanju do stabla.
	 * 
	 * @param path
	 * 			Novi selektovani TreePath.
	 */
	public void updateSelection(TreePath path) {
		this.observerList.notifyObservers(NotificationObserver.MAIN_VIEW_SELECT, path);
		selectedPath = path;
	}

	/**
     * Obavestava TreeView da osvezi slobodne cvorove.
     */
    public void doReloadFreeNodes() {
    	this.observerList.notifyObservers(NotificationObserver.FREE_NODES_CHANGED, null);
    }
	
	/**
	 * Vraca trenutno selektovan objekat.
	 * 
	 * @return Selektovan objekat.
	 */
	public Object getSelectedObject() {
		return selectedPath != null ? selectedPath.getLastPathComponent() : null;
	}
	
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public TreePath getSelectedPath() {
		return selectedPath;
	}

	/**
     * Vraca slobodne cvorove.
     * 
     * @return Prazan cvor.
     */
    public List<Node> getFreeNodes() {
    	return this.freeNodes;
    }

    /**
     * Proverava da li postoje slobodni cvorovi.
     * 
     * @return Da li postoje slobodni cvorovi.
     */
    public boolean hasFreeNodes() {
    	return !this.freeNodes.isEmpty();
    }
	
	public static MainModel getInstance() {
		if (instance == null){
			instance = new MainModel();
		}
		
		return instance;
	}
}