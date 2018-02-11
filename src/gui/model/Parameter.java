package gui.model;

import java.io.File;
import java.io.Serializable;

import gui.model.tree.Node;
import gui.panels.custom.GlavniPanel;

/**
 * List u stablu. Poslednji cvor koji nema dece.
 * 
 * @author Vanja Paunovic
 *
 */
public class Parameter extends Node implements Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;

	private String name;
	private Type type;
	private GlavniPanel component = new GlavniPanel();
	private String filepath;
	private String value;
	private File f = null;

	public Parameter(String name) {
		this.name = name;
	}

	public Parameter(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public GlavniPanel getComponent() {
		return component;
	}

	public void setComponent(GlavniPanel component) {
		this.component = component;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFilePath() {
		return filepath;
	}

	public void setFilePath(String filePath) {
		this.filepath = filePath;
	}

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}

}