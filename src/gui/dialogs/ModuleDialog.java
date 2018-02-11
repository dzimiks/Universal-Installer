package gui.dialogs;

import java.io.File;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import gui.listeners.action.ModuleDialogCancelButtonListener;
import gui.listeners.action.ModuleDialogChooseFileListener;
import gui.listeners.action.ModuleDialogOkButtonListener;
import gui.model.MainModel;
import gui.view.MainView;


/**
 * Dijalog za dodavanje novog modula.
 * 
 * @author Vanja Paunovic
 *
 */
public class ModuleDialog extends JDialog implements Serializable {

	private static final long serialVersionUID = 1;
	
	private MainModel model;
	private JLabel name;
	private JTextField tfName;
	private JTextField path;
	private JButton chooseFile;
	private File selectedFile;
	
	public ModuleDialog(MainModel model) {
		super();
		this.model = model;
		
		setLayout(null);
		setResizable(false);
		setTitle("Dodaj novi modul");
		setSize(400, 170);
		setLocationRelativeTo(MainView.getInstance());
		initialize();
	}
	
	public void initialize() {
		
		name = new JLabel("Unesite naziv modula:");
		tfName = new JTextField();
		path = new JTextField();
		chooseFile = new JButton("Browse...");
		path.setEditable(false);
		
		chooseFile.addActionListener(new ModuleDialogChooseFileListener(this));
		
		name.setBounds(10, 10, 150, 25);
		tfName.setBounds(180, 10, 190, 25);
		path.setBounds(10, 50, 250, 25);
		chooseFile.setBounds(270, 50, 100, 25);
		
		JButton btnOk = new JButton("OK");
		JButton btnCancel = new JButton("Cancel");
		
		btnOk.setBounds(135, 100, 50, 25);
		btnCancel.setBounds(195, 100, 80, 25);
		
		btnOk.addActionListener(new ModuleDialogOkButtonListener(this, model));
		btnCancel.addActionListener(new ModuleDialogCancelButtonListener(this));
		
		add(name);
		add(tfName);
		add(path);
		add(chooseFile);
		add(btnOk);
		add(btnCancel);
	}

	public String getName() {
		return name.getText();
	}

	public void setName(String name) {
		this.name.setText(name);
	}

	public String getTfName() {
		return tfName.getText();
	}

	public void setTfName(String tfName) {
		this.tfName.setText(tfName);
	}

	public String getPath() {
		return path.getText();
	}

	public void setPath(String path) {
		this.path.setText(path);
	}

	public String getChooseFile() {
		return chooseFile.getText();
	}

	public void setChooseFile(JButton chooseFile) {
		this.chooseFile = chooseFile;
	}

	public File getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}
}