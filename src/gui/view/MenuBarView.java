package gui.view;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import gui.constants.Constants;
import gui.controller.MenuBarController;
import gui.model.MainModel;


public class MenuBarView extends JMenuBar {
	
	/**
	 * VersionUID za serijalizaciju.
	 */
	private static final long serialVersionUID = 1;
	
	public MenuBarController menuBarController;
	public MainModel model;

	public MenuBarView(MainModel model) {
		
		this.model = model;
		menuBarController = new MenuBarController(model, this);
		
		JMenu file = new JMenu("File");
		JMenuItem addNewSoftware = new JMenuItem("Dodaj novi softver");
		JMenuItem addNewModule = new JMenuItem("Dodaj novi modul");
		JMenuItem addNewParameter = new JMenuItem("Dodaj novi parametar");
		JMenuItem exportProject = new JMenuItem("Eksportuj projekat");
		
		// Podesavanja za softver
		addNewSoftware.setIcon(new ImageIcon(Constants.SOFTWARE_ICON));
		addNewSoftware.setMnemonic(KeyEvent.VK_S);
		addNewSoftware.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		addNewSoftware.addActionListener(menuBarController.getAddSoftwareListener());
		addNewSoftware.setEnabled(true);
		
		// Podesavanja za modul
		addNewModule.setIcon(new ImageIcon(Constants.MODULE_ICON));
		addNewModule.setMnemonic(KeyEvent.VK_M);
		addNewModule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
		addNewModule.addActionListener(menuBarController.getAddModuleListener());
		addNewModule.setEnabled(false);
		
		// Podesavanja za parametre
		addNewParameter.setIcon(new ImageIcon(Constants.PARAMETER_ICON));
		addNewParameter.setMnemonic(KeyEvent.VK_P);
		addNewParameter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
		addNewParameter.addActionListener(menuBarController.getAddParameterListener());
		addNewParameter.setEnabled(false);
		
		// Podesavanja za eksportovanje
		exportProject.setIcon(new ImageIcon(Constants.EXPORT_ICON));
		exportProject.setMnemonic(KeyEvent.VK_E);
		exportProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		exportProject.addActionListener(menuBarController.getExportListener());
		
		file.setMnemonic(KeyEvent.VK_F);
		file.add(addNewSoftware);
		file.add(addNewModule);
		file.addSeparator();
		file.add(addNewParameter);
		file.addSeparator();
		file.add(exportProject);
		
		JMenu edit = new JMenu("Edit");
		JMenuItem renameItem = new JMenuItem("Preimenuj");
		JMenuItem deleteItem = new JMenuItem("Obrisi");
		
		// Podesavanja za preimenovanje cvora
		renameItem.setIcon(new ImageIcon(Constants.RENAME_ICON));
		renameItem.setMnemonic(KeyEvent.VK_R);
		renameItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		renameItem.addActionListener(menuBarController.getRenameActionListener());
		
		// Podesavanja za brisanje cvora
		deleteItem.setIcon(new ImageIcon(Constants.DELETE_ICON));
		deleteItem.setMnemonic(KeyEvent.VK_D);
		deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		deleteItem.addActionListener(menuBarController.getDeleteActionListener());
		
		edit.setMnemonic(KeyEvent.VK_E);
		edit.add(renameItem);
		edit.add(deleteItem);
		
		JMenu help = new JMenu("Pomoć");
		JMenuItem about = new JMenuItem("O nama");
		
		// Podesavanja za sekciju o timu
		about.setIcon(new ImageIcon(Constants.ABOUT_ICON));
		about.setMnemonic(KeyEvent.VK_O);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		about.addActionListener(menuBarController.getAboutActionListener());
		about.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		help.add(about);
		
		add(file);
		add(edit);
		add(help);
	}
}