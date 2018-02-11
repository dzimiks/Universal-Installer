package gui.view.tree;

import java.awt.Component;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import gui.controller.tree.TreeCellEditorController;
import gui.model.MainModel;
import gui.model.Workspace;
import gui.model.tree.Node;

/**
 * Klasa koja se koristi za editovanje Node-ova.
 * 
 * @author Vanja Paunovic
 *
 */
public class TreeCellEditor extends DefaultTreeCellEditor {

	private Node node;
	private JTextField tfName;
	private MainModel model;
	
	/**
	 * Konstruktor koji unosi sve.
	 * 
	 * @param tree
	 * 			Stablo kojem pripada editor.
	 * @param cellRenderer
	 * 			Renderer celija stabla.
	 * @param model
	 * 			Glavni model.
	 */
	public TreeCellEditor(JTree tree, DefaultTreeCellRenderer cellRenderer, MainModel model) {
		super(tree, cellRenderer);
		this.tfName = new JTextField();
		this.model = model;
		new TreeCellEditorController(this, model);
	}
	
	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, 
												boolean expanded, boolean leaf, int row) {
		
		super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);

		this.node = (Node) value;
		this.tfName.setText(value.toString());
		
		return this.tfName;
	}
	
	public Node getNode() {
		return node;
	}
	
	public String getNameText() {
		return tfName.getText();
	}
	
	/**
	 * Dodaje listener odgovarajucoj stavki iz menija.
	 * 
	 * @param listener
	 * 			Listener koji ce biti dodat.
	 */
	public void setNameFocusListener(FocusListener listener) {
		this.tfName.addFocusListener(listener);
	}
	
	/**
	 * Proverava da li cvor moze da se preimenuje. 
	 */
	@Override
	public boolean isCellEditable(EventObject e) {

		Object selected = model.getSelectedObject();

		if (selected != null) {
			if (selected instanceof Workspace) 
				return false;
		}

		if (e == null) 
			return true;

		if (e instanceof MouseEvent) {
			if (((MouseEvent) e).getClickCount() == 2) 
				return true;
		}

		return false;
	}
}