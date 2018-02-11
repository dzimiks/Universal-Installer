package gui.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JOptionPane;

import gui.commands.AddNewModuleCommand;
import gui.commands.Invoker;
import gui.dialogs.ModuleDialog;
import gui.model.MainModel;
import gui.model.Module;
import gui.model.Software;
import gui.model.tree.Node;

/**
 * Listener za ok dugme ModuleDialog-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class ModuleDialogOkButtonListener implements ActionListener {

	private ModuleDialog dialog;
	private MainModel model;
	private static int counter = 0;
	
	public ModuleDialogOkButtonListener(ModuleDialog dialog, MainModel model) {
		this.dialog = dialog;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (dialog.getTfName() == null || dialog.getTfName().equals("")) {
			JOptionPane.showMessageDialog(null, "Molimo Vas, unesite naziv modula.", 
					model.getSelectedObject().toString(), JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if (dialog.getPath() == null || dialog.getPath().equals("")) {
			JOptionPane.showMessageDialog(null, "Molimo Vas, unesite ispravnu putanju do fajla.", 
					model.getSelectedObject().toString(), JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		File sourceFile = dialog.getSelectedFile();
		String s = sourceFile.getPath().toString();
		Invoker.getInstance().executeCommand(new AddNewModuleCommand(model, (Node) model.getSelectedObject()));
		Module node = (Module) model.getSelectedObject();
		node.setName(dialog.getTfName());
		
		new File("Resources", ((Software)node.getParent()).getName() + "/" + node.getName()).mkdirs();
		File destinationFile = new File("Resources/" + ((Software)node.getParent()).getName() + "/" + node.getName(), node.getName() + String.valueOf(this.counter++) +  
			"." + ((((Character) s.charAt(s.length() - 3)).equals('s')) ? s.charAt(s.length() - 4) : "" ) +s.charAt(s.length() - 3)
			+ s.charAt(s.length() - 2) + s.charAt(s.length() - 1));
		Path fromPath = sourceFile.toPath();
		Path toPath = destinationFile.toPath();
		
		try {
			Files.copy(fromPath, toPath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		node.setLocalPath(destinationFile.toPath().toString());
		dialog.setVisible(false);
	}

}
