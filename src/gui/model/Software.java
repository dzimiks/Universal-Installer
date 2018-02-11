package gui.model;

import java.io.File;
import java.io.Serializable;

import gui.model.tree.Node;

/**
 * Cvor u stablu koji sadrzi module.
 * 
 * @author Vanja Paunovic
 *
 */
public class Software extends Node implements Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;

	private static int newChildCount = 1;
	private File softwareFile;
	private boolean opened;
	private String name;

	public Software(String name) {
		super();
		setName(name);
		this.opened = true;
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Node addNewChild() {
		Module child = new Module("Modul" + newChildCount);
		newChildCount++;
		this.addChild(child);

		return child;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	public File getSoftwareFile() {
		return softwareFile;
	}

	public void setSoftwareFile(File softwareFile) {
		this.softwareFile = softwareFile;
	}
}