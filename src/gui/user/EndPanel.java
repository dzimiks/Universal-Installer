package gui.user;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.view.MainView;

public class EndPanel extends JPanel{
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());

	public EndPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel finishedLabel = new JLabel(resourceBundle.getString("finishedLabel"));
		add(finishedLabel , gbc);
		
		gbc.gridy = 1;
		JLabel thanksLabel = new JLabel(resourceBundle.getString("thanksLabel"));
		add(thanksLabel , gbc);
		
		gbc.gridy = 2;
		JButton finishButton = new JButton(resourceBundle.getString("finishButton"));
		add(finishButton , gbc);
		
		finishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				KorisnikView.getInstance().dispose();
				MainView.getInstance().setEnabled(true);
				MainView.getInstance().toFront();
				
			}
		});
	}
}
