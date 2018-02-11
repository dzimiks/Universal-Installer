package gui.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.dialogs.ModuleDialog;

/**
 * Listener za choose file dugme ModuleDialog-a.
 * 
 * @author Vanja Paunovic
 *
 */
public class ModuleDialogChooseFileListener implements ActionListener {

	private ModuleDialog dialog;
	
	public ModuleDialogChooseFileListener(ModuleDialog dialog) {
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Projects (.zip, .rar, .jar, .json)", "zip", "rar", "jar", "json");
		jfc.setFileFilter(filter);
		int returnVal = jfc.showDialog(new JDialog(), "OK");
		
		if (returnVal == JFileChooser.APPROVE_OPTION) 
			dialog.setPath(jfc.getSelectedFile().getPath());
			dialog.setSelectedFile(jfc.getSelectedFile());
	}
}