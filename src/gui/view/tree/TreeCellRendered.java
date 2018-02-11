package gui.view.tree;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import gui.constants.Constants;
import gui.model.Module;
import gui.model.Parameter;
import gui.model.Software;
import gui.model.Workspace;

/**
 * Klasa koja renderuje i setuje ikonice Node-ova u WorkspaceTree.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreeCellRendered extends DefaultTreeCellRenderer {

	/**
	 * VersionUID za serijalizaciju.
	 */
	
	private static final long serialVersionUID = 1;

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, 
												  boolean expanded, boolean leaf, int row, boolean hasFocus) {

		super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		
		String iconPath = null;
		Icon icon = null;
		
		// TODO zasto ovo ne radi kako treba
		if (value instanceof Workspace)
			iconPath = "/menu-icons/new-workspace.png";
		else if (value instanceof Software)
			iconPath = "/menu-icons/new-software.png";
		else if (value instanceof Module)
			iconPath = "/menu-icons/new-module.png";
		else if (value instanceof Parameter)
			iconPath = "/menu-icons/new-parameter.png";

		try {
			if (iconPath != null) {
				icon = new ImageIcon(this.getClass().getResource(iconPath));
				this.setIcon(icon);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		this.setText(value.toString());
		
		return this;
	}
}