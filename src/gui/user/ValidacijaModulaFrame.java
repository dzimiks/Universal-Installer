package gui.user;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ValidacijaModulaFrame extends JFrame{
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());

	public ValidacijaModulaFrame() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		JLabel selectModuleLbl = new JLabel(resourceBundle.getString("selectModuleLbl"));
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		panel.add(selectModuleLbl , gbc);
		
		JButton dugme = new JButton(resourceBundle.getString("jezikDugme"));
		
		gbc.gridy = 1;
		panel.add(dugme , gbc);
		
		this.add(panel);
		
		KorisnikView.getInstance().setEnabled(false);
		
		this.setSize(new Dimension(300, 200));
		this.setLocationRelativeTo(null);
		
		dugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				KorisnikView.getInstance().setEnabled(true);
				KorisnikView.getInstance().toFront();
				
			}
		});
	}
}
