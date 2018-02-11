package gui.model;

import java.io.Serializable;
import java.util.List;

import gui.dialogs.ParameterDialog;
import gui.model.tree.Node;

/**
 * Cvor u stablu koji sadrzi parametre.
 * 
 * @author Vanja Paunovic
 *
 */
public class Module extends Node implements Serializable {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	private static int newChildCount = 1;

	private String name;
	private String locakPath;

	public Module(String name) {
		super();
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalPath() {
		return locakPath;
	}

	public void setLocalPath(String path) {
		this.locakPath = path;
	}

	@Override
	public List<Node> getChildren() {
		return super.getChildren();
	}

	@Override
	public Node addNewChild() {
		Parameter child = new Parameter("Parametar" + newChildCount);
		child.setName(ParameterDialog.getInstance().getTfName());
		child.setType(ParameterDialog.getInstance().getCmbType());
		newChildCount++;
		this.addChild(child);
		return child;
	}
}