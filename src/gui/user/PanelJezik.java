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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import gui.model.CopyParameter;
import gui.model.CopySoftware;


public class PanelJezik extends JPanel{
	
	private ResourceBundle resourceBundle;
	
	private JLabel jezikLabel = new JLabel("Choose preferred language:");	
	private JButton jezikDugme = new JButton("OK");
	
	
	String[] s;
	String[] jezik = new String[]{
			"English" , "Srpski latinica" , "Српски ћирилица"
	};
	JComboBox<String> izaberiJezikCombo = new JComboBox<>();
	public PanelJezik(CopySoftware copySoftware , int modul) {
		
		izaberiJezikCombo.addItem(jezik[0]);
		izaberiJezikCombo.addItem(jezik[1]);
		izaberiJezikCombo.addItem(jezik[2]);
		
		izaberiJezikCombo.setEditable(false);
		izaberiJezikCombo.setMaximumSize(new Dimension(250, 45));
		izaberiJezikCombo.setMinimumSize(new Dimension(250, 45));
		izaberiJezikCombo.setAlignmentY(CENTER_ALIGNMENT);	
		jezikDugme.setAlignmentY(CENTER_ALIGNMENT);
		jezikDugme.setPreferredSize(new Dimension(70,35));
		
			
		izaberiJezikCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(izaberiJezikCombo.getSelectedItem().equals("English")){
					Locale.setDefault(new Locale("en","US"));
					updateLanguage();
				}
				else if(izaberiJezikCombo.getSelectedItem().equals("Srpski latinica")){
					Locale.setDefault(new Locale("sr","RS"));
					updateLanguage();
				}else{
					Locale.setDefault(new Locale("sr","Cyrl_RS"));
					updateLanguage();
				}
			}
		});
		
		jezikDugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KorisnikView.getInstance().changeContentPane(new DobrodosliPanel(copySoftware));
			}
		});
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints a = new GridBagConstraints();
		
		a.gridx = 0;
		a.gridy = 0;
		add(jezikLabel , a);
		c.insets = new Insets(10, 0, 10, 0);
		c.gridx = 0;
		c.gridy = 1;
		add(izaberiJezikCombo, c);
		a.gridx = 0;
		a.gridy = 2;
		add(jezikDugme, a);
		setSize(500, 500)
		;
		setMinimumSize(new Dimension(300, 300));
		
	}
	
	public void updateLanguage(){
		resourceBundle = ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
		jezikLabel.setText(resourceBundle.getString("jezikLabel"));
		jezikDugme.setText(resourceBundle.getString("jezikDugme"));
	}
}
