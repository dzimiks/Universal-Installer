package gui.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.commands.AddNewParameterCommand;
import gui.commands.Invoker;
import gui.listeners.action.ParameterDialogCancelButtonListener;
import gui.listeners.action.ParameterDialogOkButtonListener;
import gui.model.*;
import gui.model.Parameter;
import gui.model.tree.Node;
import gui.view.MainView;


/**
 * Dijalog za dodavanje novog parametra.
 * 
 * @author Vanja Paunovic
 *
 */
public class ParameterDialog extends JDialog implements Serializable {

	private static final long serialVersionUID = 1;
	private static ParameterDialog instance = null;
	
	private MainModel model;
	private JLabel name;
	private JTextField tfName;
	private JLabel type;
	private JComboBox<gui.model.Type> cmbType;
	
	private ParameterDialog() {
		super();
		this.model = MainModel.getInstance();
		
		setLayout(null);
		setResizable(false);
		setTitle("Dodaj novi parametar");
		setSize(420, 170);
		setLocationRelativeTo(MainView.getInstance());
		initialize();
	}
	
	public void initialize() {
		
		name = new JLabel("Unesite naziv parametra:");
		tfName = new JTextField();
		type = new JLabel("Izaberite tip parametra:");		
		cmbType = new JComboBox<gui.model.Type>(gui.model.Type.values());

		cmbType.setSelectedIndex(0);
		
		name.setBounds(30, 10, 170, 25);
		tfName.setBounds(210, 10, 160, 25);
		type.setBounds(30, 50, 170, 25);
		cmbType.setBounds(210, 50, 160, 25);
		
		JButton btnOk = new JButton("OK");
		JButton btnCancel = new JButton("Cancel");
		
		btnOk.setBounds(145, 100, 50, 25);
		btnCancel.setBounds(210, 100, 80, 25);
		
		// TODO opasno zeza
//		btnOk.addActionListener(new ParameterDialogOkButtonListener(model));
//		btnCancel.addActionListener(new ParameterDialogCancelButtonListener());
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTfName() == null || getTfName().equals("")) {
					JOptionPane.showMessageDialog(null, "Molimo Vas, unesite naziv parametra.", 
							model.getSelectedObject().toString(), JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				Invoker.getInstance().executeCommand(new AddNewParameterCommand(model, (Node) model.getSelectedObject()));
				Parameter node = (Parameter) model.getSelectedObject();

				node.setName(getTfName());
				setVisible(false);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		add(name);
		add(tfName);
		add(type);
		add(cmbType);
		add(btnOk);
		add(btnCancel);
	}

	public static ParameterDialog getInstance() {
		if (instance == null){
			instance = new ParameterDialog();
		}
		
		return instance;
	}

	public MainModel getModel() {
		return model;
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

	public gui.model.Type getCmbType() {
		return (gui.model.Type) cmbType.getSelectedItem();
	}

	public void setCmbType(gui.model.Type cmbType) {
		this.cmbType.addItem(cmbType);
	}
}