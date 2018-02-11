package gui.model;

import java.io.File;
import java.io.Serializable;

import gui.model.tree.Node;

/**
 * Predstavlja glavni cvor u WorkspaceTree koji sadrzi Softvere.
 * Postoji samo jedna instanca ove klase.
 * 
 * @author Vanja Paunovic
 *
 */
public class Workspace extends Node implements Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	private static Workspace instance = null;
	private static int newChildCount = 1;
	private File workspaceFile;
	
	public Workspace() {
		super("Workspace");
	}
	
	public static Workspace getInstance() {
		if (instance == null)
			instance = new Workspace();
		
		return instance;
	}
	
	private static int getNewChildCount() {
		return newChildCount++;
	}
	
	public File getWorkspaceFile() {
		return workspaceFile;
	}

	public void setWorkspaceFile(File workspaceFile) {
		this.workspaceFile = workspaceFile;
	}

	@Override
	public Node addNewChild() {
		Software child = new Software("Softver" + getNewChildCount());
		this.addChild(child);
		return child;
	}
}