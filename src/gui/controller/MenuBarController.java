package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import gui.commands.DeleteCommand;
import gui.commands.Invoker;
import gui.commands.RenameCommand;
import gui.dialogs.ModuleDialog;
import gui.dialogs.ParameterDialog;
import gui.dialogs.SoftwareDialog;
import gui.json.WriteJsonFile;
import gui.model.CopySoftware;
import gui.model.MainModel;
import gui.model.Software;
import gui.model.tree.Node;
import gui.view.AboutFrame;
import gui.view.MenuBarView;

/**
 * Controller MenuBar-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class MenuBarController {

	public MainModel model;
	public MenuBarView menuBarView;
	public AboutFrame aboutFrame;
	public SoftwareDialog softwareDialog;
	public ModuleDialog moduleDialog;
	public ParameterDialog parameterDialog;
	
	public MenuBarController(MainModel model, MenuBarView menuBarView) {
		super();
		this.model = model;
		this.menuBarView = menuBarView;
		this.aboutFrame = AboutFrame.getInstance();
		this.softwareDialog = new SoftwareDialog(model);
		this.moduleDialog = new ModuleDialog(model);
		this.parameterDialog = ParameterDialog.getInstance();
	}
	
	public ActionListener getAddSoftwareListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				softwareDialog.setTfName("");
				softwareDialog.setVisible(true);
			}
		};
	}
	
	public ActionListener getAddModuleListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moduleDialog.setTfName("");
				moduleDialog.setPath("");
				moduleDialog.setVisible(true);
			}
		};
	}
	
	public ActionListener getAddParameterListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parameterDialog.setTfName("");
				parameterDialog.setVisible(true);
			}
		};
	}
	
	public ActionListener getDeleteActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = model.getSelectedObject();
				Invoker.getInstance().executeCommand(new DeleteCommand(model, (Node) obj));
			}
		};
	}
	
	public ActionListener getRenameActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = model.getSelectedObject();
				Invoker.getInstance().executeCommand(new RenameCommand(model, (Node) obj));
			}
		};
	}
	
	public ActionListener getAboutActionListener() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				aboutFrame.setVisible(true);
			}
		};
	}
	
	public ActionListener getExportListener(){
		return new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Software activeSoftware = (Software)model.getSelectedObject();
				CopySoftware copySoftware = new CopySoftware(activeSoftware);
				System.out.println(activeSoftware.toString());
				try {
					
					WriteJsonFile.writeJson(copySoftware);
					
				} catch (JsonGenerationException e1) {
					e1.printStackTrace();
				} catch (JsonMappingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		};
	}
}