package gui.view;

import java.awt.Color;

import javax.swing.*;

import gui.constants.Constants;
import gui.controller.ToolBarController;
import gui.model.MainModel;

public class ToolBarView extends JToolBar {

	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	
	public MainModel model;
	public ToolBarController toolBarControler;

	public ToolBarView(MainModel model) {
		
		this.model = model;
		toolBarControler = new ToolBarController(model, this);
		
		JButton newSoftware = new JButton();
		newSoftware.setToolTipText("Dodaj novi softver");
		newSoftware.setIcon(new ImageIcon(Constants.SOFTWARE_ICON));
		newSoftware.addActionListener(toolBarControler.getAddSoftwareListener());
		newSoftware.setEnabled(true);
		
		JButton newModule = new JButton();
		newModule.setToolTipText("Dodaj novi modul");
		newModule.setIcon(new ImageIcon(Constants.MODULE_ICON));
		newModule.addActionListener(toolBarControler.getAddModuleListener());
		newModule.setEnabled(false);
		
		JButton newParameter = new JButton();
		newParameter.setToolTipText("Dodaj novi parametar");
		newParameter.setIcon(new ImageIcon(Constants.PARAMETER_ICON));
		newParameter.addActionListener(toolBarControler.getAddParameterListener());
		newParameter.setEnabled(false);
		
		JButton renameNode = new JButton();
		renameNode.setToolTipText("Preimenuj");
		renameNode.setIcon(new ImageIcon(Constants.RENAME_ICON));
		renameNode.addActionListener(toolBarControler.getRenameActionListener());
		
		JButton deleteNode = new JButton();
		deleteNode.setToolTipText("Obrisi");
		deleteNode.setIcon(new ImageIcon(Constants.DELETE_ICON));
		deleteNode.addActionListener(toolBarControler.getDeleteActionListener());
		
		JButton export = new JButton();
		export.setToolTipText("Eksportuj projekat");
		export.setIcon(new ImageIcon(Constants.EXPORT_ICON));
		export.addActionListener(toolBarControler.getExportListener());
		
		add(newSoftware);
		add(newModule);
		add(newParameter);
		addSeparator();
		add(renameNode);
		add(deleteNode);
		addSeparator();
		add(export);
		
		setFloatable(false);
		setBackground(new Color(192, 192, 192));
	}
}