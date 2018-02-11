package gui.panels.custom;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BirajPanel extends JPanel {

	private JComboBox<Addable> cmbAdd;
	private JButton btnDodaj;
	
	public BirajPanel(GlavniPanel panel) {

		cmbAdd = new JComboBox<>(Addable.values());

		cmbAdd.setSize(new Dimension(170, 30));

		btnDodaj = new JButton("Dodaj");
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Dijalog d = new Dijalog((Addable)cmbAdd.getSelectedItem(), panel);
				d.setLocationRelativeTo(null);
				d.setVisible(true);
				//panel.dodajStavku((Addable)cmbAdd.getSelectedItem());
			}
		});
		
		
		add(cmbAdd);
		add(btnDodaj);

	}

	public JComboBox<Addable> getCmbAdd() {
		return cmbAdd;
	}

	public void setCmbAdd(JComboBox<Addable> cmbAdd) {
		this.cmbAdd = cmbAdd;
	}

	public JButton getBtnDodaj() {
		return btnDodaj;
	}

	public void setBtnDodaj(JButton btnDodaj) {
		this.btnDodaj = btnDodaj;
	}

}
