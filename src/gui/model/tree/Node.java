package gui.model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import gui.observer.MainObserver;
import gui.observer.NotificationObserver;
import gui.observer.Observable;
import gui.observer.ObserverList;

/**
 * Predstavlja cvor u WorkspaceTree sa svim potrebnim funkcionalnostima.
 * 
 * @author Vanja Paunovic
 *
 */
public class Node implements MutableTreeNode, Observable, Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	
	private String name;
	protected Node parent;
	protected ArrayList<Node> children;
	protected transient ObserverList observerList;
	
	public Node() {
		this.parent = null;
		this.children = new ArrayList<>();
		this.observerList = new ObserverList();
		this.setName(null);
	}
	
	public Node(String name) {
		this();
		this.setName(name);
	}
	
	/**
	 * Dodaje Node u children cvorova.
	 * 
	 * @param childNode
	 * 			Node koji ce biti dodat.
	 */
	public void addChild(Node childNode) {
		childNode.parent = this;
		this.children.add(childNode);
		observerList.notifyObservers(NotificationObserver.ADD, childNode);
	}
	
	/**
	 * Vraca TreePath do cvora.
	 * 
	 * @return TreePath do cvora.
	 */
	public TreePath getPath() {
		
		TreeNode node = this;
		List<Object> nodes = new ArrayList<Object>();
		
		nodes.add(node);
		node = node.getParent();
		
		while (node != null) {
			nodes.add(0, node);
			node = node.getParent();
		}
		
		return nodes.isEmpty() ? null : new TreePath(nodes.toArray());
	}
	
	/**
	 * Pravi i dodaje novo dete Node.
	 * 
	 * @return Dodato dete Node.
	 */
	public Node addNewChild() {
		return null;
	}
	
	/**
	 * Pravi i dodaje novo dete NodeLink.
	 * 
	 * @param node
	 * 			Node koji se koristi za pravljenje NodeLink.
	 * 
	 * @return Dodati NodeLink.
	 */
	public Node addNewLinkChild(Node node) {
		return null;
	}
	
	/**
	 * Salje NotificationObserver i Object observerima Node-a.
	 * 
	 * @param notification
	 * 			Tip obavestenja.
	 * @param obj
	 * 			Podatak relevantan obavestenju.
	 */
	public void notifyObservers(NotificationObserver notification, Object obj) {
		observerList.notifyObservers(notification, obj);
	}
	
	@Override
	public Enumeration<Node> children() {
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int index) {
		return this.children.get(index);
	}

	@Override
	public int getChildCount() {
		return this.children.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return this.children.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return this.parent;
	}

	@Override
	public boolean isLeaf() {
		return this.children.size() == 0;
	}

	@Override
	public void addObserver(MainObserver observer) {
		observerList.addObserver(observer);
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
		this.children.add(index, (Node) child);
	}

	@Override
	public void remove(int index) {
		this.children.remove(index);
	}

	@Override
	public void remove(MutableTreeNode child) {
		this.children.remove(child);
	}

	@Override
	public void removeFromParent() {
		this.parent.remove(this);
		this.parent.observerList.notifyObservers(NotificationObserver.DELETE, this);
	}

	@Override
	public void setParent(MutableTreeNode parent) {
		this.parent = (Node) parent;
	}

	@Override
	public void setUserObject(Object obj) {
		
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.observerList.notifyObservers(NotificationObserver.NODE_RENAME, this);
	}

	public List<Node> getChildren() {
		return children;
	}

	/**
	 * Brise svu decu.
	 */
	public void clearChildren() {
		for (Node child : children)
			observerList.notifyObservers(NotificationObserver.DELETE, child);
		
		this.children.clear();
	}

	/**
	 * Inizijalizuje observerList, kao i decu Node-a.
	 */
	public void initObserverList() {
		this.observerList = new ObserverList();
		for (Node child : getChildren())
			child.initObserverList();
	}
}