package gui.dialogs;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gui.listeners.action.SoftwareDialogCancelButtonListener;
import gui.listeners.action.SoftwareDialogOkButtonListener;
import gui.model.MainModel;
import gui.view.MainView;

/**
 * Dijalog za dodavanje novog softvera.
 * 
 * @author Vanja Paunovic
 *
 */
public class SoftwareDialog extends JDialog implements Serializable {

	private static final long serialVersionUID = 1;

	private MainModel model;
	private JLabel name;
	private JTextField tfName;
	
	public SoftwareDialog(MainModel model) {
		super();
		this.model = model;
		
		setLayout(null);
		setResizable(false);
		setTitle("Dodaj novi softver");
		setSize(400, 170);
		setLocationRelativeTo(MainView.getInstance());
		initialize();
	}
	
	public void initialize() {
		
		name = new JLabel("Unesite naziv softvera:");
		tfName = new JTextField();

		name.setBounds(10, 10, 150, 25);
		tfName.setBounds(180, 10, 190, 25);
		
		JButton btnOk = new JButton("OK");
		JButton btnCancel = new JButton("Cancel");
		
		btnOk.setBounds(135, 100, 50, 25);
		btnCancel.setBounds(195, 100, 80, 25);
		
		btnOk.addActionListener(new SoftwareDialogOkButtonListener(this, model));
		btnCancel.addActionListener(new SoftwareDialogCancelButtonListener(this));
		
		add(name);
		add(tfName);
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
}
