	package gui.user;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.model.CopySoftware;

public class DobrodosliPanel extends JPanel{
	private ResourceBundle resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
	private String welcomeStr;

	public DobrodosliPanel(CopySoftware copySoftware) {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gBagConstraints = new GridBagConstraints();
		gBagConstraints.insets = new Insets(12, 5, 12, 5);
		
		setLayout(gridBagLayout);
		
		JLabel dobrodosliLabel = new JLabel();
		JButton dobrodosliButton =  new JButton(resourceBundle.getString("dobrodosliButton"));
		

		welcomeStr = resourceBundle.getString("welcomeStr");
		dobrodosliLabel.setText(welcomeStr +" "+ copySoftware.getName());
		
		dobrodosliButton.setMinimumSize(new Dimension(70,45));
		
		gBagConstraints.gridx = 0;
		gBagConstraints.gridy = 0;
		
		this.add(dobrodosliLabel,gBagConstraints);
		
		gBagConstraints.gridy = 1;
		
		this.add(dobrodosliButton, gBagConstraints);

		dobrodosliButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KorisnikView.getInstance().changeContentPane(new IzaberiModulePanel(copySoftware));
				
			}
		});
	}
}
